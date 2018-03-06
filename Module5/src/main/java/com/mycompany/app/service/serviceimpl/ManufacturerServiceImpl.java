package com.mycompany.app.service.serviceimpl;

import com.mycompany.app.dao.ManufacturerDao;
import com.mycompany.app.model.Manufacturer;
import com.mycompany.app.service.ManufacturerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private ManufacturerDao manufacturerDao;

    public void setManufacturerDao(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    @Override
    @Transactional
    public void addManufacturer(Manufacturer manufacturer) {
        this.manufacturerDao.add(manufacturer);
    }

    @Override
    @Transactional
    public void updateManufacturer(Manufacturer manufacturer) {
        this.manufacturerDao.update(manufacturer);
    }

    @Override
    @Transactional
    public void removeManufacturer(UUID id) {
        this.manufacturerDao.remove(id);
    }

    @Override
    @Transactional
    public Manufacturer getManufacturerById(UUID id) {
        return this.manufacturerDao.getById(id);
    }

    @Override
    @Transactional
    public List<Manufacturer> listManufacturers() {
        return this.manufacturerDao.listAll();
    }
}
