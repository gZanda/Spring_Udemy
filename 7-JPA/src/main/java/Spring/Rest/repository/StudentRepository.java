package Spring.Rest.repository;

import org.springframework.data.repository.CrudRepository;

import Spring.Rest.entity.Student;

// Repositório para manipular "Student" que tem id do tipo "Long"
//@Repository
public interface StudentRepository extends CrudRepository<Student,Long>{
    
}