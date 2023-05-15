package com.inventory.Inventory.controller;

import com.inventory.Inventory.exception.ColorNotFoundException;
import com.inventory.Inventory.model.Colors;
import com.inventory.Inventory.repository.ColorRepository;
import com.inventory.Inventory.service.ColorsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
@CrossOrigin
public class ColorController {
    @Autowired
    private ColorsService colorsService;

    @PostMapping("/add")
    @Operation(summary = "add a new color")
    public String add(@RequestBody Colors colors) {
        return colorsService.saveColors(colors);
    }

    @GetMapping("/getAll")
    public List<Colors> getAllColors() {
        return colorsService.getAllCollors();
    }

    @GetMapping("/getColorByID/{id_color}")
    @Operation(summary = "Get colors by ID")
    public Colors getColorById(@PathVariable int id_color) {
        return colorsService.getColorsById(id_color);
    }

    @PutMapping("/updateColor/{id_color}")
    @Operation(summary = "update an existing color")
    public Colors updateColor(@RequestBody Colors newColors, @PathVariable Integer id_color) {
        return colorsService.updateColors(newColors, id_color);
    }

    @DeleteMapping("/deleteColor/{id_color}")
    @Operation(summary = "delete a color by ID")
    public String deleteColor(@PathVariable Integer id_color) {
        return colorsService.deleteColors(id_color);
    }
}
