package com.inventory.Inventory.service;

import com.inventory.Inventory.model.StatusU;

import java.util.List;

public interface StatusService {

    String saveStatus(StatusU statusU);

    public List<StatusU> getAllStatus();

    StatusU getStatusById(Integer id_status);

    StatusU updateStatus(StatusU newStatus, Integer id_status);

    String deleteStatus(Integer id_status);

}
