package Three.Layer.Controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Three.Layer.Constants;
import Three.Layer.Grade;
import Three.Layer.Repository.GradeRepository;


@Controller
public class GradeController {

    // Instance of the REPOSITORY
    GradeRepository repository = new GradeRepository();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getGradeIndex(id);                                                          
        model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade() : repository.getGrade(index));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form";

        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            repository.addGrade(grade);
        } else {
            repository.updateGrade(grade, index);
        }
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", repository.getGrades());
        return "grades";
    }

    public int getGradeIndex(String id) {
        for (int i = 0; i < repository.getGrades().size(); i++) {
            if (repository.getGrades().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

}