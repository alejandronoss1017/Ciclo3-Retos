package com.misiontic.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.misiontic.reto3.model.Client;
import com.misiontic.reto3.repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public Client save(Client c) {
        return clientCrudRepository.save(c);
    }

    public void delete(Client c) {
        clientCrudRepository.delete(c);
    }
}
