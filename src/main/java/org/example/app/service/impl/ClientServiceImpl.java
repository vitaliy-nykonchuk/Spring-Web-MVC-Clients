package org.example.app.service.impl;

import jakarta.transaction.Transactional;
import org.example.app.entity.Client;
import org.example.app.repository.impl.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Override
    @Transactional
    public void save(Client client) {
        repository.save(client);
    }

    @Override
    @Transactional
    public List<Client> fetchAll() {
        return repository.fetchAll();
    }

    @Override
    @Transactional
    public Client fetchById(Long id) {
        return repository.fetchById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }
}
