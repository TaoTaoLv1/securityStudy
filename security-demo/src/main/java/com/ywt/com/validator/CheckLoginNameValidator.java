package com.ywt.com.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckLoginNameValidator implements ConstraintValidator<CheckLoginName, String> {


    /**
     * 注解初始化
     * @param constraintAnnotation
     */
    @Override
    public void initialize(CheckLoginName constraintAnnotation) {

    }

    /**
     * 逻辑体
     * @param s 传进来的值
     * @param constraintValidatorContext 上下文信息
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
