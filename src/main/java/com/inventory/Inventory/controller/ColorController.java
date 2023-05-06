package com.inventory.Inventory.controller;

import com.inventory.Inventory.exception.ColorNotFoundException;
import com.inventory.Inventory.model.Colors;
import com.inventory.Inventory.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColorController {
@Autowired
    private ColorRepository colorRepository;
    @PostMapping("/color")
    Colors newColor(@RequestBody Colors newColors){
        return colorRepository.save(newColors);
    }

    @GetMapping("/color")
    List<Colors> getAllColors(){
        return colorRepository.findAll();
    }

    @GetMapping("/color/{id}")
    Colors getColorById(@PathVariable Long id) {
        return colorRepository.findById(id)
                .orElseThrow(()->new ColorNotFoundException(id));
    }

    @PutMapping("/color/{id}")
    Colors updateColor(@RequestBody Colors newColors, @PathVariable Long id){
        return colorRepository.findById(id)
                .map(colors -> {
                    colors.setColor(newColors.getColor());
                    return colorRepository.save(colors);
                }).orElseThrow(()->new ColorNotFoundException(id));
    }

    @DeleteMapping("/color/{id}")
    String deleteColor (@PathVariable Long id){
        if (!colorRepository.existsById(id)){
            throw new ColorNotFoundException(id);
        }
        colorRepository.deleteById(id);
        return "Color con id "+id+ " ha sido eliminado correctamente.";
    }
}
