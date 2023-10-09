package org.example.app.service.impl;

import org.example.app.entity.Client;
import org.example.app.service.BaseService;

import java.util.List;

public interface ClientService extends BaseService<Client> {
    void save(Client client);
    List<Client> fetchAll();
    Client fetchById(Long id);
    void delete(Long id);
}
