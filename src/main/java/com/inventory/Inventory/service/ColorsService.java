package com.inventory.Inventory.service;

import com.inventory.Inventory.model.Colors;

import java.util.List;

public interface ColorsService {

    Colors saveColors(Colors colors);

    public List<Colors> getAllCollors();

    Colors getColorsById (Integer id_color);

    Colors updateColors(Colors newColor, Integer id_color);

    String deleteColors(Integer id_color);


}
