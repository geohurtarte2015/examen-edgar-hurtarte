package com.examen.edgarhurtarte.billing.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.examen.edgarhurtarte.billing.model.Cliente;
import com.examen.edgarhurtarte.billing.model.Live;
import com.examen.edgarhurtarte.billing.service.ClienteService;

@RestController
public class ClienteController {
	
	private static final String template = "Is  %s!";
    private final AtomicLong counter = new AtomicLong();
	
	
	 @Autowired
	 private ClienteService clienteService;
		
	 	//alive
	 @RequestMapping(value="/cliente/isalive", method=RequestMethod.GET)
	    public Live live(@RequestParam(value="name", defaultValue="a Live!") String name) {
	        return new Live(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
	 	
	 	//update cliente with json values
	 @RequestMapping(value="/cliente/{id}", method=RequestMethod.PUT)
	    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente){
		 	System.out.println("Updating Cliente " + id);
		 	
		 	Cliente currentCliente = clienteService.findCliente(id);
		 	
		 	if (currentCliente==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	        }
		 	
		 	clienteService.update(id,cliente);
		 	
			return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK); 
	    }
	 	
	 	//create new cliente
	 @RequestMapping(value="/cliente/", method=RequestMethod.POST)
	    public ResponseEntity<Void> createCliente(@RequestBody Cliente cliente,    UriComponentsBuilder ucBuilder){
		 	System.out.println("Create Cliente " + cliente.getNombre());
		 			 	
		 	 clienteService.save(cliente);
		 	
		 	HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	    }
	 	
	 	//delete cliente
	 @RequestMapping(value="/cliente/{id}", method=RequestMethod.DELETE)
	    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") long id){
		 	System.out.println("Updating Cliente " + id);
		 	
		 	Cliente currentCliente = clienteService.findCliente(id);
		 	
		 	if (currentCliente==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	        }
		 	
		 	clienteService.delete(id);
		 	
			return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK); 
	    }
	 	
	 	//find by Id cliente
	 	@RequestMapping(value="/cliente/{id}", method=RequestMethod.GET)
	    public ResponseEntity<Cliente> findIdCliente(@PathVariable("id") long id){
		 	System.out.println("Find Id Cliente " + id);
		 	
		 	Cliente currentCliente = clienteService.findCliente(id);
		 	
		 	if (currentCliente==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	        }
		 	
			return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK); 
	    }
	 

}
