package university.student.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;
import university.student.exception.StudentNotFoundException;
import university.student.model.Account;
import university.student.model.Student;

@Validated
@Component
public class GraduationService {

    private final IntegrationService integrationService;

    public GraduationService(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    public ModelAndView getGraduationStatus(Student student) {
        if (student == null) {
            throw new StudentNotFoundException();
        }
        Account account = integrationService.getStudentPaymentStatus(student);
        ModelAndView modelAndView = new ModelAndView("graduation");
        modelAndView.addObject("balanceOutstanding", account.isHasOutstandingBalance());
        modelAndView.addObject("message", account.isHasOutstandingBalance() ? "ineligible to graduate" : "eligible to graduate");
        return modelAndView;
    }
}