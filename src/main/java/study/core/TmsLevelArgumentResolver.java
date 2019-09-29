package study.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import study.core.annotation.TmsLevelAttribute;
import study.mvc.model.TmsLevel;

public class TmsLevelArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger logger = LoggerFactory.getLogger(TmsLevelArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        logger.info("validate argument tms level");
        TmsLevelAttribute ann = parameter.getParameterAnnotation(TmsLevelAttribute.class);
        return ann != null && TmsLevel.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        logger.info("change argument tms level");
        Integer level = NumberUtils.parseNumber(webRequest.getParameter(parameter.getParameterName()), Integer.class);
        return TmsLevel.getTmsLevel(level);
    }
}
