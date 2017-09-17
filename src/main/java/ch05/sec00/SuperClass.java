package ch05.sec00;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SuperClass {

    public void someMethod() throws IOException {
        throw new FileNotFoundException();
    }

}
