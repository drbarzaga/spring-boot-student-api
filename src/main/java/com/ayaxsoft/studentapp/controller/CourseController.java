package com.ayaxsoft.studentapp.controller;

import com.ayaxsoft.studentapp.domain.Course;
import com.ayaxsoft.studentapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController extends ResourceController<Course> {

    @Autowired
    private CourseService courseService;

    @GetMapping
    @Override
    ResponseEntity<List<Course>> index() {
        List<Course> courses = this.courseService.getAll();
        if (courses.size()==0)
            return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

    @PostMapping
    @Override
    ResponseEntity<Course> save(@RequestBody Course entity) {
        return new ResponseEntity<Course>(this.courseService.save(entity), HttpStatus.OK);
    }

    @PutMapping
    @Override
    ResponseEntity<Course> update(@RequestBody Course entity) {
        return new ResponseEntity<Course>(this.courseService.save(entity), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    ResponseEntity<Course> details(@PathVariable(name = "id")  int id) {
        Course course = this.courseService.getById(id);
        if (course!=null)
            return new ResponseEntity<Course>(course, HttpStatus.OK);
        return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Override
    ResponseEntity<String> delete(@PathVariable(name = "id") int id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
