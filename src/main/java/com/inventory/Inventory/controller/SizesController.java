package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Sizes;
import com.inventory.Inventory.repository.SizesRepository;
import com.inventory.Inventory.service.SizesService;
import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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

    @GetMapping("/{id_size}")
    public Sizes getSizeById(@PathVariable Integer id_size){
        return sizesService.getSizesByID(id_size);
    }

    @PutMapping("/{id_size}")
    public Sizes updateSize(@RequestBody Sizes newSize, @PathVariable Integer id_size){
        return sizesService.updateSizes(newSize, id_size);
    }

    @DeleteMapping("/{id_size}")
    public String deleteSize(@PathVariable Integer id_size){
        return sizesService.deleteSizes(id_size);
    }
}
