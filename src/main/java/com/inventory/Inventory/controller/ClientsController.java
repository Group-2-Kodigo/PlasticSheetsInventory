package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Clients;
import com.inventory.Inventory.model.StatusU;
import com.inventory.Inventory.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin
public class ClientsController {
    @Autowired
    private ClientsService clientsService;

    @PostMapping("/add")
    public String add(@RequestBody Clients clients){
        return clientsService.saveClients(clients);
    }

    @GetMapping("/getAll")
    public List<Clients> getAllClients(){
        return clientsService.getAllClients();
    }

    @GetMapping("/getClientsById/{id_client}")
    public Clients getClientsById(@PathVariable Integer id_client){
        return clientsService.getClientByID(id_client);
    }

    @PutMapping("/updateClient/{id_client}")
    public Clients updateClient(@RequestBody Clients newClient, @PathVariable Integer id_client){
        return clientsService.updateClient(newClient, id_client);
    }

    @DeleteMapping("/deleteClient/{id_client}")
    public String deleteClient(@PathVariable Integer id_client){
        return clientsService.deleteClient(id_client);

    }

    @GetMapping("/getByEmail/{email}")
    public Clients getClientByEmail(@PathVariable String email){
        return clientsService.findByEmail(email);
    }
}
