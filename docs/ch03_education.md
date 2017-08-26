# 3장 인터페이스와 람다 표현식

[Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)<br>
[람다가 이끌어 갈 모던 Java](http://d2.naver.com/helloworld/4911107)

## 3.1 인터페이스

### 3.1.1 인터페이스 선언하기

다음과 같이 인터페이스를 선언하고 메서드 선언부를 작성한다.

```java
public interface IntSequence {
    boolean hasNext();
    int next();
}
```

인터페이스의 모든 메서드는 자동으로 **public**이 된다.

IntSequence 인터페이스를 구현할 수 있는 클래스는 많다.

### 3.1.2 인터페이스 구현하기

implements 키워드는 SquareSequence 클래스가 IntSequence 인터페이스를 따른다는 의미다.

```java
public class SquareSequence implements IntSequence {
    private int i;
    
    public boolean hasNext() {
        return true;
    }
    
    public int next() {
        i++;
        return i * i;
    }
}
```

```java
public class DigitSequence implements IntSequence {
    private int number;

    public DigitSequence(int n) {
        number = n;
    }

    public boolean hasNext() {
        return number != 0;
    }

    public int next() {
        int result = number % 10;
        number /= 10;
        return result;
    }
    
    public int rest() {
        return number;
    }
}
```

구현하는 클래스는 인터페이스의 모든 메서드를 구현한다. 만약 클래스가 인터페이스의 메서드 중 일부만 구현한다면 해당 클래스는 반드시 abstract 제어자로 선언해야 한다.

```java
abstract public class SquareSequence implements IntSequence {
    private int i;
    
    // do not implement hasNext()
    
    public int next() {
        i++;
        return i * i;
    }
}
```

### 3.1.3 인터페이스 타입으로 변환하기

```java
// DigitSequence digits = new DigitSequence(1729);
IntSequence digits = new DigitSequence(1729);
```

digit의 타입은 DigitSequence가 아니라 IntSequence다. IntSequence 타입 변수는 IntSequence 인터페이스를 구현한 어떤 클래스의 객체라도 참조할 수 있다.

서브타입의 모든 값을 변환 없이 슈퍼타입 변수에 할당할 수 있으면 타입 S는 타입 T(서브타입)의 슈퍼타입니다. IntSeuqence 인터페이스는 DigitSequence 클래스의 슈퍼타입이다.

### 3.1.4 타입 변환과 instanceof 연산자

가끔은 반대로 변환(슈퍼타입 → 서브타입)하는 것도 필요하다. 이 때는 타입 변환(cast)을 해야 한다.

```java
IntSequence sequence = ...;
DigitSequence digits = (DigitSequence) sequence;
// DigitSequence 에만 있는 메서드
digits.rest();
```

객체는 실제 클래스나 해당 클래스의 슈퍼타입으로만 타입을 변환할 수 있다. 만일 실수하면 컴파일 시간 오류나 클래스 캐스트 예외(ClassCastException)가 일어난다.

### 3.1.5 인터페이스 확장하기

인터페이스는 또 다른 인터페이스를 확장해서 원래 있던 메서드 이외의 추가 메서드를 제공할 수 있다.

```java
public interface Closeable {
    void close();
}
```

Channel 인터페이스는 다음과 같이 Closeable 인터페이스를 확장한다.

```java
public interface Channel extends Closeable {
    boolean isOpen();
}
```

Channel 인터페이스를 구현하는 클래스는 반드시 두 메서드를 모두 구현해야하며, 해당 클래스의 객체를 두 인터페이스 타입중 어느 것으로도 변환할 수 있다.

```java
public class SocketChannel implements Channel {
    
    public boolean isOpen() {
        // ...
    }
    
    public void close() {
        // ...
    }  
}
```

```java
Channel channel = new SocketChannel();
Closeable closeable = new SocketChannel();
```

### 3.1.6 여러 인터페이스 구현하기

클래스는 인터페이스를 몇 개든 구현할 수 있다.

```java
public class FileSequence implements IntSequence, Closeable {
    // IntSequence
    public boolean hasNext() {
        
    }
    // IntSequence
    public int next() {
        
    }
    // Closeable
    public void close() {
        
    }
    
}
```

### 3.1.7 상수

인터페이스에 정의한 변수는 자동으로 public static final이다.

```java
public interface SwingConstants {
    int NOTRH = 1;
    int NORTH_EAST = 2;
    int EAST = 3;
}
```

상수 집합에는 열거(enumeration)를 사용하는 것이 훨씬 좋다.

## 3.2 정적 메서드와 기본 메서드

자바 8 이전에는 인터페이스의 모든 메서드가 추상 메서드여야 했다. 다시 말해 구현부가 없어야 했다. 그런데 자바 8은 실제 구현이 있는 메서드(정적 메서드와 기본 메서드)를 추가할 수 있다.

### 3.2.1 정적 메서드

기술적으로 보면 인터페이스에 정적 메서드가 포함되지 못할 이유는 없었다. 하지만 인터페이스를 추상 명세로 보는 관점에 맞지 않았다. 그런데 이제는 이런 사고가 진화했다. 특히, 팩토리 메서드는 인터페이스에 아주 잘 맞는다.

````java
IntSequence digits = IntSequence.digitsOf(1729);
````

이 메서드는 IntSequence 인터페이스를 구현한 클래스 중에서 인스턴스 하나를 주지만, 호출자는 이 인스턴스가 어느 클래스의 인스턴스인지 신경 쓸 필요가 없다.

```java
public interface IntSequence {
    
    public static IntSequence digitsOf(int n) {
        return new DigitSequence(n);
    }
}
```

예전에는 보통 적적 메서드를 동반 클래스(companion class)에 두었다. 표준 라이브러리에서 Collection/Collections나 Path/Paths와 같은 인터페이스와 유틸리티 클래스의 쌍을 볼 수 있다. 하지만 지금은 이런 분할이 더는 필요 없다.

```java
package java.nio.file;

public interface Path {
    
}
```

```java
package java.nio.file;

import java.nio.file.spi.FileSystemProvider;
import java.net.URI;

/**
 * This class consists exclusively of static methods that return a {@link Path}
 * by converting a path string or {@link URI}.
 *
 * @since 1.7
 */
public final class Paths {
    private Paths() { }

    public static Path get(String first, String... more) {
        // ...
    }

    public static Path get(URI uri) {
        // ...
    }
}
```

### 3.2.2 기본 메서드

인터페이스의 메서드 중 어느 것에든 기본 구현을 작성할 수 있다. 기본 메서드에는 반드시 **default** 제어자를 붙여야한다.

```java
public interface IntSequence {
    // 기본적으로 시퀀스는 무한이다.
    default boolean hasNaext() {
        return true;
    }
    
    int next();
}
```

이 인터페이스를 구현하는 클래스는 hasNext 메서드를 오버라이드하거나 기본 구현을 상속하는 방법 중 하나를 선택할 수 있다.

### 3.2.3 기본 메서드의 충돌 해결하기

클래스에서 인터페이스 두개를 구현하려면 기본 메서드를 작성하거나 이름과 파라미터 타입이 같은 메서드를 작성할 때 반드시 충돌을 해결해야 한다.

```java
public interface Persion {
    String getName();
    default int getId() {
        return 0;
    }
}
```

```java
public interface Identified {
    default int getId() {
        return Math.abs(hashCode());
    }
}
```

Person 인터페이스와 Identified 인터페이스를 구현하는 경우 자바 컴파일러는 그 중 하나를 우선해서 선택할 수 없다. 결국 컴파일러는 오류를 보고하게 되고, 이와 같은 모호함은 개발자가 해결해야 한다.

```java
public class Employee implements Person, Identified {
    // ...
}
```

getId 메서드를 직적 작성 하거나, 다음과 같이 충돌한 메서드 중 하나로 위임해야 한다.

```java
public class Employee implements Person, Identified {
    public int getId() {
        return Identified.super.getId();
    }
}
```

만약 Identified 인터페이스의 getId 메서드가 default가 아니더라도 같은 결과이다.

```java
public interface Identified {
    int getId();
}
```

컴파일러는 오류를 보고하며, 모호성을 해결하는 일은 개발자의 책임이다.

## 3.3 인터페이스의 예

아래 나오는 인터페이스들의 설명은 3.4.2에 나올 함수형 인터페이스의 예시이다.

### 3.3.1 Comparable 인터페이스

```java
public interface Comparable<T> {
    // 현재 객체(자신)가 다른 객체(인자로 들어온)와 비교.
    // 양수면 자신이 뒤, 음수면 자신이 앞, 0이면 동일
    int compareTo(T other);
}
```

### 3.3.2 Comparator 인터페이스

```java
public interface Comparator<T> {
    // o1가 o2보다 순서가 앞이면 양수, 같으면 0, 뒤이면 음수를 반환.
    int compare(T o1, T o2);
}
```

### 3.3.3 Runnable 인터페이스

```java
public interface Runnable {
    public abstract void run();
}
```

### 3.3.4 사용자 인터페이스 콜백

```java
public interface EventHandler<T> {
    void handle(T event);
}
```

## 3.4 람다 표현식

[λ](https://ko.wikipedia.org/wiki/%CE%9B) 문자는 [공신력 있는 수학 원리(Principia Mathematica)](https://plato.stanford.edu/entries/principia-mathematica/) 책에서 함수 파라미터를 나타내는 데 악센트 ^를 사용했다. 알론조 처치는 여기에 영감을 얻어 대문자 람다 Λ를 사용했고, 나중에는 소문자 람다 λ로 바꿧다. 그 이후로 파라미터 변수가 있는 표현식을 람다 표현식이라고 한다.

람다 표현식은 한 번이든 여러 번이든 나중에 실행할 수 있게 전달하는 코드 블록이다.

자바는 거의 모든 것이 객체인 객체 지향 언어다. 자바에는 함수 타입이 없다. 대신 함수를 객체로 표현한다.

다시말해서 특정 인터페이스를 구현하는 클래스의 인스턴스로 표현한다.

### 3.4.1 람다 표현식 문법

### 3.4.2 함수형 인터페이스

람다 표현식은 **추상 메서드가 한 개만 포함된 인터페이스에만 사용**할 수 있는데, 이런 인터페이스를 **함수형 인터페이스**라고 한다.

```java
package java.util;

public interface Comparator<T> {
    int compare(T o1, T o2);
}
```

Arrays.sort 메서드의 두 번째 파라미터는 Comparator 인터페이스의 인스턴스가 필요하다.

```java
Arrays.sort(words, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
});
```

Comaprator 인터페이스에는 메서드가 하나만 있다. 두 번째 파라미터에 다음과 같이 람다 표현식을 사용할 수 있다.

```java
Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
```

## 3.5 메서드 참조와 생성자 참조

### 3.5.1 메서드 참조

p143

### 3.5.2 생성자 참조

p145

## 3.6 람다 표현식 처리하기

### 3.6.1 지연 실행 구현하기

람다를 사용하는 핵심 목적은 지연 실행이다.

* 별도의 스레드에서 코드 실행
* 코드를 여러 번 실행
* 알고리즘의 올바른 지점에서 코드 실행
* 어떤 일이 일어날 때 코드 실행
* 필요할 때만 코드 실행

### 3.6.2 함수형 인터페이스 고르기

오토박싱을 줄이려면 기본 타입용의 특화 버전을 사용하는 것이 좋다.

java.util.function.Consumer&lt;Integer&gt; 대신 java.util.function.IntConsumer 사용하자.

### 3.6.3 자신만의 함수형 인터페이스 구현하기

함수형 인터페이스를 직접 구현할 때 @FunctionalInterface 애너테이션을 붙이자.
* 컴파일러가 애너테이션이 붙은 엔터티(entity)를 검사하는데, 추상 메서드 하나만 있는 인터페이스인지 검사한다.
* 자바독 페이지에 해당 인터페이스가 함수형 인터페이스라는 문장을 둔다.

```java
@FunctionalInterface
public interface PixelFunction {
    Color apply(int x, int y);
}
```

## 3.7 람다 표현식과 변수 유효 범위

### 3.7.1 람다 표현식의 유효 범위

람다 표현식의 구현부는 유효 범위가 중첩 블록과 같다. 따라서 이름 충돌(name conflicts) 규칙과 [이름 가리기(shadowing) 규칙](https://doanduyhai.wordpress.com/2012/07/07/variable-shadowing/)이 똑같이 적용된다.

```java
int first = 0;
// 오류 - first 변수를 이미 정의 했다.
Comparator<String> comp = (first, second) -> first.length() - second.length();
```

람다 표현식 안에 있는 this 키워드는 같은 유효 범위 규칙의 영향을 받는다.

```java
public class Application {
    public void doWork() {
        Runnable runner = () -> {
            System.out.println(this.toString()); // Application.toString()
        };
    }
}
```

표현식 this.toString()은 Runnable 인스턴스가 아니다. this.toString()은 Application 객체의 toString 메서드를 호출한다.

```java
public class Application {

    public void doWork() {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                System.out.println(this.toString());
            }
        };

        runner.run();
    }

    public static void main(String[] args) {
        Application a = new Application();
        a.doWork(); // Runnable.toString()
    }

}
```

### 3.7.2 바깥쪽 유효 범위에 속한 변수 접근하기

```java
public static void repeatMessage(String text, int count) {
    Runnable r = () -> {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
}
```

이 람다 표현식에서는 람다 표현식의 내부가 아니라 바깥쪽 유효 범위에 정의된 파라미터 변수 test와 count에 접근하고 있다.

람다 표현식을 표현하는 자료 구조는 반드시 이 변수들의 값을 저장해야한다. 이를 가리켜 **람다 표현식이 이 값들을 캡처했다**고 말한다.

람다 표션식은 자신을 감싸고 있는 유효 범위(enclosing scope)에 속한 변수의 값을 캡처할 수 있다.

람다 표현식은 자신을 감싸고 있는 유효 범위에 속한 사실상 최종(effectively final)인 지역 변수에만 접근할 수 있다. 사실상 최종 변수는 절대로 수정되지 않기 때문이다.

## 3.8 고차 함수

함수를 처리하거나 반환하는 함수를 고차 함수라고 한다.

### 3.8.1 함수를 반환하는 메서드

### 3.8.2 함수를 수정하는 메서드

### 3.8.3 Comparator 인터페이스의 메서드

## 3.9 지역 내부 클래스

람다 표현식이 생기기 한참 전부터 자바에는 함수형이든 아니든, 한 인터페이스를 구현하는 클래스를 간결하게 정의하는 메커니즘이 있었다.

### 3.9.1 지역 클래스

메서드 안에 클래스를 정의할 수 있다. 이렇게 메서드 안에 정의한 클래스를 지역 클래스(로컬 클래스)라고 한다.

클래스를 지역 클래스로 만들면 두 가지 이점이 있다.
* 클래스 이름이 메서드의 유효 범위 안으로 숨는다.
* 람다 표현식의 변수와 마찬가지로 지역 클래스의 메서드에서 지역 클래스를 감싸고 있는 유효 범위에 속한 변수에 접근할 수 있다.

```java
package ch03.sec09;

import java.util.Random;

public class AnonymousClassDemo {
    private static Random generator = new Random();

    public static IntSequence randomInts(int low, int high) {
        return new IntSequence() {
            public int next() { return low + generator.nextInt(high - low + 1); }
            public boolean hasNext() { return true; }
        };
    }
}
```

### 3.9.2 익명 클래스

자바에서 람ㄹ다 표현식이 생기기 전에는 익명 내부 클래스가 러너블(runnable), 비교자(comparator), 함수 객체(function object)를 제공하는 가장 간결한 문법이었다. 익명 내무 클래스는 레거시 코드에서 종종 보게 될 것이다.

요즘에는 메서드를 두 개 이상 제공해야 할 때만 익명 내부 클래스가 필요하다.

```java
package ch03.sec09;

import java.util.Random;

public class LocalClassDemo {
    private static Random generator = new Random();

    public static IntSequence randomInts(int low, int high) {
        class RandomSequence implements IntSequence {
            public int next() {
                return low + generator.nextInt(high - low + 1);
            }
            public boolean hasNext() {
                return true;
            }
        }

        return new RandomSequence();
    }
}
```