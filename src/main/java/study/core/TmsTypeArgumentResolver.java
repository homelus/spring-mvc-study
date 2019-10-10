package study.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import study.core.annotation.TmsTypeAttribute;
import study.mvc.model.TmsType;

public class TmsTypeArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger logger = LoggerFactory.getLogger(TmsTypeArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        logger.info("validate argument tms type");
        TmsTypeAttribute ann = parameter.getParameterAnnotation(TmsTypeAttribute.class);
        return ann != null && TmsType.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        logger.info("change argument tms type");
        String code = webRequest.getParameter(parameter.getParameterName());
        return TmsType.getTmsType(code);
    }
}
