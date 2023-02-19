package idv.jk.validator;

import idv.jk.model.Difficulty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DifficultyValidator implements ConstraintValidator<ValidDifficulty, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            Difficulty.valueOf(value);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }
}
