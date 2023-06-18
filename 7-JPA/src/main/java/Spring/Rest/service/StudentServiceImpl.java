package Spring.Rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.Rest.entity.Student;
import Spring.Rest.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    // Injection do CRUD na camada de serviço
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        return null;
    }

    // Usando o Respository
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {        
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }


}