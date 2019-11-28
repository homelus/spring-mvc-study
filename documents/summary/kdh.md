# KDH 님이 생각하는 Spring MVC

## Spring에서 제공하는 웹 요청 처리 프로세스

### 첫번째. mvc 패턴을 뒷받침한다. (mvc 패턴으로 요청 처리할 수 있도록 조력한다.)

### 두번째. DispatcherServlet을 기반으로 웹 요청을 처리한다. 

### 세번째. handlerMapping, handlerAdapter, returnValueHandler,ArgumentResolver, ViewResolver, View, LocaleResolver등 각각의 역할이 구분되어 있으며 처리 과정에서 필요에 맞게 커스텀할 수 있도록 구성되어 있다.  
