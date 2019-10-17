# 다섯번째 모임

## RequestMappingHandlerAdapter (HandlerAdapter)

### 초기화

#### 생성자 -> RequestMappingHandlerAdapter()

##### 기본 MessageConverter 세팅

- ByteArrayHttpMessageConverter
- StringHttpMessageConverter
- SourceHttpMessageConverter
- AllEncompassingHttpMessageConverter

> HttpMessageConverter 란<br> 
> HttpRequest 와 HttpResponse 를 통해 Body 에 데이터를 읽거나 쓰는데 도움을 주는 변환 클래스 

#### InitializingBean -> RequestMappingHandlerAdapter:afterPropertiesSet()

##### ControllerAdvice 초기화

- @ControllerAdvice Annotation 을 구현한 Bean 을 찾는다.
    - @ModelAttribute 를 구현한 메서드를 찾아 캐시한다.
    - @InitBinder 를 구현한 메서드를 찾아 캐시한다.
    - RequestBodyAdvice & ResponseBodyAdvice 를 구현한 메서드를 캐시한다.

- [객체 등록](/documents/class-config/RequestMappingHandlerAdapter-config.md)
    - 기본 ArgumentResolvers 를 등록한다.
    - initBinder 용 ArgumentResolvers 를 등록한다.
    - 기본 HandlerMethodReturnValueHandler 를 등록한다.
