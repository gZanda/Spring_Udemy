package Spring.Rest.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.Rest.pojo.Contact;
import Spring.Rest.repository.ContactRepository;

// Implementa a INTERFACE
@Service
public class ContactServiceImpl implements ContactService {

    // Injection
    @Autowired
    private ContactRepository contactRepository;

    // GET
    @Override
    public Contact getContactById(String id){
        return contactRepository.getContact(findIndexById(id));
    }

    // POST
    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    // PUT
    @Override
    public void updateContact(String id, Contact contact) {
        contactRepository.updateContact(findIndexById(id), contact);
    }

    // DELETE
    @Override
    public void deleteContact(String id) {
        contactRepository.deleteContact(findIndexById(id));
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    private int findIndexById(String id) {
    return IntStream.range(0, contactRepository.getContacts().size())
        .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
        .findFirst()
        .orElseThrow();
    }

}
