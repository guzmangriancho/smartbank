package com.qaracter.smartbank.service;

import com.qaracter.smartbank.exception.EmployeeNotFoundException;
import com.qaracter.smartbank.exception.SupportTicketNotFoundException;
import com.qaracter.smartbank.model.SupportTicket;
import com.qaracter.smartbank.repository.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository repository;

    public SupportTicket createTicket(SupportTicket ticket) {
        if (ticket.getStatus() == null) {
            ticket.setStatus("OPEN");
        }
        return repository.save(ticket);
    }

    public SupportTicket assignTicket(Long ticketId, String employeeName) {
        if (employeeName == null) {
            throw new EmployeeNotFoundException("Employee name cannot be empty");
        }

        SupportTicket ticket = repository.findById(ticketId);
        if (ticket == null) {
            throw new SupportTicketNotFoundException("Ticket not found");
        }

        ticket.setAssignedTo(employeeName);
        return repository.save(ticket);
    }

    public SupportTicket updateTicketStatus(Long ticketId, String newStatus) {
        SupportTicket ticket = repository.findById(ticketId);
        if (ticket == null) {
            throw new SupportTicketNotFoundException("Ticket not found");
        }
        ticket.setStatus(newStatus);
        return repository.save(ticket);
    }

    public List<SupportTicket> getOpenTickets() {
        return repository.findByStatus("OPEN");
    }
}