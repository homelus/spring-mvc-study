package study.core;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import study.core.annotation.HomelusController;
import study.core.annotation.HomelusRequestMapping;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @author playjun
 * @since 2019 09 25
 */
@Component
public class HomelusHandlerMapping extends RequestMappingInfoHandlerMapping {

    private RequestMappingInfo.BuilderConfiguration config = new RequestMappingInfo.BuilderConfiguration();

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, HomelusController.class) ||
                AnnotatedElementUtils.hasAnnotation(beanType, HomelusRequestMapping.class);
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        return createRequestMappingInfo(method);
    }

    private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
        HomelusRequestMapping requestMapping = AnnotatedElementUtils.findMergedAnnotation(element, HomelusRequestMapping.class);
        return RequestMappingInfo
                .paths(requestMapping.path())
                .options(this.config)
                .build();
    }

}
