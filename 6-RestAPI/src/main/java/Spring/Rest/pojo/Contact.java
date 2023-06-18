package Spring.Rest.pojo;


import java.util.UUID;

public class Contact {

    private String id;
    private String name;
    private String phoneNumber;

    public Contact() {
        this.id = UUID.randomUUID().toString();
    }

    public Contact(String id, String name, String phone){
        this.id = id;
        this.name = name;
        this.phoneNumber = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
