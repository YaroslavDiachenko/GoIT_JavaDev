package com.mycompany.app.service;

import com.mycompany.app.model.Manufacturer;

import java.util.List;
import java.util.UUID;

public interface ManufacturerService {
    public void addManufacturer(Manufacturer book);

    public void updateManufacturer(Manufacturer book);

    public void removeManufacturer(UUID id);

    public Manufacturer getManufacturerById(UUID id);

    public List<Manufacturer> listManufacturers();
}
