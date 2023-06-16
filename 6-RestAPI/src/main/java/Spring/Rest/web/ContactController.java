package Spring.Rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Spring.Rest.pojo.Contact;
import Spring.Rest.service.ContactService;

//@Controller
@RestController // @Controller + @ResponseBody
public class ContactController {
    
    // Injection do BEAN "contactServiceImpl" mas usando uma variável da INTERFACE "ContactService" ( POLIMORFISMO )
    @Autowired
    private ContactService contactService;

    // GET que espera receber um ID pela URL
    //@ResponseBody   // Indicando que a resposta será em um .JSON
    //public Contact getContact(@PathVariable String id){
    @GetMapping("/contact/{id}")    // Automaticamente converte a resposta para um .JSON
    public ResponseEntity<Contact> getContact(@PathVariable String id){
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
