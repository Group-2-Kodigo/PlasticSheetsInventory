package com.inventory.Inventory.controller;

import com.inventory.Inventory.exception.ColorNotFoundException;
import com.inventory.Inventory.model.Colors;
import com.inventory.Inventory.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
@CrossOrigin
public class ColorController {
@Autowired
    private ColorRepository colorRepository;
    @PostMapping("/add")
    public String add (@RequestBody Colors colors){
        colorRepository.save(colors);
        return "new Color added";
    }
    @GetMapping("/color")
    List<Colors> getAllColors(){
        return colorRepository.findAll();
    }

    @GetMapping("/color/{id}")
    Colors getColorById(@PathVariable int id_color) {
        return colorRepository.findById(id_color)
                .orElseThrow(()->new ColorNotFoundException(id_color));
    }

    @PutMapping("/color/{id}")
    Colors updateColor(@RequestBody Colors newColors, @PathVariable Integer id_color){
        return colorRepository.findById(id_color)
                .map(colors -> {
                    colors.setColor(newColors.getColor());
                    return colorRepository.save(colors);
                }).orElseThrow(()->new ColorNotFoundException(id_color));
    }

    @DeleteMapping("/color/{id}")
    String deleteColor (@PathVariable Integer id_color){
        if (!colorRepository.existsById(id_color)){
            throw new ColorNotFoundException(id_color);
        }
        colorRepository.deleteById(id_color);
        return "Color con id "+id_color+ " ha sido eliminado correctamente.";
    }
}
