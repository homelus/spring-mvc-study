### 네번째 모임

#### RequestMappingHandlerMapping (HandlerMapping)

##### 초기화

###### ServletContextAware -> AbstractHandlerMapping#initApplicationContext()

1. detectMappedInterceptors : MappedInterceptor 를 조회한 빈을 검색하여 추가한다.

###### InitializingBean -> RequestMappingHandlerMapping#afterPropertiesSet()

###### AbstractHandlerMethodMapping#initHandlerMethods()
1. 모든 빈 조회 후 **isHandler**(beanType) 으로 검색
    - RequestMappingHandlerMapping 의 재정의 메서드는 Controller 와 RequestMapping 애노테이션을 검사

2. 일치하는 타입은 detectHandlerMethods() 메서드를 통해 검사
    - @RequestMapping 애노테이션을 검사해 methods 를 찾는다.
    
3. mappingRegistry 에 저장한다.
    - urlLookUp 자료구조에 맵핑 url 에 대한 정보를 담아둔다. 
    - 찾아낸 method 를 class(빈)과 같이 registry 에 담아둔다.
  

##### 실행

###### getHandler()

1. Request 에서 검색 path 를 조회한다.

2. 검색 RequestMappingInfo 를 키값으로 mappingRegistry 에서 HandlerMethod 를 조회한다.
 - path 를 이용해 urlLookUp 에서 검색한다.
 - 최적의 matching 된 handler 를 찾는다. 
