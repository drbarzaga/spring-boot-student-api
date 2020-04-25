package com.ayaxsoft.studentapp.controller;

import com.ayaxsoft.studentapp.domain.Course;
import com.ayaxsoft.studentapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/course")
public class CourseController extends ResourceController<Course> {

    @Autowired
    private CourseService courseService;

    @Override
    ResponseEntity<List<Course>> index() {
        List<Course> courses = this.courseService.getAll();
        if (courses.size()==0)
            return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

    @Override
    ResponseEntity<Course> save(Course entity) {
        return new ResponseEntity<Course>(this.courseService.save(entity), HttpStatus.OK);
    }

    @Override
    ResponseEntity<Course> update(Course entity) {
        return new ResponseEntity<Course>(this.courseService.save(entity), HttpStatus.OK);
    }

    @Override
    ResponseEntity<Course> details(int id) {
        Course course = this.courseService.getById(id);
        if (course!=null)
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @Override
    ResponseEntity<String> delete(int id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
