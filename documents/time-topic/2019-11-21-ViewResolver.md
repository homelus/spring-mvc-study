# ViewResolver 의 역할은 무엇인가?

## view 이름과 local 을 이용해 View Interface 를 리턴해준다.

- (View 는 클라이언트에게 소켓을 통해 전달할 때 response body 를 채워주는 역할을한다)

클라이언트가 이해할 수 있도록 MediaType 값에 영향을 받으며 그에 따라 구현체들이 나뉜다.

예를들어 일반 JSP 를 불러오기 위한 기본 ViewResolver 는 InternalResourceViewResolver 이다.

이 구현체는 Redirect 혹은 Forwarding 여부를 체크하고 각각 RedirectView 와 InternalResourceView 를 반환하며
그 외의 경우 viewName 앞 뒤로 prefix 와 suffix 를 붙여 자원을 받을 수 있는 새로운 url 을 붙여 반환한다.
