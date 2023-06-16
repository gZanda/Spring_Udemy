package Spring.Rest.service;

import Spring.Rest.pojo.Contact;

// Interface para definir REGRRAS DE NEGÓCIO
public interface ContactService {
    
    Contact getContactById(String id);

}
