package Field.Validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UserController {

    private Boolean formSubmited = false;   // Atribute to check if the form was sucessfull sent
    
    // Render the FORM to the user
    // Passa um objeto "User" VAZIO para o form
    @GetMapping("/user-form")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User()); // Model -> Envia pro front
        return "user-form";
    }
    
    // FORM field validation
    // Recebe do FORM um objeto "User" preenchido com os FIELDS do FORM
    @PostMapping("/user-form")
    public String submitUserForm(@Valid User user, BindingResult bindingResult) {  
        if (bindingResult.hasErrors()) {
            return "user-form";
        }
        // Process the valid user data
        formSubmited = true;        // Correct form
        return "redirect:/success";
    }

    // Show Success only if the form was correctly sent
    @GetMapping("/success")
    public String showSuccessPage() {
        if (formSubmited) {
            formSubmited=false;     // Reset the form sent Verification
            return "success";
        } else {
            return "redirect:/user-form";
        }
    }

}
