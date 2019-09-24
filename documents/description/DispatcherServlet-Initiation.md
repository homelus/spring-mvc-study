### Dispatcher Servlet 초기화 과정




#### BeanFactory

##### HandlerMapping

- RequestMappingHandlerMapping
    - AbstractHandlerMethodMapping#initHandlerMethods()
    - RequestMappingHandlerMapping#isHandler()
    - AbstractHandlerMethodMapping#detectHandlerMethods()
    - AbstractHandlerMethodMapping#registerHandlerMethod()