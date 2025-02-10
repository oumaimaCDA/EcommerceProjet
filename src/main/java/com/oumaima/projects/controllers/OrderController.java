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

import com.oumaima.projects.entity.Order;
import com.oumaima.projects.repository.OrderRepository;


@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderrespo ;



@PostMapping("/add")
public String ajouter(@RequestBody Order o) {
	this.orderrespo.save(o);
	return "enregistrer avec succées";
}

@GetMapping("/afficher")
public List<Order>afficher(){
	 return this.orderrespo.findAll();
}

@GetMapping("/afficherbyid/{id}")
public Order afficherbyid(@PathVariable Long id){
	Order o= this.orderrespo.findById(id).get();
	 return o;
}

@DeleteMapping("/delete/{id}")
public String supprimer(@PathVariable Long id) {
	Order o = this.orderrespo.findById(id).get();
	 this.orderrespo.delete(o);
	 return "Order supprimer avec succées";
}

@PutMapping("/update/{id}")
public Order modifier(@PathVariable Long id,  @RequestBody Order order) {
	Order o = this.orderrespo.findById(id).get();
	 if(o !=null) { 
		 order.setId(id);
	 this.orderrespo.save(o);
	 return orderrespo.saveAndFlush(order);

}
	 else
	 {
	 	 throw new RuntimeException("FAIL");
	 }

}

}


