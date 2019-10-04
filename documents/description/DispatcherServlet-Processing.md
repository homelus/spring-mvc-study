### Dispatcher Servlet 요청 처리 과정 설명

<hr>

![dispatcher-servlet-processing](img/DispatcherServlet-Processing.PNG)

#### HandlerMapping

#### HandlerAdapter

#### Interceptor

#### ArgumentResolver

##### 사용 형태
- RequestMapping Method 의 parameter 에 해당하는 ArgumentResolver 를 찾으면 cache 에 넣어놓고 재활용 함 

##### Resolvers 사용 예제

> Simple Type 이란?
> primitive, enum, CharSequence, Number, Date, URI, URL, Locale, Class 의 Type 이거나 상속받는 Type

- ServletModelAttributeMethodProcessor
    - (1) Parameter 가 @ModelAttribute Annotation 을 사용하거나, (2) SimpleType 이 아닌 경우 (사용자 객체)



#### Controller**

#### ReturnValueHandler

#### LocaleResolver

#### ViewResolver

#### HandlerExceptionResolver