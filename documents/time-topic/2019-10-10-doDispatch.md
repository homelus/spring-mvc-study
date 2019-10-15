### 세번째 모임

#### DispatcherServlet 의 doDispatch 메서드 개요 정리

1. getHandler() : 알맞은 HandlerMapping 을 이용해 HandlerExecutionChain 을 가져온다.

2. getHandlerAdapter() : 1번에서 가져온 handler 를 키로 HandlerAdapter 를 가져온다.

3. 1번에서 얻어온 값으로 applyPreHandle() 를 통해 인터셉터 전처리를 한다.

4. handle() : handlerAdapter 를 실행시킨다.
 - 실제로 컨트롤러가 실행된다.
 
5. 1번에서 얻어온 값으로 applyPostHandle() 를 통해 인터셉터 후처리를 한다.

6. processDispatchResult() : dispatch 된 결과값을 처리한다.
 - render() : 결과값을 처리한다.
 - ViewResolver 를 이용해 View 를 가져오고 render() 메서드를 호출한다.
 
#### DispatcherServlet#doDispatch() 이 하는 일

> 실제로 우리는 Controller 클래스와 RequestMapping 이 설정된 Method 만 만들면 되는데 이 과정을 왜 봐야하는 걸까?

> 이 과정에 참여함으로 우리가 얻게 되는 실익은 무엇일까?

1. handlerMapping 을 이용해 handler chain 을 가져온다.
    - chain 으로 가져오는 이유
    
2. handler 를 이용해 handlerAdapter 를 가져온다.
    - 왜 handler adapter 를 사용해야 할까

3. interceptor 전처리

4. handler adapter 를 이용해 handler 실행
    - *우리가 작성한 Controller method 가 실제로 처리되는 부분*

5. interceptor 후처리

6. 결과값 처리
    - 웹에서 결과값 이란 무엇일까

