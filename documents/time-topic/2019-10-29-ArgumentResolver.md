# 여섯번째 모임

## ArgumentResolver 

### RequestMappingHandlerAdapter 에 정의된 ArgumentResolvers

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

#### ArgResolverContoller 참고

다음과 같은 경우 어떤 ArgumentResolver 를 사용할 것인가?

1. 기본 타입인 경우 (**primitive, String** 등)
2. **@RequestParam** 사용하는 경우
3. **일반 객체**인 경우
4. **Map** 타입 인 경우
5. **@ModelAttribute** 를 사용하는 경우
6. **@PathVariable** 를 사용하는 경우
7. **@RequestBody** 를 사용하는 경우
8. 앞에 나온 것들을 **혼합**해서 사용하는 경우
