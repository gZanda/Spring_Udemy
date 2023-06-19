package Spring.Rest.repository;

import org.springframework.data.repository.CrudRepository;

import Spring.Rest.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade,Long>{
    
}