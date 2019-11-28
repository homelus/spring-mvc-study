# HKH 님이 생각하는 Spring MVC

## (여기에 한 문장으로 요약한다면)
스프링 라이브러리를 기반으로 DispatcherServlet 을 통해 MVC(Model-View-Controller) 패턴으로 Web Application Server 개발을 할 수 있도록 지원하는 프레임워크입니다. 그 특징을 세가지로 요약하면 다음과 같습니다.

### 첫번째
Spring MVC는 모든 http 요청을 DispatcherServlet 에서 처리하는데, 각 요청은 HandlerMapping을 통해 그 요청을 처리할수 있는 Controller 클래스 및 대상 메소드를 찾고, ArgumentResolver 를 통해 요청에서 그 메소드에 들어가야할 매개변수를 셋팅하며, HandlerAdapter를 통해 Controller 의 메소드를 실행시키며 실행결과는 메시지컨버터, 혹은 뷰리졸버 및 뷰를 통해 만들어져 응답 객체에 포함되어 요청한 측에 전달됩니다. -> 동작 과정

### 두번째
Spring MVC는 개발자가 직접 HandlerMapping, HandlerAdapter, ArgumentResolver, 메시지컨버터, 뷰리졸버 등 요청 처리에 필요한 구성 요소들을 직접 구현하고, 이를 이용해 자신만의 http 요청을 처리하고 그 결과를 응답에 맵핑할 수 있도록 interface 를 제공하며 각 구성요소들은 서로 영향을 주지 않습니다. - >Inversion of Control, 프레임워크 요소의 독립적인 구현

### 세번째
Spring MVC는 초기화시 스프링 MVC 를 구성하는 모든 HandlerMapping, HandlerAdapter, ArgumentResolver, 메시지컨버터, 뷰리졸버 인스턴스를 만들고, 이를 관리하여 요청 때마다 재사용합니다.
