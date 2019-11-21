# ReturnValueHandler 를 알아보자

## Controller 를 실행한 결과값을 처리하는 클래스

- 다양한 전략이 존재하는데 @RestController 를 사용할 경우 적용되는 @ResponseBody 를 이용한 처리가 자주 쓰임.

실제로 HandlerAdapter 의 handle 메서드에서 반환되는 ModelAndView 를 설정함.

두 가지의 경우로 나뉠 수 있는데 ResponseBody 에 직접 데이터를 작성하여 Socket 에 전달(flush)하거나  
ViewResolver 로 데이터를 전달하여 Response 를 전달하도록 요청할 수도 있음.

Spring 이 지원하는 정적자원 리소스의 경우 파일 이름을 전달하며 특정 전략에서는 비동기 처리도 지원함
