// This is a POJO
package ProjectOne.Spring;

import java.util.UUID;

public class Grade {
    
    private String name;
    private String subject;
    private String score;
    private String id;

    public Grade(String name, String subject, String score, String id) {
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.id = id;
    }

    // Sem atributos de iniciação ( usado para criar com formulário VAZIO do HTML )
    public Grade(){
        this.id = UUID.randomUUID().toString(); // ID único & aletório & string para cada um
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
