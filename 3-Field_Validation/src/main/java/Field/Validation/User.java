package Field.Validation;

import jakarta.validation.constraints.NotBlank;

public class User {
    
    public User() {
    }

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Invalid email format")
    private String email;

    //@NotBlank(message = "Invalid Score")
    @ScoreConstraint(message = "Score should be 1, 2 or 3")
    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters and setters

}
