package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Sizes;
import org.hibernate.engine.jdbc.Size;

import java.util.List;

public interface SizesService {

    Sizes saveSizes(Sizes sizes);

    public List<Sizes> getAllSizes();
}
