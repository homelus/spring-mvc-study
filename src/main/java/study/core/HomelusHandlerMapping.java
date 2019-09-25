package study.core;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import study.core.annotation.JunController;
import study.core.annotation.JunRequestMapping;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @author playjun
 * @since 2019 09 25
 */
public class HomelusHandlerMapping extends RequestMappingInfoHandlerMapping {

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, JunController.class) ||
                AnnotatedElementUtils.hasAnnotation(beanType, JunRequestMapping.class);
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        return null;
    }

    private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
        JunRequestMapping requestMapping = AnnotatedElementUtils.findMergedAnnotation(element, JunRequestMapping.class);
        return null;
    }

    protected String[] resolveEmbeddedValuesInPatterns(String[] patterns) {
        return null;
    }
}
