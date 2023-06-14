package Basics.Spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

    private String data = "Initial";

    // GET --------------------------------------------------------------------------------------------------
    
    @GetMapping("/GET") // URL endpoint de acesso
    public String getExample(Model model) {

        // Add any data you want to pass to the view
        model.addAttribute("message", "Hello, World!");
    
        // Return the name of the HTML file
        return "hello";
    }

    // POST --------------------------------------------------------------------------------------------------

    @GetMapping("/POST")  // URL endpoint de acesso ao HTML do form
    public String showForm() {
        return "form";
    }

    @PostMapping("/POST")   // REQUEST que RECEBE um parâmetro e também DEVOLVE uma variável
    public String processForm(@RequestParam("name") String name, Model model) {

        // Process the submitted data
        String message = "Hello, " + name + "!";

        // Add the processed data to the model for "result" ( APENAS ACESSÍVEL EM "result")
        model.addAttribute("message", message);

        // Return the name of the Thymeleaf template
        return "result";
    }

    // UPDATE --------------------------------------------------------------------------------------------------

    @GetMapping("/UPDATE")
    public String showForm(Model model) {
        model.addAttribute("data", data);
        return "example";
    }

    @PostMapping("/UPDATE")
    public String updateData(@RequestParam("userInput") String userInput) {
        data = userInput;
        return "redirect:/UPDATE";
    }


}
