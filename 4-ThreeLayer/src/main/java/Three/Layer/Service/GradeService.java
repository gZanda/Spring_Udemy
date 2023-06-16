package Three.Layer.Service;

import java.util.List;

import Three.Layer.Constants;
import Three.Layer.Grade;
import Three.Layer.Repository.GradeRepository;

public class GradeService {

    // Instância do Repositório
    GradeRepository repository = new GradeRepository();

    // Pegar UMA ÚNICA GRADE pelo index ( READ ) 
    public Grade getGrade(int index){
        return repository.getGrade(index);
    }

    // Criar uma nova GRADE ( CREATE )
    public void addGrade(Grade grade){
        repository.addGrade(grade);
    }

    // Atualizar uma GRADE ( UPDATE )
    public void updateGrade(Grade grade, int index){
        repository.updateGrade(grade, index);
    }

    // Pegar TODAS as GRADES ( Retorna a base de dados toda )
    public List<Grade> getGrades(){
        return repository.getGrades();
    }

    // Business LOGIC
    public int getGradeIndex(String id) {
        for (int i = 0; i < getGrades().size(); i++) {
            if (getGrade(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    //  Bussiness LOGIC
    public Grade getGradeById(String id){
        int index = getGradeIndex(id);                                                          
        return index == Constants.NOT_FOUND ? new Grade() : getGrade(index);
    }

    // Bussiness LOGIC
    public void submitGrade(Grade grade){
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(grade, index);
        }
    }

}
