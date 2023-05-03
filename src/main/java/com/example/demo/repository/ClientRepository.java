package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	
	List<Client> findByEmail(String email);

}
