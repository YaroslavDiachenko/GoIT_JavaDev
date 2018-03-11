package com.mycompany.app.controller;

import com.mycompany.app.model.Manufacturer;
import com.mycompany.app.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.UUID;

@Controller
public class ManufacturerController {
    private ManufacturerService manufacturerService;

    @Autowired(required = true)
    @Qualifier(value = "manufacturerService")
    public void setManufacturerService(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
    public String listManufacturers(Model model){
        model.addAttribute("manufacturers", this.manufacturerService.listManufacturers());
        return "manufacturers";
    }

    @RequestMapping(value = "/manufacturers/add", method = RequestMethod.GET)
    public String addManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        model.addAttribute("manufacturers", this.manufacturerService.listManufacturers());
        model.addAttribute("action", "add");
        return "manufacturers";
    }

    @RequestMapping(value = "/manufacturers/add", method = RequestMethod.POST)
    public String addManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer){
        this.manufacturerService.addManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }

    @RequestMapping(value = "/manufacturers/edit/{id}", method = RequestMethod.GET)
    public String editManufacturer(@PathVariable("id") UUID id, Model model){
        model.addAttribute("manufacturer", this.manufacturerService.getManufacturerById(id));
        model.addAttribute("manufacturers", this.manufacturerService.listManufacturers());
        model.addAttribute("action", "edit");
        return "manufacturers";
    }

    @RequestMapping(value = "/manufacturers/edit", method = RequestMethod.POST)
    public String editManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer){
        this.manufacturerService.updateManufacturer(manufacturer);
        return "redirect:/manufacturers";
    }

    @RequestMapping("/manufacturers/remove/{id}")
    public String removeManufacturer(@PathVariable("id") UUID id){
        this.manufacturerService.removeManufacturer(id);
        return "redirect:/manufacturers";
    }
}