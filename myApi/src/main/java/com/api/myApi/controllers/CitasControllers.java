package com.api.myApi.controllers;

import com.api.myApi.models.Citas;
import com.api.myApi.services.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Citas")
public class CitasControllers {

    @Autowired
    private CitasService citasService;

    @GetMapping
    public ArrayList<Citas> getCitas() {
        return this.citasService.getCitas();
    }

    @PostMapping
    public Citas saveCitas(@RequestBody Citas citas) {
        return this.citasService.saveCitas(citas);
    }

    @GetMapping(path = "/{id}")
    public Optional<Citas> getCitasById(@PathVariable Long id) {
        return this.citasService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Citas updateCitasById(@RequestBody Citas request, @PathVariable Long id) {
        return this.citasService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.citasService.deleteCita(id);

        if (ok) {
            return "Cita con id " + id + " eliminada!";
        } else {
            return "Error al eliminar la cita con id " + id;
        }
    }
}