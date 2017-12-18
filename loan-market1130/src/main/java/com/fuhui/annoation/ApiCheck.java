package com.fuhui.annoation;

import java.lang.annotation.*;

/**
 * @author : xufanglong
 * @Description:所有的api接口需要验签
 * @Date: create in 20:22 2017/11/30
 * @Modified By:
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiCheck {
    boolean validate() default true;
}
