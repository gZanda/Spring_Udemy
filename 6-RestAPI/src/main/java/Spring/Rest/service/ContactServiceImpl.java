package Spring.Rest.service;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Spring.Rest.pojo.Contact;
import Spring.Rest.repository.ContactRepository;

// Implementa a INTERFACE
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact getContactById(String id){
        return contactRepository.getContact(findIndexById(id));
    }

    private int findIndexById(String id) {
    return IntStream.range(0, contactRepository.getContacts().size())
        .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
        .findFirst()
        .orElseThrow();
    }

}
