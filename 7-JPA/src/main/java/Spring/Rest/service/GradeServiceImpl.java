package Spring.Rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.Rest.entity.Grade;
import Spring.Rest.entity.Student;
import Spring.Rest.repository.GradeRepository;
import Spring.Rest.repository.StudentRepository;

@Service
public class GradeServiceImpl implements GradeService {
    
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;

    // Usando o método PERSONALIZADO do CRUD
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return gradeRepository.findByStudentId(studentId);
    }

    // POST usando o CRUD
    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        grade.setStudent(student);  // associa um STUDENT com uma GRADE
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        return null;
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return null;
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return null;
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }

}
