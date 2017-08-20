package com.examen.edgarhurtarte.billing.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.edgarhurtarte.billing.model.Cliente;
import com.examen.edgarhurtarte.billing.repository.ClienteRepository;


@Service
@Transactional
public class ClienteService {
	

	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		
		this.clienteRepository = clienteRepository;
				
	}
	
	
	public List<Cliente> findAllClientes(){		
		return clienteRepository.findAll();
	}
	
	public Cliente findCliente(long id) {		
		return clienteRepository.findOne(id);
	}
	
	
	public void save(Cliente cliente) {		
		clienteRepository.save(cliente);
	}
	
	public void delete(long id) {		
		clienteRepository.delete(id);
	}
	
	
	public Cliente update(long id,Cliente cliente) {
		Cliente newCliente = clienteRepository.findOne(id);		
		
		newCliente.update(id, cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getFechaNacimiento(), cliente.getTelefono(), cliente.getEmail());
		clienteRepository.saveAndFlush(newCliente);		
		return newCliente;
	}

}