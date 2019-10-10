
## Spring Web MVC 4.3.3 

### 공용 설정

#### HandlerExceptionResolvers

AnnotationMethodHandlerExceptionResolver<br>
ResponseStatusExceptionResolver<br>
DefaultHandlerExceptionResolver<br>

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

__DefaultAnnotationHandlerMapping__ (@Deprecated)<br>
BeanNameUrlHandlerMapping<br>

#### HandlerAdapter

__AnnotationMethodHandlerAdapter__ (@Deprecated)<br>
HttpRequestHandlerAdapter<br>
SimpleControllerHandlerAdapter<br>

### DispatcherServlet MVC AnnotationConfig 추가 시 설정

> RestController 의 ResponseBody 형태는 mvc:annotation-config 설정을 통해 사용 가능

#### HandlerMapping

__RequestMappingHandlerMapping__
BeanNameUrlHandlerMapping

#### HandlerAdapter

__RequestMappingHandlerAdapter__
HttpRequestHandlerAdapter<br>
SimpleControllerHandlerAdapter<br>

