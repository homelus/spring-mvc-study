## BeanFactory 생성 및 초기화 단계 별 프로세스
<br>

> **Singleton Bean** 등록 표시: *SB #*<br>
> **BeanDefinition** 등록 표시: *BD #*

<hr>

### AbstractApplicationContext Class 의 refresh() 메서드를 통해 BeanFactory 를 생성하고 초기화한다.

<br>

1. 빈팩토리 생성
 - AnnotationConfigWebApplicationContext#loadBeanDefinition()
    - AnnotationConfigUtils#registerAnnotationConfigProcessors()
        - 기본 Root BeanDefinition 생성 클래스들 **BeanDefinition 추가**
            - ConfigurationClassPostProcessor  (BeanFactoryPostProcessor) *BD 1*
            - DefaultEventListenerFactory *BD 2*
            - EventListenerMethodProcessor *BD 3*
            - AutowiredAnnotationBeanPostProcessor *BD 4*
            - CommonAnnotationBeanPostProcessor *BD 5*
            - RequiredAnnotationBeanPostProcessor *BD 6*
    - XML / @Configuration 에 해당하는 설정 **BeanDefinition 추가** *BD 7*
    
2. 빈팩토리 준비 
    - ApplicationContextAwareProcessor (BeanPostProcessor) 추가
    - environment (환경설정) *SB 1*
    - systemProperties (시스템 설정) *SB 2*
    - systemEnvironment (시스템 환경 설정) *SB 3*

3. 빈팩토리 후처리
    - ServletContextAwarePostProcessor (BeanPostProcessor) 추가
    - Scope 추가 (WebApplicationContextUtils#registerWebApplicationScopes())
        - REQUEST, SESSION, GLOBAL_SESSION, APPLICATION
    - environment 싱글톤 빈 추가
        - 서블릿 환경 설정 정보 (servletConfig: StandardWrapperFacade.class) *SB 4*
        - 서블릿 컨텍스트 정보 (servletContext: ApplicationContextFacade.class) *SB 5*
        - 컨텍스트 속성 정보 (contextAttributes: UnmodifiableMap.class) *SB 6*
        - 컨텍스트 파라미터 정보 (contextParameters: UnmodifiableMap.class) *SB 7*

4. BeanFactoryPostProcessor 실행
    - BeanDefinitionRegistryPostProcessor 중 PriorityOrdered 를 구현한 BeanDefinition 빈 설정
        - ConfigurationClassPostProcessor *SB 8* 
    - PriorityOrdered 를 구현한 BeanFactoryPostProcessor 선 실행
        1. ConfigurationClassPostProcessor 실행
            - ImportAwareBeanPostProcessor BeanDefinition 추가 *BD 8*
            - EnhancedConfigurationBeanPostProcessor BeanDefinition 추가 *BD 9*
            - Configuration 에 설정된 BeanDefinition 처리 프로세스 진행 (@Configuration 분석)
                1. @PropertySources 분석
                2. @ComponentScan 분석
                    - Meta Annotation (@Component, @Controller, @Service, @Repository) 분석해서 BeanDefinition 에 추가 *BD 10,11,12*
                3. @Import 분석
                4. @ImportResource 분석
                5. @Bean 분석
                6. @ImportResource 에 분석된 데이터를 대상 처리 프로세스 (mvc:annotation-driven 의 경우): AnnotationDrivenBeanDefinitionParser:parse()
                    - BeanDefinition 생성 (Infrastructure 빈 생성)
                        - ContentNegotiationManager.class *BD 13* 
                        - RequestMappingHandlerMapping.class *BD 14*
                        - mvcCorsConfiguration: LinkedHashMap.class *BD 15*d
                        - FormattingConversionService.class *BD 16*
                        - RequestMappingHandlerAdapter.class *BD 17*
                            - ConfigurableWebBindingInitializer.class 생성 및 주입
                            - MessageConverters 생성 및 주입BD 
                                - ByteArrayHttpMessageConverter
                                - StringHttpMessageConverter
                                - ResourceHttpMessageConverter
                                - SourceHttpMessageConverter
                                - AllEncompassingFormHttpMessageConverter
                                - Jaxb2RootElementHttpMessageConverter
                        - CompositeUriComponentsContributor.class *BD 18*
                        - MappedInterceptor.class *BD 19*
                        - ExceptionHandlerExceptionResolver *BD 20*
                        - ResponseStatusExceptionResolver *BD 21*
                        - DefaultHandlerExceptionResolver *BD 22*
                        - BeanNameUrlHandlerMapping *BD 23*
                        - HttpRequestHandlerAdapter *BD 24*
                        - SimpleControllerHandlerAdapter *BD 25*
            - ConfigurationClassParser$ImportStack(importRegistry) *SB 9*

5. BeanPostProcessor 등록
    - AutowiredAnnotationBeanPostProcessor *SB 10*
    - RequiredAnnotationBeanPostProcessor *SB 11*
    - CommonAnnotationBeanPostProcessor *SB 12*
    - ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor *SB 13*
    - ConfigurationClassPostProcessor$EnhancedConfigurationBeanPostProcessor *SB 14*
                                
6. Message Source 초기화
    - DelegatingMessageSource *SB 15*

7. Multicaster 초기화
    - SimpleApplicationEventMulticaster *SB 16*
    
8. Bean Factory 초기화 마무리
    - lazy 설정되지 않은 BeanDefinition 을 singleton Bean 으로 생성 (RequestMappingHandlerMApping, Adapter 등의 초기화 진행)
        - 모든 BeanDefinition 을 조회하여 Singleton Bean 으로 만들어 준다.
    - SmartInitializingSingleton 을 구현한 singleton Bean 은 afterSingletonInstantiated() 을 실행한다.
     
9. 최종 마무리
    - DefaultLifecycleProcessor Singleton Bean 등록 
    
       
    
                
