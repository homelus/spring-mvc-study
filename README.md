# Spring MVC Study

## :book: Learning DispatcherServlet initialization & service process

##### Spring Version: 4.3.3
##### Build tool: Gradle

#### *[스프링 MVC Reference 번역 정보](documents/spring-framework-reference/ko/spring-mvc-translated-version.md)*

### Study Database

##### DispatcherServlet 의 구조
- Servlet 상속 구조
    - [Spring Spec] DispatcherServlet : doDispatcher 메서드를 이용해 web request 를 처리하는 중앙 처리 클래스
    - [Spring Spec] FrameworkServlet : 서블릿 웹 프레임워크의 기본 기능을 제공하고 do* 메서드를 다시 doService 메서드로 모아주는 추상클래스
    - [Spring Spec] HttpServletBean : init 메서드를 재정의하며 설정 기능을 제공하는 추상 클래스
    - [Servlet Spec] HttpServlet : service 메서드로의 요청을 do* 메서드로 전달하는 추상클래스
    - [Servlet Spec] GenericServlet : ServletConfig 의 설정을 담당하는 추상클래스
    - [Servlet Spec] Servlet(interface) : Servlet 의 생명주기를 제공하는 인터페이스 (init, service, destroy)

- ApplicationContext 구성 및 초기화
    - ApplicationContext 생성: FrameworkServlet#createWebApplicationContext()
    - BeanFactory 생성: AbstractRefreshableApplicationContext#refreshBeanFactory()
    - BeanDefinition 로딩: AnnotationConfigWebApplicationContext:loadBeanDefinitions()
    - BeanPostProcessor 등록: PostProcessorRegistrationDelegate:registerBeanPostProcessors()
    - SingletonBean (전처리)미리 등록: DefaultListableBeanFactory:preInstantiateSingletons()

> ApplicationContext 를 생성(초기화)하는 첫 단계는 DispatcherServlet 의 부모 클래스인 HttpServletBean 의 init() 메서드이다.
> 이 클래스는 Servlet Spec 에 따라 init 메서드를 호출하는데 이때 FrameworkServlet 클래스의 initServletBean() 메서드를 실행한다.
> 이 부분을 보면 ApplicationContext 의 시작지점을 알 수 있다.

#### :seedling: [DispatcherServlet 의 초기화 과정](documents/description/DispatcherServlet-initiation.md)

#### :herb: [BeanFactory 의 초기화 과정](documents/description/BeanFactory-initiation.md)

#### :evergreen_tree: [웹 요청의 처리 과정](documents/description/DispatcherServlet-processing.md)

### 클래스 별 설정 데이터 정보

##### [DispatcherServlet](documents/class-config/DispatcherServlet-config.md)
##### [BeanFactory](documents/class-config/BeanFactory-config.md)
##### [RequestMappingHandlerMapping](documents/class-config/RequestMappingHandlerMapping-config.md)
##### [RequestMappingHandlerAdapter](documents/class-config/RequestMappingHandlerAdapter-config.md)

### :bus: 스터디 진행 현황
#### [사전 모임](documents/time-topic/2019-09-26-Pre_metting.md)
#### [첫번째 모임: Spring MVC 를 왜 공부할까](documents/time-topic/2019-10-01-Why.md)
#### [두번째 모임: Spring MVC 는 무엇일까](documents/time-topic/2019-10-08-What.md)
#### [세번째 모임: doDispatch 메서드의 역할은](documents/time-topic/2019-10-10-doDispatch.md)
#### [네번째 모임: RequestMappingHandlerMapping 의 역할은](documents/time-topic/2019-10-15-RequestMappingHandlerMapping.md)
#### [다섯번째 모임: RequestMappingHandlerAdapter 의 역할은](documents/time-topic/2019-10-17-RequestMappingHandlerAdapter.md)
#### [여섯번째 모임: ArgumentResolver 의 역할은](documents/time-topic/2019-10-29-ArgumentResolver.md)
#### [일곱번째 모임: ArgumentResolver 살펴보기](documents/time-topic/2019-11-7-ArgumentResolver-Detail.md)
#### [여덟번째 모임: ReturnValueHandler 살펴보기](documents/time-topic/2019-11-19-ReturnValueHandler.md)
#### [아홉번 모임: ViewResolver 살펴보기](documents/time-topic/2019-11-21-ViewResolver.md)
#### [열번째 모임: View 살펴보기](documents/time-topic/2019-11-26-View.md)
#### [마지막 모임: Spring MVC 는 무엇일까?](documents/time-topic/2019-11-28-What-Spring-again.md)

#### :thinking: 스터디 마지막 정리(내가 생각하는 Spring MVC)
[CHH](documents/summary/chh.md), 
[HCH](documents/summary/hch.md), 
[HKH](documents/summary/hkh.md), 
[HSM](documents/summary/hsm.md), 
[KDH](documents/summary/kdh.md), 
[KHG](documents/summary/khg.md), 
[KIK](documents/summary/kik.md), 
[KYS](documents/summary/kys.md), 
[YHJ](documents/summary/yhj.md)
