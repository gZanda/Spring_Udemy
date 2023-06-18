package Spring.Rest.service;

import java.util.List;

import Spring.Rest.pojo.Contact;

// Interface para definir REGRRAS DE NEGÓCIO
public interface ContactService {

    // Force the implementation of the GET in the SERVICE
    Contact getContactById(String id);

    // Force the implementation of the POST in the SERVICE
    void saveContact(Contact contact);

    // Force the implementation of the PUT in the SERVICE
    void updateContact(String id, Contact contact);

    // Force the implementation of the DELETE in the SERVICE
    void deleteContact(String id);

    // Force the implementation of the GET all in the SERVICE
    List<Contact> getContacts();

}
