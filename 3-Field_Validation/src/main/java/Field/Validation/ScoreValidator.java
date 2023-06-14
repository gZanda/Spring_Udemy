package Field.Validation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<ScoreConstraint,String>{
    
    List<String> scores = Arrays.asList("1","2","3");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for(String string : scores){
            if(value.equals(string)) return true;
        }
        return false;
    }
}
