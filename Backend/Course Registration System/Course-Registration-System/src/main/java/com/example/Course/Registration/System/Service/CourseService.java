package com.example.Course.Registration.System.Service;

import com.example.Course.Registration.System.Model.Course;
import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Repository.CourseRegistryRepo;
import com.example.Course.Registration.System.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {

    @Autowired
    CourseRepo courserepo;

    @Autowired
    CourseRegistryRepo courseregrepo;

    public List<Course> availablecourses() {
    return courserepo.findAll();
    }

    public List<CourseRegistry> enrolledStudents() {
        return courseregrepo.findAll();
    }

    public void enrollCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry=new CourseRegistry(name,emailId,courseName);
        courseregrepo.save(courseRegistry);
    }
}
