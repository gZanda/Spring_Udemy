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

    // GET Usando o CRUD
    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    // POST Usando o CRUD
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // DELETE usando o CRUD
    @Override
    public void deleteStudent(Long id) {  
        studentRepository.deleteById(id);      
    }

    // GET ALL usando o CRUD
    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll(); // Casting
    }


}