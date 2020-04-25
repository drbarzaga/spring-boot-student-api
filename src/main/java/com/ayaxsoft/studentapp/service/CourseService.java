package com.ayaxsoft.studentapp.service;

import com.ayaxsoft.studentapp.domain.Course;
import com.ayaxsoft.studentapp.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends  BaseService<Course> {

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    public Course update(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    public Course getById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        courseRepository.deleteById(id);
    }
}
