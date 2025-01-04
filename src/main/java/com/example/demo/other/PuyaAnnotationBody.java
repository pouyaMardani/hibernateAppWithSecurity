package com.example.demo.other;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PuyaAnnotationBody implements ConstraintValidator<Pouya,String> {


    private String tempText;

    @Override
    public void initialize(Pouya data) {
        tempText = data.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean res;
        if(s!=null){
            res = s.endsWith(tempText);
        }else {
            res = true;
        }
        return res;
    }
}
