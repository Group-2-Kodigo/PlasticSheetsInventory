package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.StatusU;
import com.inventory.Inventory.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping("/add")
    public String add(@RequestBody StatusU statusU){
        return statusService.saveStatus(statusU);
    }

    @GetMapping("/getAll")
    public List<StatusU> getAllStatus(){
        return statusService.getAllStatus();
    }

    @GetMapping("/getStatusByID/{id_status}")
    public StatusU getStatusById(@PathVariable Integer id_status){
        return statusService.getStatusById(id_status);
    }

    @PutMapping("/updateStatus/{id_status}")
    public StatusU updateStatus(@RequestBody StatusU newStatus, @PathVariable Integer id_status){
        return statusService.updateStatus(newStatus, id_status);
    }

    @DeleteMapping("/deleteStatus/{id_status}")
    public String deleteStatus(@PathVariable Integer id_status){
        return statusService.deleteStatus(id_status);
    }
}
