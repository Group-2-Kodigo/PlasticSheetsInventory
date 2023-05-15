package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.ClientNotFoundException;
import com.inventory.Inventory.exception.MovementNotFoundException;
import com.inventory.Inventory.model.Movements;
import com.inventory.Inventory.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovementsServiceImpl implements MovementsService {

    @Autowired
    private MovementRepository movementRepository;

    @Override
    public String saveMovement(Movements movements) {
        movementRepository.save(movements);
        return "New movement has added";
    }

    @Override
    public List<Movements> getAllMovements() {
        return movementRepository.findAll();
    }

    @Override
    public Movements getMovementById(Integer id_movement) {
        return movementRepository.findById(id_movement).orElseThrow(()-> new MovementNotFoundException(id_movement));
    }

    @Override
    public Movements updateMovement(Movements newMovement, Integer id_movement) {
        return movementRepository.findById(id_movement).map(movements -> {
            movements.setMovement(newMovement.getMovement());
            return movementRepository.save(movements);
        }).orElseThrow(()-> new MovementNotFoundException(id_movement));
    }

    @Override
    public String deleteMovement(Integer id_movement) {
        if (!movementRepository.existsById(id_movement)){
            throw new MovementNotFoundException(id_movement);
        }
        movementRepository.deleteById(id_movement);
        return "Movement with id " + id_movement + " has been deleted success";
    }
}
