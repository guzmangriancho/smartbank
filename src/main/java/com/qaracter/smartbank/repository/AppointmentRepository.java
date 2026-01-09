package com.qaracter.smartbank.repository;

import com.qaracter.smartbank.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AppointmentRepository {
    private final Map<Long, Appointment> appointments = new HashMap<>();
    private long idCounter = 1;

    public Appointment save(Appointment appointment) {
        if (appointment.getId() == null) {
            appointment.setId(idCounter++);
        }
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments.values());
    }

    public Appointment findById(Long id) {
        return appointments.get(id);
    }

    public List<Appointment> findByCustomerId(Long customerId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments.values()) {
            if (appointment.getCustomerId().equals(customerId)) {
                result.add(appointment);
            }
        }
        return result;
    }

    public void deleteById(Long id) {
        appointments.remove(id);
    }
}