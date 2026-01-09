package com.qaracter.smartbank.controller;

import com.qaracter.smartbank.model.Appointment;
import com.qaracter.smartbank.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return service.createAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return service.getAppointmentById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Appointment> getAppointmentsByCustomer(@PathVariable Long customerId) {
        return service.getAppointmentsByCustomer(customerId);
    }

    @PutMapping("/{id}/status")
    public Appointment updateAppointmentStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateAppointmentStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable Long id) {
        service.cancelAppointment(id);
    }
}