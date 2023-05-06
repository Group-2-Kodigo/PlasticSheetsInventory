package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.ClientEmailNotFoundException;
import com.inventory.Inventory.exception.ClientNotFoundException;
import com.inventory.Inventory.exception.InvalidEmailException;
import com.inventory.Inventory.exception.InvalidPhoneNumberException;
import com.inventory.Inventory.model.Clients;
import com.inventory.Inventory.repository.ClientsRepository;
import com.inventory.Inventory.validators.EmailValidator;
import com.inventory.Inventory.validators.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public String saveClients(Clients clients) {
        if (!EmailValidator.isValidEmail(clients.getEmail())){
            throw new InvalidEmailException(clients.getEmail());
        }
        if (!PhoneNumberValidator.isValidPhoneNumber(clients.getPhoneNumber())){
            throw new InvalidPhoneNumberException(clients.getPhoneNumber());
        }
        clientsRepository.save(clients);
        return "New Client has added";
    }

    @Override
    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Clients getClientByID(Integer id_client) {
        return clientsRepository.findById(id_client).orElseThrow(()-> new ClientNotFoundException(id_client));
    }

    @Override
    public Clients updateClient(Clients newClient, Integer id_client) {
        if (!PhoneNumberValidator.isValidPhoneNumber(newClient.getPhoneNumber())){
            throw new InvalidPhoneNumberException(newClient.getPhoneNumber());
        }
        if (!EmailValidator.isValidEmail(newClient.getEmail())){
            throw new InvalidEmailException(newClient.getEmail());
        }
        return clientsRepository.findById(id_client).map(clients -> {
            clients.setClientName(newClient.getClientName());
            clients.setPhoneNumber(newClient.getPhoneNumber());
            clients.setEmail(newClient.getEmail());
            return clientsRepository.save(clients);
        }).orElseThrow(()-> new ClientNotFoundException(id_client));
    }

    @Override
    public String deleteClient(Integer id_client) {
        if (!clientsRepository.existsById(id_client)){
            throw new ClientNotFoundException(id_client);
        }
        clientsRepository.deleteById(id_client);
        return "Client with id " + id_client + " has been deleted success";
    }

    @Override
    public Clients findByEmail(String email) {
        Clients client = clientsRepository.findByEmail(email);
        if (client == null) {
            throw new ClientEmailNotFoundException(email);
        }
        return client;
    }
}
