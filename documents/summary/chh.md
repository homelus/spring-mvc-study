# CHH 님이 생각하는 Spring MVC

## 요청에 맞는 컨트롤러를 찾아서(HandlerMapping) 비지니스 로직을 실행(HandlerAdapter) 후 View를 찾아(ViewResolver) 렌더(View)하는 일련의 과정

### Model
 - 화면에 만들어줄 데이터를 담당

### View
 - 컨트롤러 리턴 타입에 따라서 어떠한 View 타입 구현체를 결정
 - 선택된 View 타입 구현체를 통해서 렌더

### Controller
 - 요청을 받으면 HanlderMapping 타입 구현체를 통해서 어떤 컨트롤러를 실행할지 결정
 - HandlerAdapter 구현체를 통해서 비지니스 로직 실행 (이때 Model 도메인과 통신하여 데이터 가져옴)
