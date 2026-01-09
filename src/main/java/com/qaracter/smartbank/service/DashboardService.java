package com.qaracter.smartbank.service;

import com.qaracter.smartbank.repository.AppointmentRepository;
import com.qaracter.smartbank.repository.CustomerRepository;
import com.qaracter.smartbank.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private AppointmentRepository appointmentRepo;
    @Autowired
    private SupportTicketRepository ticketRepo;

    public int getCustomerCount() {
        return customerRepo.findAll().size();
    }

    public int getAppointmentCount() {
        return appointmentRepo.findAll().size();
    }

    public int getOpenTicketCount() {
        return ticketRepo.findByStatus("OPEN").size();
    }
}