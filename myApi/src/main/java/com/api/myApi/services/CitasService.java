package com.api.myApi.services;

import com.api.myApi.models.Citas;
import com.api.myApi.repositories.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CitasService {


    @Autowired
    CitasRepository citasRepositories;

    public ArrayList<Citas> getCitas() {
        return (ArrayList<Citas>) citasRepositories.findAll();
    }

    public Citas saveCitas(Citas citas) {
        return citasRepositories.save(citas);
    }

    public Optional<Citas> getById(Long id) {
        return citasRepositories.findById(id);
    }

    public Citas updateById(Citas request, Long id) {
        Optional<Citas> optionalCita = citasRepositories.findById(id);
        if (optionalCita.isPresent()) {
            Citas citas = optionalCita.get();
            citas.setNamePaciente(request.getNamePaciente());
            citas.setLastNamePaciente(request.getLastNamePaciente());
            citas.setAge(request.getAge());
            citas.setTelefono(request.getTelefono());
            citas.setEmail(request.getEmail());
            citas.setBirthDate(request.getBirthDate());
            citas.setSex(request.getSex());
            citas.setTipoDeCita(request.getTipoDeCita());
            citas.setNombreDoctor(request.getNombreDoctor());
            citas.setFechaCita(request.getFechaCita());
            return citasRepositories.save(citas);
        }
        return null;
    }

    public Boolean deleteCita(Long id) {
        try {
            citasRepositories.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}