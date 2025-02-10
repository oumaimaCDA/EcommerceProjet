package com.oumaima.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oumaima.projects.entity.Subcategory;
import com.oumaima.projects.repository.SubcategoryRepository;

@Controller
@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {
	
	@Autowired
	private SubcategoryRepository subcategoryrepo ;
	
	@PostMapping("/add")
	public String ajouter(@RequestBody Subcategory cat) {
		this.subcategoryrepo.save(cat);
		return "enregistrer avec succées";
	}
	
	
	/*
	 * @GetMapping("/all") public List<Category> getallcategory(){ return
	 * CategoryServiceImp.getAllCategory(); }
	 */
	
	@GetMapping("/afficher")
	public List<Subcategory>afficher(){
		 return this.subcategoryrepo.findAll();
	}

@DeleteMapping("/delete/{id}")
public String delete(@PathVariable Long id) {
	Subcategory u = this.subcategoryrepo.findById(id).get();
	 this.subcategoryrepo.delete(u);
	 return "category supprimer avec succées";
}

@PutMapping("/update/{id}")
public Subcategory update(@PathVariable Long id,  @RequestBody Subcategory subcategory) {
	Subcategory c = this.subcategoryrepo.findById(id).get();
	 if(c !=null) { 
		 subcategory.setId(id);
	 this.subcategoryrepo.save(c);
	 return subcategoryrepo.saveAndFlush(subcategory);

}
	 else
	 {
	 	 throw new RuntimeException("FAIL");
	 }

}
}



