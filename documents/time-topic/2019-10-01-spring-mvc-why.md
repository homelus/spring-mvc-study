### 첫번째 모임

#### Spring MVC 디버깅 순서

##### 초기화

- GenericServlet#init()
- HttpServlet#init()
- FrameworkServlet#initServletBean()
- FrameworkServlet#initWebApplicationContext()
- FrameworkServlet#createWebApplicationContext()
    - BeanUtils.instantiateClass(contextClass) : ApplicationContext 생성
- FrameworkServlet#configureAndRefreshWebApplicationContext()
    - wac.refresh() : BeanFactory 생성 및 초기화
- AbstractApplicationContext#refresh()
- AbstractRefreshableApplicationContext#refreshBeanFactory()
    - createBeanFactory() : 빈 팩토리 생성
    - loadBeanDefinitions() : 빈 정의 로딩

##### 서비스 실행 중

#### Spring MVC 를 공부해야하는 이유

##### 실무적으로 바라볼 때 

###### Controller
 
####### 하는 일은 무엇인가?
####### 할 수 있는 일은 무엇인가?
####### 어떻게 만들 것인가?

###### Model

####### 데이터를 어디에 저장할 것 인가?

###### View

####### ResponseBody 란? 
####### JSP 출력하는 방법?

###### ETC

####### 무엇을 적용해 볼 수 있을까 

##### 개인적인 성장의 도구로 바라볼 때

###### Open Source 기여

###### Core 한 코드에 대한 접근 및 분석

###### 자존감 & 자신감

###### 좋은 예제


#### [Spring MVC Repository](https://mvnrepository.com/artifact/org.springframework/spring-webmvc)

##### 종속 모듈(Optional 제외) 4.3.3

###### Spring  
1. spring-core
    - environment
    - converter
    - cglib
    - util
2. spring-beans
    - bean 
    - bean factory
3. spring-context
    - application context
    - cache, scheduling
    - stereotype annotation
    - validation
4. spring-expression
    - spel
5. spring-aop
    - aspectj
    - pointcut, advice, advisor
6. spring-web
    - http (client, converter, server)
    - filter
    - scope
    - (web) context
    
##### Spring MVC
