package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Null;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImpTest {
	
	@MockBean
	private ProduitRepository prodrep;
	
	@Autowired
	 ProduitServiceImpl prodservImp;
	
	@Autowired
	IProduitService iprodser;
	@Autowired
	StockServiceImpl stockservImp;
	
	
	@Test
	public void testDeleteProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("16/06/2022");
	    Produit pr = new Produit(1L, "112", "libelle", (float)5.500, null, null, null, null, null);
		Produit produit =iprodser.addProduit(pr);
	    iprodser.deleteProduit(produit.getIdProduit());
		assertNull(iprodser.retrieveProduit(produit.getIdProduit()));
	}

	
	

}
