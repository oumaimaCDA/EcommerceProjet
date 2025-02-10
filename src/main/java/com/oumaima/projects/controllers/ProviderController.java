package com.oumaima.projects.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oumaima.projects.entity.Provider;
import com.oumaima.projects.repository.ProviderRepository;


@RestController
@RequestMapping("provider")
public class ProviderController {

	@Autowired
	private ProviderRepository providerespo ;
	
	


@PostMapping("/add")
public String ajouter(@RequestBody Provider p) {
	this.providerespo.save(p);
	return "enregistrer avec succées";
}

@GetMapping("/afficher")
public List<Provider>afficher(){
	 return this.providerespo.findAll();
}

@GetMapping("/afficherbyid/{id}")
public Provider afficherbyid(@PathVariable Long id){
	Provider p= this.providerespo.findById(id).get();
	 return p;
}

@DeleteMapping("/delete/{id}")
public String supprimer(@PathVariable Long id) {
	Provider p = this.providerespo.findById(id).get();
	 this.providerespo.delete(p);
	 return "Provider supprimer avec succées";
}

@PutMapping("/update/{id}")
public Provider modifier(@PathVariable Long id,  @RequestBody Provider provider) {
	Provider p1 = this.providerespo.findById(id).get();
	 if(p1 !=null) { 
		 provider.setId(id);
	 this.providerespo.save(p1);
	 return providerespo.saveAndFlush(provider);

}
	 else
	 {
	 	 throw new RuntimeException("FAIL");
	 }

}

}

