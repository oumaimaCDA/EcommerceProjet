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


import com.oumaima.projects.entity.User;
import com.oumaima.projects.repository.UserRepository;



@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserRepository userrespo ;

@PostMapping("/ajouter")
public String ajouter(@RequestBody User u) {
	this.userrespo.save(u);
	return "enregistrer avec succées";
}

@GetMapping("/afficher")
public List<User>afficher(){
	 return this.userrespo.findAll();
}

@GetMapping("/afficherbyid/{id}")
public User afficherbyid(@PathVariable Long id){
	 User u= this.userrespo.findById(id).get();
	 return u;
}

@DeleteMapping("/supprimer/{id}")
public String supprimer(@PathVariable Long id) {
	 User u = this.userrespo.findById(id).get();
	 this.userrespo.delete(u);
	 return "user supprimer avec succées";
}

@PutMapping("/modifier/{id}")
public User modifier(@PathVariable Long id,  @RequestBody User user) {
	 User u = this.userrespo.findById(id).get();
	 if(u !=null) { 
		 user.setId(id);
	 this.userrespo.save(u);
	 return userrespo.saveAndFlush(user);

}
	 else
	 {
	 	 throw new RuntimeException("FAIL");
	 }

}

}
