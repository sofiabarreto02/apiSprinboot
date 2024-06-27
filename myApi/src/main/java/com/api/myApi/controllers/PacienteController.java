package com.api.myApi.controllers;

import com.api.myApi.models.Paciente;
import com.api.myApi.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    @PostMapping
    public Paciente savePaciente(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @GetMapping(path = "/{id}")
    public Optional<Paciente> getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    @PutMapping(path = "/{id}")
    public Paciente updatePacienteById(@RequestBody Paciente paciente, @PathVariable Long id) {
        return pacienteService.updatePacienteById(paciente, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePacienteById(@PathVariable("id") Long id) {
        boolean ok = pacienteService.deletePaciente(id);

        if (ok) {
            return "Paciente con id " + id + " eliminado!";
        } else {
            return "Error al eliminar el paciente con id " + id;
        }
    }
}

