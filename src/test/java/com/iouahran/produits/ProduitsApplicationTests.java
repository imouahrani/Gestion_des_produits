package com.iouahran.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iouahran.produits.repos.ProduitRepository;
import com.iouahran.produits.entities.Produit;
import com.iouahran.produits.entities.Categorie;

@SpringBootTest
class ProduitsApplicationTests {
	/* *************************************
	 * tester l'application avant l'implémentation de la couche service
	*/

	// autowired : injection de dépendance : injecter un objet dans la bdd
	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC HP", 800.200, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		// optionnal on ajoute un get()
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(700.0);
		produitRepository.save(p);
		System.out.println(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);

	}

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	/* *************************************
	 * tester l'application après l'implémentation de la couche service
	*/

	// terter les méthodes des services créés après les avoir ajoutées sur ProduitRepository.java car avant y'avait juste le corp de la classe
	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testFindByNomProduitContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("Dell");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("PC Dell2", 2200.0);
		for (Produit p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

}