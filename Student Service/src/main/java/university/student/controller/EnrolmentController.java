package university.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import university.student.model.Student;
import university.student.service.EnrolmentService;

@Controller
public class EnrolmentController {

    private final EnrolmentService enrolmentService;

    public EnrolmentController(EnrolmentService enrolmentService) {
        this.enrolmentService = enrolmentService;
    }

    @RequestMapping("/enrolments")
    public ModelAndView enrolments(@RequestAttribute("student") Student student) {
        return enrolmentService.getEnrolments(student);
    }

}
