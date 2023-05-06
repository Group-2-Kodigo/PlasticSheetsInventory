package com.inventory.Inventory.controller;

import com.inventory.Inventory.exception.ColorNotFoundException;
import com.inventory.Inventory.model.Color;
import com.inventory.Inventory.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColorController {
@Autowired
    private ColorRepository colorRepository;
    @PostMapping("/color")
    Color newColor(@RequestBody Color newColor){
        return colorRepository.save(newColor);
    }

    @GetMapping("/color")
    List<Color> getAllColors(){
        return colorRepository.findAll();
    }

    @GetMapping("/user/{id}")
    Color getColorById(@PathVariable Long id) {
        return colorRepository.findById(id)
                .orElseThrow(()->new ColorNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    Color updateColor(@RequestBody Color newColor, @PathVariable Long id){
        return colorRepository.findById(id)
                .map(color -> {
                    color.setColor(newColor.getColor());
                    return colorRepository.save(color);
                }).orElseThrow(()->new ColorNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteColor (@PathVariable Long id){
        if (!colorRepository.existsById(id)){
            throw new ColorNotFoundException(id);
        }
        colorRepository.deleteById(id);
        return "Color con id "+id+ " ha sido eliminado correctamente.";
    }
}
