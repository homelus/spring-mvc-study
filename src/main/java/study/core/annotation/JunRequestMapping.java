package study.core.annotation;

import org.springframework.core.annotation.AliasFor;

/**
 * @author playjun
 * @since 2019 09 25
 */
public @interface JunRequestMapping {

    @AliasFor("path")
    String[] value() default {};

}
