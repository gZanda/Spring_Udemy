package Spring.Rest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // Post que RECEBE um .JSON para cadastro
    // @RequestBody para indicar que RECEBE um .JSON
    @PostMapping("/contact")                        // Para interpretar um request .JSON e colocar no objeto
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact){
        // @RequestBody utiliza os "SETTERS" da classe "Contact" para preencher o objeto com os dados que vieram pelo .JSON
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @RequestBody Contact contact){
        contactService.updateContact(id, contact);
        return new ResponseEntity<Contact>(contactService.getContactById(id),HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET ALL
    @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getContacts(){
        List<Contact> contacts = contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}
