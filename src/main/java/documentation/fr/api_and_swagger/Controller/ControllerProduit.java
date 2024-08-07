package documentation.fr.api_and_swagger.Controller;

import documentation.fr.api_and_swagger.Model.Produit;
import documentation.fr.api_and_swagger.Service.ProduitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/produits")

public class ControllerProduit {

    private ProduitService produitService;


    @Operation(summary = "Get all produits", description = "Retrieve a list of all produits")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of produits")
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }


    @Operation(summary = "Get a produit by ID", description = "Retrieve a produit by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved produit"),
            @ApiResponse(responseCode = "404", description = "Produit not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.getProduitById(id);
        if (produit != null) {
            return ResponseEntity.ok(produit);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new produit", description = "Create a new produit with the provided details")
    @ApiResponse(responseCode = "200", description = "Successfully created produit")
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    @Operation(summary = "Update an existing produit", description = "Update the details of an existing produit by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated produit"),
            @ApiResponse(responseCode = "404", description = "Produit not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        Produit updatedProduit = produitService.updateProduit(id, produit);
        if (updatedProduit != null) {
            return ResponseEntity.ok(updatedProduit);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete a produit", description = "Delete a produit by its ID")
    @ApiResponse(responseCode = "204", description = "Successfully deleted produit")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }

}
