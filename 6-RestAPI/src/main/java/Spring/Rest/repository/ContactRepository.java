package Spring.Rest.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import Spring.Rest.pojo.Contact;

// BEAN
@Repository
public class ContactRepository {
    
    // Data base ( pré-populada )
    private List<Contact> contacts = Arrays.asList(
        new Contact("1","Zanda","123"),
        new Contact("2","Marcelo","456"),
        new Contact("3","Edson","789")       
    );

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) { 
        contacts.set(index, contact); 
    }
    
    public void deleteContact(int index) {
        contacts.remove(index);
    }

}
