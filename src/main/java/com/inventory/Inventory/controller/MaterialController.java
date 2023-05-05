package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Material;
import com.inventory.Inventory.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
