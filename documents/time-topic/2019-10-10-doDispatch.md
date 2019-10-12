### 세번째 모임

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

