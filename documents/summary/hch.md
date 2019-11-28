# KCH 님이 생각하는 Spring MVC

## spring 코어를 이용하여 mvc 패턴으로 웹개발을 할수있도록 해주는 웹 프레임워크

### 첫번째
dispacherSevlet 이 모든 연결을 요청받아 처리한다.

### 두번째
handlerMapping 에서 해당 요청에 필요한 작업 정보 handler 를 반환한다.

### 세번째
handler의 정보로, 필요한 전처리, 실제 서비스로직, 후처리를 진행후, view를 만들어 화면에 렌더링을 한다.
