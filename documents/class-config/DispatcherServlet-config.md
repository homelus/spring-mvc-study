
## Spring Web MVC 4.3.3 

### 공용 설정

#### HandlerExceptionResolvers

AnnotationMethodHandlerExceptionResolver
ResponseStatusExceptionResolver
DefaultHandlerExceptionResolver

#### ViewResolvers

InternalResourceViewResolver

#### LocaleResolver

AcceptHeaderLocaleResolver

#### ThemeResolver

FixedThemeResolver

#### FlashMapManager

SessionFlashMapMAnager

#### ViewNameTranslator

DefaultRequestToViewNameTranslator

### DispatcherServlet 기본 설정

#### HandlerMappings

__DefaultAnnotationHandlerMapping__ (@Deprecated)
BeanNameUrlHandlerMapping

#### HandlerAdapter

__AnnotationMethodHandlerAdapter__ (@Deprecated)
HttpRequestHandlerAdapter
SimpleControllerHandlerAdapter

### DispatcherServlet MVC AnnotationConfig 추가 시 설정

> RestController 의 ResponseBody 형태는 mvc:annotation-config 설정을 통해 사용 가능

#### HandlerMapping

__RequestMappingHandlerMapping__
BeanNameUrlHandlerMapping

#### HandlerAdapter

__RequestMappingHandlerAdapter__
HttpRequestHandlerAdapter
SimpleControllerHandlerAdapter

