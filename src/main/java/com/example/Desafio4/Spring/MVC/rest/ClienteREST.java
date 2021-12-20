package com.example.Desafio4.Spring.MVC.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Desafio4.Spring.MVC.model.Cliente;
import com.example.Desafio4.Spring.MVC.service.ClienteService;

@RestController
@RequestMapping ("/api/cliente/")
public class ClienteREST {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	private ResponseEntity<Cliente> guardar (@RequestBody Cliente cliente){
		Cliente temporal = clienteService.saveCliente(cliente);
		
		try {
			return ResponseEntity.created(new URI("/api/cliente"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Cliente>> listarTodasLasPersona (){
		return ResponseEntity.ok(clienteService.getAllClientes());
	}
	
	@GetMapping (value = "nombre")
	private ResponseEntity<Optional<Cliente>> listarClientes (
			@RequestParam (name = "name") String name,
			@RequestParam (name = "surname1") String surname1,
			@RequestParam (name = "surname2") String surname2){
		return ResponseEntity.ok(clienteService.getClienteByName(name, surname1, surname2));
	}
	

}

