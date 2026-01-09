package com.qaracter.smartbank.repository;

import com.qaracter.smartbank.model.SupportTicket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SupportTicketRepository {
    private final Map<Long, SupportTicket> tickets = new HashMap<>();
    private long idCounter = 1;

    public SupportTicket save(SupportTicket ticket) {
        if (ticket.getId() == null) {
            ticket.setId(idCounter++);
        }
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public List<SupportTicket> findAll() {
        return new ArrayList<>(tickets.values());
    }

    public SupportTicket findById(Long id) {
        return tickets.get(id);
    }

    public List<SupportTicket> findByStatus(String status) {
        List<SupportTicket> result = new ArrayList<>();
        for (SupportTicket ticket : tickets.values()) {
            if (status.equalsIgnoreCase(ticket.getStatus())) {
                result.add(ticket);
            }
        }
        return result;
    }
}