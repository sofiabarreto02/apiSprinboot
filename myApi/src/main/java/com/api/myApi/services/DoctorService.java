package com.api.myApi.services;

import com.api.myApi.models.Doctor;
import com.api.myApi.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctores() {
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor updateDoctorById(Doctor request, Long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setName(request.getName());
            doctor.setLastName(request.getLastName());
            doctor.setEspecialidad(request.getEspecialidad());
            return doctorRepository.save(doctor);
        }
        return null;
    }

    public Boolean deleteDoctor(Long id) {
        try {
            doctorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

