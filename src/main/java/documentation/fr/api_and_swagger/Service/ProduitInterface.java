package documentation.fr.api_and_swagger.Service;

import documentation.fr.api_and_swagger.Model.Produit;

import java.util.List;

public interface ProduitInterface {

    List<Produit> getAllProduits();
    Produit getProduitById(Long id);
    Produit createProduit(Produit produit);
    Produit updateProduit(Long id, Produit produit);
    void deleteProduit(Long id);
}
