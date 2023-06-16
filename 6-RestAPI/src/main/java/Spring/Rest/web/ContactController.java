package Spring.Rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import Spring.Rest.service.ContactService;

@Controller
public class ContactController {
    
    @Autowired
    private ContactService contactService;

}
