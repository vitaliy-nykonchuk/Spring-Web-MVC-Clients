package org.example.app.repository.impl;

import org.example.app.entity.Client;
import org.example.app.repository.BaseRepository;

import java.util.List;


public interface ClientRepository extends BaseRepository<Client> {
    void save(Client client);
    List<Client> fetchAll();
    Client fetchById(Long id);
    void delete(Long id);
}
