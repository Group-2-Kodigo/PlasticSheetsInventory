package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Sizes;
import com.inventory.Inventory.repository.SizesRepository;
import com.inventory.Inventory.service.SizesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sizes")
@CrossOrigin
public class SizesController {
    @Autowired
    private SizesService sizesService;

    @PostMapping("/add")
    public String add(@RequestBody Sizes sizes){
        sizesService.saveSizes(sizes);
        return "New sizes has added";
    }

    @GetMapping("/getAll")
    public List<Sizes> getAllSizes(){
        return sizesService.getAllSizes();
    }
}
