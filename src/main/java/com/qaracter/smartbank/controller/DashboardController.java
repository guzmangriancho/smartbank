package com.qaracter.smartbank.controller;

import com.qaracter.smartbank.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping
    public Map<String, Integer> getSummary() {
        Map<String, Integer> summary = new HashMap<>();

        summary.put("totalCustomers", service.getCustomerCount());
        summary.put("totalAppointments", service.getAppointmentCount());
        summary.put("openTickets", service.getOpenTicketCount());

        return summary;
    }
}