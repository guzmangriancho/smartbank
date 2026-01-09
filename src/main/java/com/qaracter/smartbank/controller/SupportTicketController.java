package com.qaracter.smartbank.controller;

import com.qaracter.smartbank.model.SupportTicket;
import com.qaracter.smartbank.service.SupportTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketService service;

    @PostMapping
    public SupportTicket createTicket(@RequestBody SupportTicket ticket) {
        return service.createTicket(ticket);
    }

    @PutMapping("/{id}/assign")
    public SupportTicket assignTicket(@PathVariable Long id, @RequestParam String employee) {
        return service.assignTicket(id, employee);
    }

    @PutMapping("/{id}/status")
    public SupportTicket updateTicketStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateTicketStatus(id, status);
    }

    @GetMapping("/open")
    public List<SupportTicket> getOpenTickets() {
        return service.getOpenTickets();
    }
}