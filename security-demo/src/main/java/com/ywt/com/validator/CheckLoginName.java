package com.ywt.com.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD}) //此注解可以标注在哪里。（方法，字段）
@Retention(RetentionPolicy.RUNTIME) //运行时注解
@Constraint(validatedBy = CheckLoginNameValidator.class) //执行那个类的逻辑
public @interface CheckLoginName {

    String message() default "{登录名重复}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
