package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.SizeNotFondException;
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
    public String saveSizes(Sizes sizes){
        sizesRepository.save(sizes);
        return "New sizes has added";
    }

    @Override
    public List<Sizes> getAllSizes(){
        return sizesRepository.findAll();
    }

    @Override
    public Sizes getSizesByID(Integer id_size) {
        return sizesRepository.findById(id_size).orElseThrow(()-> new SizeNotFondException(id_size));
    }

    @Override
    public Sizes updateSizes(Sizes newSize, Integer id_size) {
        return sizesRepository.findById(id_size).map(sizes -> {
            sizes.setSize(newSize.getSize());
            return sizesRepository.save(sizes);
        }).orElseThrow(()->new SizeNotFondException(id_size));
    }

    @Override
    public String deleteSizes(Integer id_size) {
        if (!sizesRepository.existsById(id_size)){
            throw new SizeNotFondException(id_size);
        }
        sizesRepository.deleteById(id_size);
        return "Size with id " + id_size + " has been deleted success";
    }
}
