package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.StatusNotFoundException;
import com.inventory.Inventory.model.StatusU;
import com.inventory.Inventory.repository.StatusURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusURepository statusURepository;
    @Override
    public String saveStatus(StatusU statusU) {
        statusURepository.save(statusU);
        return "New status has added";
    }

    @Override
    public List<StatusU> getAllStatus() {
        return statusURepository.findAll();
    }

    @Override
    public StatusU getStatusById(Integer id_status) {
        return statusURepository.findById(id_status).orElseThrow(() -> new StatusNotFoundException(id_status));
    }

    @Override
    public StatusU updateStatus(StatusU newStatus, Integer id_status) {
        return statusURepository.findById(id_status).map(statusU -> {
            statusU.setStatusName(newStatus.getStatusName());
            return statusURepository.save(statusU);
        }).orElseThrow(() -> new StatusNotFoundException(id_status));
    }

    @Override
    public String deleteStatus(Integer id_status) {
        if (!statusURepository.existsById(id_status)){
            throw new StatusNotFoundException(id_status);
        }
        statusURepository.deleteById(id_status);
        return "Status with id "+ id_status + " has been deleted success";
    }
}
