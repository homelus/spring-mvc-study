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
    

### 서비스

#### handle() -> handleInternal()

> Request, Response, HandlerMethod 를 전달하고 ModelAndView 를 반환받는다

##### ServletInvocableHandlerMethod
- handlerMethod 를 설정한다.
- argumentResolver, returnValueHandler, DataBinderFactory, parameterNameDiscover 가 설정된다.

1. **invokeForRequest()**: 리퀘스트를 컨트롤러로 실행하고 결과를 저장한다..
    1. getMethodArgumentValues() : 컨트롤러 메서드의 인자 값들을 분석하고 가공하여 가져온다.
        1. 파라미터 목록을 구해온다.
        2. argumentResolver 를 이용해 파라미터 이름고 타입에 맞는 값으 매핑시킨다.
    2. doInvoke(): 컨트롤러 (싱글톤)빈 객체와 인자 값들로 실제로 컨트롤러를 실행시킨다. 
2. **returnValueHandlers.handleReturnValue()** 결과값을 처리한다.
