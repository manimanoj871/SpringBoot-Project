package com.example.Course.Registration.System.Controller;

import com.example.Course.Registration.System.Model.Course;
import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500/")
public class CourseController {
    @Autowired
    CourseService courseservice;

    @GetMapping("/courses")
    public List<Course> availablecourses()
    {
        return courseservice.availablecourses();
    }
    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents()
    {
        return courseservice.enrolledStudents();
    }
    @PostMapping("/courses/register")
    public String enrollCourse(@RequestParam("name") String name,@RequestParam("emailId") String emailId,@RequestParam("courseName") String courseName)
    {
         courseservice.enrollCourse(name,emailId,courseName);
         return "Congratulations! "+name+" Enrollment Successful for "+courseName;
    }
}
