#### 1. Object.clone이 Cloneable 마커 인터페이스 대신 @Cloneable 애너테이션을 사용하도록 수정하는 방법을 찾아라.

#### 2. 자바 초기 버전에 애너테이션이 있었다면 Serializable 인터페이스는 분명 애너테이션으로 만들어졌을 것이다. 먼저 영속성에 사용할 텍스트나 바이너리 서식을 선택한다. 기본 타입 값이거나 직렬화할 수 있는 모든 필드를 저장하고 복원하는 방법으로 객체의 상태를 영속화하는 스트림 또는 리더/라이터 클래스를 구현하라. 당장은 순환 참조를 신경 쓰지 말자.

#### 3. 연습문제 2번을 반복하되, 이번에는 순환 참조를 신경 써서 구현하라.

#### 4. 연습문제 3번에서 만든 직렬화 메커니즘에 transient 제어자처럼 동작하는 @Transient 애너테이션을 추가하라.

#### 5. 완료해야 하는 일을 설명하는 메시지가 담긴 @Todo 애너테이션을 정의하라. 그리고 소스 파일로부터 상기용 목록(reminder list)를 만들어내는 애너테이션 핸들러를 정의하라. 애너테이션이 붙은 아이템의 설명과 할 일 관련 메시지를 포함하라.

#### 6. 연습문제 5번에서 만든 애너테이션을 반복 애너테이션으로 바꿔라.

#### 7. 자바 초기 버전에 애너테이션이 있었다면 자바독 역할을 맡았을 수도 있다. @Param, @Return 등의 애너테이션을 정의하고, 애너테이션 핸들러로 이 애너테이션들을 처리하려 기본적인 HTML 문서를 만들라.

#### 8. 애너테이션이 나타난 클래스의 이름 뒤에 Test를 붙이 이름으로 소스 파일을 생성하는 @TestCase 애너테이션을 구현하라. 예를 들어 MyMath.java 파일에 다음 코드가 포함되어 있다고 하자.

```java
@TestCase(params="4", expected="24")
@TestCase(params="0", expected="1")
public static long factorial(int n) {
    // ...
}
```

이 경우 다음과 같은 문장이 포함된 MyMathTest.java 파일을 생성한다.

```java
assert(MyMath.factorial(4) == 24);
assert(MyMath.factorial(0) == 1);
```

테스트 메세드는 정적 메서드고, params가 올바른 타입 파라미터로 구성된 콤마 분리 목록을 포함한다고 가정한다.

#### 9. @TestCase 에너테이션을 실행 시간 애너테이션으로 구현하고, 이 애너테이션을 검사하는 도구를 제공하라. 이번에도 테스트 메서드가 정적 메서드라고 가정하고, 파라미터와 반환 타입은 애너테이션 요소에서 문자열로 나타내기 적합한 것으로 제한하면 된다.

#### 10. @Resource 애너테이션용 핸들러를 구현하라. 이 애너테이션 핸들러는 어떤 클래스의 객체를 받고, @Resource(name="URL")이 붙은 String 타입 필드를 찾는다. 그런 다음 전달받은 URL을 로드하고, 리플렉션을 사용해서 해당 URL의 내용을 담은 문자열 변수를 '주입'해야 한다.