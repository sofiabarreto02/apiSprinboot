package com.api.myApi.controllers;

import com.api.myApi.models.Doctor;
import com.api.myApi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Doctores")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctores() {
        return doctorService.getAllDoctores();
    }

    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping(path = "/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping(path = "/{id}")
    public Doctor updateDoctorById(@RequestBody Doctor doctor, @PathVariable Long id) {
        return doctorService.updateDoctorById(doctor, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteDoctorById(@PathVariable("id") Long id) {
        boolean ok = doctorService.deleteDoctor(id);

        if (ok) {
            return "Doctor con id " + id + " eliminado!";
        } else {
            return "Error al eliminar el doctor con id " + id;
        }
    }
}

