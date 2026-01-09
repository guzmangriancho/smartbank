package com.qaracter.smartbank.service;

import com.qaracter.smartbank.exception.AppointmentNotFound;
import com.qaracter.smartbank.exception.InvalidAppointmentException;
import com.qaracter.smartbank.model.Appointment;
import com.qaracter.smartbank.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Appointment createAppointment(Appointment appointment) {
        if (appointment.getCustomerId() == null || appointment.getDateTime() == null
                || appointment.getType() == null || appointment.getStatus() == null) {
            throw new InvalidAppointmentException("Invalid data");
        }
        return repository.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        Appointment appointment = repository.findById(id);
        if (appointment == null) {
            throw new AppointmentNotFound("Appointment not found with ID: " + id);
        }
        return appointment;
    }

    public List<Appointment> getAppointmentsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public Appointment updateAppointmentStatus(Long id, String newStatus) {
        Appointment appointment = getAppointmentById(id);
        appointment.setStatus(newStatus);
        return repository.save(appointment);
    }

    public void cancelAppointment(Long id) {
        getAppointmentById(id);
        repository.deleteById(id);
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }
}