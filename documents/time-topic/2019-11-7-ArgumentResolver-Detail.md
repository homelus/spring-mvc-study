# ArgumentResolver 를 자세하게 살펴본다.

## 1번째 org.springframework.web.method.annotation.RequestParamMethodArgumentResolver

*핵심 메서드 각각의 역할은??*

### supportsParameter
- 어떻게 검증할 것인가?
  - SimpleType 인 경우와 @RequestParam 을 사용하는 경우 해당 RequestParamMethodArgumentResolver 를 사용한다.
  
### resolveArgument

- 어떻게 처리할 것인가?
  1. 검색할 키를 찾는다. Parameter 이름 혹은 RequestParam 의 value 값을 찾는다.
  2. Servlet 에서 Request 를 가져온다.
  3. 타입을 변환한다.

## 2번째 org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor
