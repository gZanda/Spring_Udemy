package Three.Layer.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Three.Layer.Grade;

// A ÚNICA CLASSE que vai mexer na base de dados
@Component
public class GradeRepository {
    
    // Base de dados
    private List<Grade> studentGrades = new ArrayList<>();

    // Pegar UMA ÚNICA GRADE pelo index ( READ ) 
    public Grade getGrade(int index){
        return studentGrades.get(index);
    }

    // Criar uma nova GRADE ( CREATE )
    public void addGrade(Grade grade){
        studentGrades.add(grade);
    }

    // Atualizar uma GRADE ( UPDATE )
    public void updateGrade(Grade grade, int index){
        studentGrades.set(index, grade);
    }

    // Pegar TODAS as GRADES ( Retorna a base de dados toda )
    public List<Grade> getGrades(){
        return studentGrades;
    }

}
