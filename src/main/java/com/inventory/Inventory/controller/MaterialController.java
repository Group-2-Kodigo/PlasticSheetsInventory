package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Materials;
import com.inventory.Inventory.service.MaterialService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
@CrossOrigin
@OpenAPIDefinition
@Configuration
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping("/add")
    public String add(@RequestBody Materials materials){
        materialService.saveMaterial(materials);
        return "New Material added";
    }

    @GetMapping("/getAll")
    public List<Materials> getAllMaterial(){
        return materialService.getAllMaterial();
    }

    @GetMapping("/getmaterialsbyid/{id_material}")
    public Materials getMaterialById(@PathVariable Integer id_material){
        return materialService.getMaterialById(id_material);
    }

    @PutMapping("/updatematerial/{id_material}")
    public Materials updateMaterial(@RequestBody Materials newmaterial, @PathVariable Integer id_material){
        return materialService.updateMaterial(newmaterial, id_material);
    }

    @DeleteMapping("/deletematerial/{id_material}")
    public String deleteMaterial(@PathVariable Integer id_material){
        return materialService.deleteMaterial(id_material);
    }
}
