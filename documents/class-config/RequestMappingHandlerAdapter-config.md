## RequestMappingHandlerAdapter 에서 추가되는 객체 목록

### MessageConverter

> **HTTP** 에서 사용하는 변환기이다. 제네릭으로 선언한 Type 값을 HTTP 의 HttpRequest 로 부터 읽거나 Response 로 전달하는 역할을 수행한다.

ByteArrayHttpMessageConverter<br>
StringHttpMessageConverter<br>
ResourceHttpMessageConverter<br>
SourceHttpMessageConverter<br>
AllEncompassingFormHttpMessageConverter<br>
Jaxb2RootElementHttpMessageConverter<br>

### ParameterNameDiscoverer

> 파라미터의 이름을 검색하는 클래스이다. 파라미터의 타입이나 개수는 Reflection 으로 알기 쉽지만 이름은 알기 어렵다 (변수의 이름을 찾는다고 생각해보자)

DefaultParameterNameDiscoverer

### ArgumentResolvers

> 요청받은 데이터에서 컨트롤러가 원하는 데이터로 변환하는 클래스이다.

RequestParamMethodArgumentResolver<br>
RequestParamMapMethodArgumentResolver<br>
PathVariableMethodArgumentResolver<br>
PathVariableMapMethodArgumentResolver<br>
MatrixVariableMethodArgumentResolver<br>
MatrixVariableMapMethodArgumentResolver<br>
ServletModelAttributeMethodProcessor<br>
RequestResponseBodyMethodProcessor<br>
RequestPartMethodArgumentResolver<br>
RequestHeaderMethodArgumentResolver<br>
RequestHeaderMapMethodArgumentResolver<br>
ServletCookieValueMethodArgumentResolver<br>
ExpressionValueMethodArgumentResolver<br>
SessionAttributeMethodArgumentResolver<br>
RequestAttributesMethodArgumentResolver<br>
ServletRequestMethodArgumentResolver<br>
ServletResponseMethodArgumentResolver<br>
HttpEntityMethodProcessor<br>
RedirectAttributesMethodArgumentResolver<br>
ModelMethodProcessor<br>
MapMethodProcessor<br>
ErrorsMethodArgumentResolver<br>
SessionStatusMethodArgumentResolver<br>
UriComponentsBuilderMethodArgumentResolver<br>
RequestParamMethodArgumentResolver<br>
ServletModelAttributeMethodProcessor<br>

### ReturnValueHandler

> 컨트롤러에서 반환받은 결과값을 처리하는 클래스이다.

ModelAndViewMethodReturnValueHandler<br>
ModelMethodProcessor<br>
ViewMethodReturnValueHandler<br>
ResponseBodyEmitterReturnValueHandler<br>
StreamingResponseBodyReturnValueHandler<br>
HttpEntityMethodProcessor<br>
HttpHeaderReturnValueHandler<br>
CallableMethodReturnValueHandler<br>
DeferredResultMethodReturnValueHandler<br>
AsyncTaskMethodReturnValueHandler<br>
ModelAttributeMethodProcessor<br>
RequestResponseBodyMethodProcessor<br>
ViewNameMethodReturnValueHandler<br>
MapMethodProcessor<br>
ModelAttributeMethodProcessor<br>

### WebBindingInitializer

#### ConversionService

> 특정 타입에서 다른 타입으로 변환하는 클래스이다.

DefaultFormattingConversionService

