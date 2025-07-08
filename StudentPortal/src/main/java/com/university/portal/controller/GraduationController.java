package com.university.portal.controller;

import com.university.portal.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/graduation")
public class GraduationController {

    @Autowired
    private FinanceService financeService;

    // Check graduation eligibility
    @GetMapping("/eligibility")
    public boolean checkGraduationEligibility(@RequestParam String email) {
        return financeService.checkGraduationEligibility(email);
    }
}
