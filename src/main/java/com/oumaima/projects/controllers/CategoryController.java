
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

import com.oumaima.projects.entity.Category;
import com.oumaima.projects.repository.CategoryRepository;


@Controller
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryrepo ;
	
	@PostMapping("/add")
	public String ajouter(@RequestBody Category cat) {
		this.categoryrepo.save(cat);
		return "enregistrer avec succées";
	}
	
	
	/*
	 * @GetMapping("/all") public List<Category> getallcategory(){ return
	 * CategoryServiceImp.getAllCategory(); }
	 */
	
	@GetMapping("/afficher")
	public List<Category>afficher(){
		 return this.categoryrepo.findAll();
	}

@DeleteMapping("/delete/{id}")
public String delete(@PathVariable Long id) {
	 Category u = this.categoryrepo.findById(id).get();
	 this.categoryrepo.delete(u);
	 return "category supprimer avec succées";
}

@PutMapping("/update/{id}")
public Category update(@PathVariable Long id,  @RequestBody Category category) {
	Category c = this.categoryrepo.findById(id).get();
	 if(c !=null) { 
		 category.setId(id);
	 this.categoryrepo.save(c);
	 return categoryrepo.saveAndFlush(category);

}
	 else
	 {
	 	 throw new RuntimeException("FAIL");
	 }

}
}
