package com.api.myApi.services;

import com.api.myApi.models.Paciente;
import com.api.myApi.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente updatePacienteById(Paciente request, Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            Paciente paciente = optionalPaciente.get();
            paciente.setName(request.getName());
            paciente.setLastName(request.getLastName());
            paciente.setAge(request.getAge());
            paciente.setTelefono(request.getTelefono());
            paciente.setEmail(request.getEmail());
            paciente.setBirthDate(request.getBirthDate());
            paciente.setSex(request.getSex());
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public Boolean deletePaciente(Long id) {
        try {
            pacienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

