#### 1. Point 클래스를 만들고 생성자 public Point(double x, double y)와 접근자 메서드 getX, getY를 정의하라. Point의 서브클래스 LabeledPoint를 만들고 생성자 ublic LabeledPoint(String label, double x, double y)와 접근자 메서드 getLabel을 정의하라.

```java
package ch04.ex01;

import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
```

```java
package ch04.ex01;

import java.util.Objects;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
```

#### 2. 연습문제 1번에서 만든 Point와 LabeledPoint 클래스에 toString, equals, hashCode 메서드를 정의하라.

```java
package ch04.ex02;

import java.util.Objects;

public class Point {
    // ...

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        // 두 객체가 동일한지 검사
        if (this == obj) return true;
        // 파라미터가 null 인지 검사
        if (obj == null) return false;
        // 같은 클래스인지 검사
        if (getClass() != obj.getClass()) return false;
        // 인스턴스 변수들의 값 비교
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return super.toString() + " [x=" + x + ", y=" + y + "]";
    }

}
```

```java
package ch04.ex02;

import java.util.Objects;

public class LabeledPoint extends Point {
    // ...

    @Override
    public int hashCode() {
        return Objects.hash(label, getX(), getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (getClass() != obj.getClass()) return false;
        return Objects.equals(label, ((LabeledPoint) obj).label);
    }

    @Override
    public String toString() {
        return super.toString() + " [label=" + label + "]";
    }
}
```

#### 3. Point 클래스의 인스턴스 변수 x와 y를 protected로 만든다. LabeledPoint 클래스는 LabeledPoint 인스턴에서만 이 변수들에 접근할 수 있음을 보여라.

```java
package ch04.ex03;

public class Point {
    protected double x;
    protected double y;
    
    // ...
}
```

```java
package ch04.ex03;

public class LabeledPoint extends Point {
    @Override
    public int hashCode() {
        return Objects.hash(label, x, y);
    }
        
    @Override
    public String toString() {
        return String.format("Point [x=%s, y=%s, label=%s]", x, y, label);
    }
}
```

#### 4. 추상 클래스 Shape를 정의하라. 이 클래스는 Point 클래스에 인트턴스 변수, 생성자, 지정한 양만큼 점을 옮기는 구체 메서드 public void moveBy(double dx, double dy)와 추상 메서드 public Point getCenter()를 작성해야 한다. 그체 서브클래스 Circle, Rectangle, Line을 정의하고 각각 생성자 public Circle(Point center, double radius), public Rectangle(Point topLeft, double width, double height), public Lind(Point from, Point to)를 포함하도록 만들라.

```java
package ch04.ex04;

abstract public class Shape {
    private Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point = new Point(point.getX() + dx, point.getY() + dy);
    }

    protected final Point getPoint() {
        return new Point(point.getX(), point.getY());
    }

    protected abstract Point getCenter();

}
```

```java
package ch04.ex04;

public class Circle extends Shape {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return getPoint();
    }

    public double getRadius() {
        return radius;
    }
}
```

```java
package ch04.ex04;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    protected Point getCenter() {
        Point point = getPoint();
        return new Point(point.getX() + (width / 2), point.getY() + (height /2));
    }

    public Point getTopLeft() {
        return getPoint();
    }
    
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
```

```java
package ch04.ex04;

public class Line extends Shape {
    private Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        to = new Point(to.getX() + dx, to.getY() + dy);
    }

    @Override
    protected Point getCenter() {
        Point from = getPoint();

        double x = from.getX() + ((to.getX() - from.getX()) /2);
        double y = from.getY() + ((to.getY() - from.getY()) /2);
        return new Point(x, y);
    }

    public Point getFrom() {
        return getPoint();
    }
    
    public Point getTo() {
        return new Point(to.getX(), to.getY());
    }
}
```

#### 5. 연습문제 4번에서 만든 클래스에 clone 메서드를 정의하라.

```java
package ch04.ex05;

public class Circle extends Shape implements Cloneable {
    // ...
    
    @Override
    public Circle clone() throws CloneNotSupportedException {
        return new Circle(getPoint(), radius);
    }
}
```

```java
package ch04.ex05;

public class Rectangle extends Shape implements Cloneable {
    // ...

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return new Rectangle(getPoint(), width, height);
    }
}
```

```java
package ch04.ex05;

public class Line extends Shape implements Cloneable {
    // ...
    
    @Override
    public Line clone() throws CloneNotSupportedException {
        return new Line(getPoint(), getTo());
    }
}
```

#### 6. 4.2.2 equals 메서드에서 다룬 Item.equals 메서드가 instanceof 검사를 이용한다고 하자. DiscountedItem.equals를 구현해서 otherObject가 Item이면 오직 슈퍼클래스만 비교하지만, DiscountedIte이면 할인까지 모함하게 하라. 이 메서드가 대칭성은 유지하지만, 추이적이지는 않음을 보여라. 즉 x.equals(y)와 y.equals(z)는 성립하지만 x.equals(z)는 성립하지 않는 아이템과 할인 아이템의 조합을 찾아라.

```java
package ch04.ex06;

public class Item {
    // ...

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        // instanceof
        if (!(otherObject instanceof Item)) return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description)
                && price == other.price;
    }

}
```

```java
package ch04.ex06;

public class DiscountedItem extends Item {
    // ..

    public boolean equals(Object otherObject) {
        if (otherObject instanceof DiscountedItem) {
            DiscountedItem other = (DiscountedItem) otherObject;
            return discount == other.discount;
        }
        return super.equals(otherObject);
    }
}
```

#### 7. 원색의 여덟 개 조합(BLACK, RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE)을 나타내고 getRed, getGreen, getBlue 메서드를 포함하는 열거 타입을 정의하라.

```java
package ch04.ex07;

public enum Color {
    BLACK, RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE;

    public static Color getRed() {
        return RED;
    }

    public static Color getGreen() {
        return GREEN;
    }

    public static Color getBlue() {
        return BLUE;
    }

}
```

#### 8. Class 클래스에는 Class 객체가 나타내는 타입의 문자열 표현을 돌려주는 메서드 여섯 개가 있다. 배열, 제네릭 타입, 내부 클래스, 기본타입에 이 메서드들을 적용하면 어떻게 달라지는가?

|Modifier and Type|Method and Description|
|:---|:---|
|String|**getCanonicalName()**<br/>Returns the canonical name of the underlying class as defined by the Java Language Specification.|
|String|**getName()**</br>Returns the name of the entity (class, interface, array class, primitive type, or void) represented by this Class object, as a String.|
|String|**getSimpleName()**<br/>Returns the simple name of the underlying class as given in the source code.|
|String|**getTypeName()**<br/>Return an informative string for the name of this type.|
|String|**toGenericString()**<br/>Returns a string describing this Class, including information about modifiers and type parameters.|
|String|**toString()**<br/>Converts the object to a string.|


#### 9. 리플렉션을 이용해서 객체의 인스턴스 변수를 모두 포함하는 문자열을 만들어내는 '보편적인' toString 메서드를 작성하라. 순환 참조를 처리하면 추가 점수가 있다.

```java
package ch04.ex09;

import java.lang.reflect.Field;

public class Employee {
    // ...

    @Override
    public String toString() {
        Class<? extends Employee> clazz = getClass();

        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getCanonicalName());
        sb.append(" [");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0 ; i < fields.length ; i++) {
            Field f = fields[i];

            try {
                Object o = f.get(this);

                if (i > 0) {
                    sb.append(", ");
                }

                sb.append(f.getName());
                sb.append("=");
                sb.append(o != null ? o.toString() : null);
            } catch (IllegalAccessException e) {

            }
        }

        sb.append("]");

        return sb.toString();
    }
}
```

#### 10. 4.5.1 클래스 멤버 나열하기에서 다른 MethodPrinter 프로그램을 사용해서 int[] 클래스의 모든 메서드를 나열하라. **이 장에서 다룬 내용 중에서 잘못 설명한 메서드 하나를 찾아내면 추가 점수가 있다.**

p192 Caution 참고

```text
Class name: [I
protected void finalize[]
public final void wait[]
public final void wait[long arg0, int arg1]
public final native void wait[long arg0]
public boolean equals[java.lang.Object arg0]
public java.lang.String toString[]
public native int hashCode[]
public final native java.lang.Class getClass[]
protected native java.lang.Object clone[]
public final native void notify[]
public final native void notifyAll[]
private static native void registerNatives[]
```

잘못된 메서드
* p204 Executable 클래스의 getParameter() 메서드의 리턴 타입 오타: Parameters[] -> Parameter[] (오타인듯? :p)
* p205 Array 클래스의 newInstance(Class&lt;?&gt; componentType, int[] lengths) -> 2번째 인자 int... dimemsions

#### 11. HelloWorld 프로그램을 작성하라. 리플렉션을 이용해서 java.lang.System의 out 필드를 찾은 다음 invoke로 println 메서드를 호출해야 한다.

```java
package ch04.ex11;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.System");
        // out field
        Field field = clazz.getDeclaredField("out");
        Object out = field.get(null);
        // out.println method
        Method method = PrintStream.class.getDeclaredMethod("println", new Class[]{String.class});
        method.invoke(out, "Hello World!");
    }

}
```

#### 12. 일반 메서드 호출과 리플렉션을 이용한 메서드 호출의 성능 차이를 측정하라.

[Enhancements to the Reflection API](https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/enhancements.html)

#### 13. double 또는 Double 타입 파라미터를 받는 정적 메서드를 나타내는 Method의 값들을 표로 출력하는 메서드를 작성하라. Method 객체 외에도 하한, 상한, 증감 크기를 받게 만들라 이 메서드로 Meth.sqrt와 Double.toHexString의 값들을 표로 출력하는 예를 보여라. Method 대신 DoubleFunction&lt;Object&gt;를 사용해서 풀이를 반복하라(3.6.2 함수형 인터페이스 고르기 참고). 두 접근법의 안전성, 효율성, 편의성을 비교하라.

? 뭔소리인지...