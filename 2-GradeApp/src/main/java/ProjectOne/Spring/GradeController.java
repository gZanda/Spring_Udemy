package ProjectOne.Spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Annotation to turn this class into a controller
public class GradeController {

    // Fazemos essa lista para Não ocorrer BUG de criação de novas grades a cada GET no "/grades"
    List<Grade> studentGrades = Arrays.asList(
        new Grade("Zanda", "CPA", "85","1"),
        new Grade("Gabriel", "PS", "90","2"),  
        new Grade("Fernando", "SGBD", "75","3")); // Instancia uma lista de "Grade"

    List<Grade> studentGrades2 = new ArrayList<>();

    @GetMapping(value="/grade") // Annotation to turn the method into a GET HANDLER method
    public String showOnlyOneGrade(Model model){
        Grade grade = (new Grade("Zanda", "CPA", "85","1"));  // Criando um objeto do tipo Grade

        model.addAttribute("grade",grade ); // Atributo , Seu_Valor ( colocando isso no Model ) // Apenas 1 nota

        return "grade";
    }

    @GetMapping(value = "/sales")
    public String showSales(Model model){
        model.addAttribute("sales", 51);
        model.addAttribute("product", "Farofa");

        return "sales";
    }

    @GetMapping(value = "/menu")
    public String showMenu(Model model){
        model.addAttribute("menu", "cake, brownie, ice, beer");

        return "menu";
    }

    @GetMapping(value="/grades") // Annotation to turn the method into a GET HANDLER method
    public String showGrades(Model model){
        //studentGrades.add(new Grade("Zanda", "CPA", "85"));  
        //studentGrades.add(new Grade("Gabriel", "PS", "90"));  
        //studentGrades.add(new Grade("Fernando", "SGBD", "75"));  

        // model.addAttribute("grades", studentGrades); // Usada pura ( já tem a "studentGrades" pré pronta )

        // Usando redirect ( adiciona +1 na arraylist para cada form)
        model.addAttribute("grades", studentGrades2);

        return "grades";
    }

    // Duas opções para esse GET ( ou não recebe parâmetro nenhum ou recebe pelo botão de Atualizar )
    @GetMapping(value = "/")
    public String showForm(Model model, @RequestParam (required = false) String id){
        Grade grade;

        // Não recebeu
        if(getGradeIndex(id) == -1){
            grade = new Grade();
        }
        // Recebeu
        else{
            grade = studentGrades2.get(getGradeIndex(id));
        }
        
        model.addAttribute("gradeForm", grade);
        //model.addAttribute("gradeForm", new Grade());                       // Para Carregar a página com FORMS vazio
        //model.addAttribute("gradeForm", new Grade("Zanda","IALG","65"));    // Para Carregar a página com FORMS preenchido
        return "form";
    }

    // Ou cria ou atualiza ( POST para criar ou UPDATE )
    @PostMapping(value = "/handleForm")
    public String submitForm(Grade grade){
        int index = getGradeIndex(grade.getId());
        if(index == -1){
            studentGrades2.add(grade);
        }
        else{
            studentGrades2.set(index,grade);
        }
        return "redirect:/grades";  // it makesa a GET request
    }

    // Método auxiliar para procurar Index
    public Integer getGradeIndex(String id){
        for (int i = 0; i < studentGrades2.size(); i++) {
            if(studentGrades2.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;  // index Not Found 
    }
    
}
