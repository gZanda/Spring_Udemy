package Three.Layer.Controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Three.Layer.Grade;
import Three.Layer.Service.GradeService;


@Controller
public class GradeController {

    // Instance of the REPOSITORY ( Controller não pode interagir diretamente com Repository )
    //GradeRepository repository = new GradeRepository();

    // ACOPLAMENTO !!!!! - Não queremos isso
    // GradeService service = new GradeService();

    // Injection - Do bean @Service - Classe GradeService
    @Autowired
    GradeService service;

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {                                                
        model.addAttribute("grade", service.getGradeById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        // IF
        if (result.hasErrors()) return "form";
        // ELSE
        service.submitGrade(grade);
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", service.getGrades());
        return "grades";
    }

}