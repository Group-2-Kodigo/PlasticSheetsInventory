package com.inventory.Inventory.service;

import com.inventory.Inventory.exception.ColorNotFoundException;
import com.inventory.Inventory.model.Colors;
import com.inventory.Inventory.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColorsServiceImpl implements ColorsService{

    @Autowired
    private ColorRepository colorRepository;
    @Override
    public String saveColors(Colors colors) {
        colorRepository.save(colors);
        return "new Color added";
    }

    @Override
    public List<Colors> getAllCollors() {
        return colorRepository.findAll();
    }

    @Override
    public Colors getColorsById(Integer id_color) {
        return colorRepository.findById(id_color).orElseThrow(()-> new ColorNotFoundException(id_color));
    }

    @Override
    public Colors updateColors(Colors newColor, Integer id_color) {
        return colorRepository.findById(id_color).map(colors -> {
            colors.setColor(newColor.getColor());
            return colorRepository.save(colors);
        }).orElseThrow(()->new ColorNotFoundException(id_color));
    }

    @Override
    public String deleteColors(Integer id_color) {
        if (!colorRepository.existsById(id_color)){
            throw new ColorNotFoundException(id_color);
        }
        colorRepository.deleteById(id_color);
        return "Size with id " + id_color + " has been deleted success";
    }
}
