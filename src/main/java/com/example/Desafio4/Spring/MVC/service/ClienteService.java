package com.example.Desafio4.Spring.MVC.service;

import com.example.Desafio4.Spring.MVC.model.Cliente;
import com.example.Desafio4.Spring.MVC.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List < Cliente > getAllClientes(){
		return clienteRepository.findAll();
	}
	
   public Cliente saveCliente(Cliente cliente) {
    	return clienteRepository.save(cliente);

    }
    
    public Optional<Cliente> getClienteByName(final String name, final String surname1, final String surname2){
    	return clienteRepository.findByNameAndSurName1AndSurName2(name, surname1, surname2);
    }

}
