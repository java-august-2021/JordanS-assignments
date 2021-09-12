package com.jordans.dojooverflow2.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.jordans.dojooverflow2.models.Question;

@Component
public class TagValidator {
    // 1
    public boolean supports(Class<?> clazz) {
        return Question.class.equals(clazz);
    }
    //TURN ALL THIS SHIT INTO TAG NOT USER
    // 2
    public void validate(Object target, Errors errors) {
        Question question = (Question) target;
        String[] tags = question.getTagQuery().split(", ");
        if(tags.length > 3) {
        	errors.rejectValue("tagQuery", "too many tags", "must have 3 tags or less");
        }
                
    }
}
