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