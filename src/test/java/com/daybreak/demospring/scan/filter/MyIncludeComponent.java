package com.daybreak.demospring.scan.filter;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
// TYPE : CLASS LEVEL에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
