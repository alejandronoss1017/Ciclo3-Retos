package com.misiontic.reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.reto3.model.Client;
import com.misiontic.reto3.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client p) {
        if (p.getIdClient() == null) {
            return clientRepository.save(p);
        } else {
            Optional<Client> e = clientRepository.getClient(p.getIdClient());
            if (e.isPresent()) {

                return p;
            } else {
                return clientRepository.save(p);
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> q = clientRepository.getClient(client.getIdClient());
            if (q.isPresent()) {
                if (client.getEmail() != null) {
                    q.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    q.get().setPassword(client.getPassword());
                }
                if (client.getName() != null) {
                    q.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    q.get().setAge(client.getAge());
                }
                clientRepository.save(q.get());
                return q.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Client> p = clientRepository.getClient(id);
        if (p.isPresent()) {
            clientRepository.delete(p.get());
            flag = true;
        }
        return flag;

    }

}
