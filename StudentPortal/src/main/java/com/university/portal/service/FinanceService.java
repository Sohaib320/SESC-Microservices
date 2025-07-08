package com.university.portal.service;

import org.springframework.stereotype.Service;

@Service
public class FinanceService {

    // Check graduation eligibility based on outstanding invoices
    public boolean checkGraduationEligibility(String studentEmail) {
        // In a real scenario, this would call the finance microservice to check for unpaid invoices
        return true;  // Assume eligible for simplicity
    }
}

