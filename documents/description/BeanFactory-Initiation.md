### 단계 별 프로세스

1. 빈팩토리 생성
 - AnnotationConfigWebApplicationContext#loadBeanDefinition()
    - AnnotationConfigUtils#registerAnnotationConfigProcessors()
        - 기본 Root BeanDefinition 생성 클래스들 **BeanDefinition 추가**
            - ConfigurationClassPostProcessor  (BeanFactoryPostProcessor) *1*
            - DefaultEventListenerFactory *2*
            - EventListenerMethodProcessor *3*
            - AutowiredAnnotationBeanPostProcessor *4*
            - CommonAnnotationBeanPostProcessor *5*
            - RequiredAnnotationBeanPostProcessor *6*
    - XML / @Configuration 에 해당하는 설정 **BeanDefinition 추가** *7*
    
2. 빈팩토리 준비 
    - ApplicationContextAwareProcessor (BeanPostProcessor) 추가
    - environment (환경설정) Singleton Bean 추가
    - systemProperties (시스템 설정) Singleton Bean 추가
    - systemEnvironment (시스템 환경 설정) Singleton Bean 추가

3. 빈팩토리 후처리
    - ServletContextAwarePostProcessor (BeanPostProcessor) 추가
    - Scope 추가 (WebApplicationContextUtils#registerWebApplicationScopes())
        - REQUEST, SESSION, GLOBAL_SESSION, APPLICATION
    - environment 싱글톤 빈 추가
        - 서블릿 환경 설정 정보 (servletConfig: StandardWrapperFacade.class)
        - 서블릿 컨텍스트 정보 (servletContext: ApplicationContextFacade.class)
        - 컨텍스트 속성 정보 (contextAttributes: UnmodifiableMap.class)
        - 컨텍스트 파라미터 정보 (contextParameters: UnmodifiableMap.class)

4. BeanFactoryPostProcessor 실행
    - PriorityOrdered interface 를 구현한 BFPP 선 실행
        1. ConfigurationClassPostProcessor 실행
            - ImportAwareBeanPostProcessor BeanDefinition 추가 *8*
            - EnhancedConfigurationBeanPostProcessor BeanDefinition 추가 *9*
            - Configuration 에 설정된 BeanDefinition 처리 프로세스 진행 (@Configuration 분석)
                1. @PropertySources 분석
                2. @ComponentScan 분석
                    - Meta Annotation (@Component, @Controller, @Service, @Repository) 분석해서 BeanDefinition 에 추가 *10,11,12*
                3. @Import 분석
                4. @ImportResource 분석
                5. @Bean 분석
                6. @ImportResource 에 분석된 데이터를 대상 처리 프로세스 (mvc:annotation-driven 의 경우): AnnotationDrivenBeanDefinitionParser:parse()
                    - BeanDefinition 생성 (Infrastructure 빈 생성)
                        - ContentNegotiationManager.class *13* 
                        - RequestMappingHandlerMapping.class *14*
                        - mvcCorsConfiguration: LinkedHashMap.class *15*
                        - FormattingConversionService.class *16*
                        - RequestMappingHandlerAdapter.class *17*
                            - ConfigurableWebBindingInitializer.class 생성 및 주입
                            - MessageConverters 생성 및 주입
                                - ByteArrayHttpMessageConverter
                                - StringHttpMessageConverter
                                - ResourceHttpMessageConverter
                                - SourceHttpMessageConverter
                                - AllEncompassingFormHttpMessageConverter
                                - Jaxb2RootElementHttpMessageConverter
                        - CompositeUriComponentsContributor.class *18*
                        - MappedInterceptor.class *19*
                        - ExceptionHandlerExceptionResolver *20*
                        - ResponseStatusExceptionResolver *21*
                        - DefaultHandlerExceptionResolver *22*
                        - BeanNameUrlHandlerMapping *23*
                        - HttpRequestHandlerAdapter *24*
                        - SimpleControllerHandlerAdapter *25*
                        
                                
                        
                
                