### Dispatcher Servlet 요청 처리 과정 설명

<hr>

![dispatcher-servlet-processing](img/DispatcherServlet-Processing.PNG)

#### HandlerMapping
요청을 분석해 MappingRegistry 에서 요청을 처리할 컨트롤러 메서드를 찾습니다.

#### HandlerAdapter
Controller 메서드를 실행할 adapter 를 검색합니다.

#### Interceptor
컨트롤러 실행 전/후처리 작업을 합니다.

#### ArgumentResolver

##### 사용 형태
- RequestMapping Method 의 parameter 에 해당하는 ArgumentResolver 를 찾으면 cache 에 넣어놓고 재활용 함 

##### Resolvers 사용 예제

> Simple Type 이란?
> primitive, enum, CharSequence, Number, Date, URI, URL, Locale, Class 의 Type 이거나 상속받는 Type

- ServletModelAttributeMethodProcessor
    - (1) Parameter 가 @ModelAttribute Annotation 을 사용하거나, (2) SimpleType 이 아닌 경우 (사용자 객체)



#### Controller
비즈니스 로직을 이용해 처리합니다.

#### ReturnValueHandler
컨트롤러에서 반환받은 결과값을 처리합니다.

#### LocaleResolver

#### ViewResolver
결과값을 이용해 클라이언트에게 렌더링 할 view 를 선택합니다.

#### HandlerExceptionResolver
