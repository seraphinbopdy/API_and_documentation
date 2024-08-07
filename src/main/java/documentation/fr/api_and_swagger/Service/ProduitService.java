package documentation.fr.api_and_swagger.Service;


import documentation.fr.api_and_swagger.Model.Produit;
import documentation.fr.api_and_swagger.Repository.RepositoryProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class ProduitService implements ProduitInterface{

    private RepositoryProduit repositoryProduit;

    public List<Produit> getAllProduits(){
        return repositoryProduit.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        Optional<Produit> produit = repositoryProduit.findById(id);
        return produit.orElse(null);
    }

    @Override
    public Produit createProduit(Produit produit) {
        return repositoryProduit.save(produit);
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        Optional<Produit> existingProduit = repositoryProduit.findById(id);

        if (existingProduit.isPresent()){
            Produit updateProduit = existingProduit.get();

            updateProduit.setCodeProduit(produit.getCodeProduit());
            updateProduit.setNameProduit(produit.getNameProduit());
            updateProduit.setPrix(produit.getPrix());
            Produit saveProduit = repositoryProduit.save(updateProduit);
            return saveProduit;
        }
        return null;
    }

    @Override
    public void deleteProduit(Long id) {
        repositoryProduit.deleteById(id);
    }


}
