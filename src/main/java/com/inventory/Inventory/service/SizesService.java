package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Sizes;

import java.util.List;

public interface SizesService {

    Sizes saveSizes(Sizes sizes);

    public List<Sizes> getAllSizes();

    Sizes getSizesByID(Integer id_size);

    Sizes updateSizes(Sizes newSize, Integer id_size);

    String deleteSizes(Integer id_size);
}
