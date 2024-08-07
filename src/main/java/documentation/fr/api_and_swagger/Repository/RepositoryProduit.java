package documentation.fr.api_and_swagger.Repository;

import documentation.fr.api_and_swagger.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface RepositoryProduit extends JpaRepository<Produit, Long> {
}
