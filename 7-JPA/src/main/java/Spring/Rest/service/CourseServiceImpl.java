package Spring.Rest.service;


import java.util.List;

import org.springframework.stereotype.Service;

import Spring.Rest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public Course getCourse(Long id) {
        return null;
    }

    @Override
    public Course saveCourse(Course course) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {        
    }

    @Override
    public List<Course> getCourses() {
        return null;
    }

}
