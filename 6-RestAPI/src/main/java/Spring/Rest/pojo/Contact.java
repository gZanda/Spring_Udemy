package Spring.Rest.pojo;


// import java.util.UUID;

public class Contact {

    // Aux
    private static int idCounter = 0;
    private String id;
    private String name;
    private String phoneNumber;

    public Contact() {
        idCounter++;
        this.id = String.valueOf(idCounter);
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
