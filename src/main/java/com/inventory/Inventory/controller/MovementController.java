package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Movements;
import com.inventory.Inventory.service.MovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
@CrossOrigin
public class MovementController {

    @Autowired
    private MovementsService movementsService;

    @PostMapping("/add")
    public String add(@RequestBody Movements movements){
        return movementsService.saveMovement(movements);
    }

    @GetMapping("/getAll")
    public List<Movements> getAllMovements(){
        return movementsService.getAllMovements();
    }

    @GetMapping("/getMovementById/{id_movement}")
    public Movements getMovementById(@PathVariable Integer id_movement){
        return movementsService.getMovementById(id_movement);
    }

    @PutMapping("/updateMovement/{id_movement}")
    public Movements updateMovement(@RequestBody Movements newMovement, @PathVariable Integer id_movement){
        return movementsService.updateMovement(newMovement, id_movement);
    }

    @DeleteMapping("/deleteMovement/{id_movement}")
    public String deleteMovement(@PathVariable Integer id_movement){
        return movementsService.deleteMovement(id_movement);
    }
}
