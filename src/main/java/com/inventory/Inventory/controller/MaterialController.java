package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Material;
import com.inventory.Inventory.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
@CrossOrigin
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping("/add")
    public String add(@RequestBody Material material){
        materialService.saveMaterial(material);
        return "New Material added";
    }

    @GetMapping("/getAll")
    public List<Material> getAllMaterial(){
        return materialService.getAllMaterial();
    }

    @GetMapping("/getmaterialsbyid/{id_material}")
    public Material getMaterialById(@PathVariable Integer id_material){
        return materialService.getMaterialById(id_material);
    }

    @PutMapping("/updatematerial/{id_material}")
    public Material updateMaterial(@RequestBody Material newmaterial, @PathVariable Integer id_material){
        return materialService.updateMaterial(newmaterial, id_material);
    }

    @DeleteMapping("/deletematerial/{id_material}")
    public String deleteMaterial(@PathVariable Integer id_material){
        return materialService.deleteMaterial(id_material);
    }
}
