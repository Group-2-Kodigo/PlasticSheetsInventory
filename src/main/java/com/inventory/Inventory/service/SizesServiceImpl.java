package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Sizes;
import com.inventory.Inventory.repository.SizesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizesServiceImpl implements SizesService {

    @Autowired
    private SizesRepository sizesRepository;

    @Override
    public Sizes saveSizes(Sizes sizes){
        return sizesRepository.save(sizes);
    }

    @Override
    public List<Sizes> getAllSizes(){
        return sizesRepository.findAll();
    }
}
