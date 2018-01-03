package nl.craftsmen.java9demo.foo;

import nl.craftsmen.java9demo.bar.Bar;
import nl.craftsmen.java9demo.bar.util.BarHelper;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Foo {

    private Bar bar;
    private BarHelper barhelper  = new BarHelper();

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.execute();
    }

    public Foo() {
        this.bar = new Bar();
    }

    public void execute() {
        bar.execute();
        barhelper.execute();
        try {
            Class<?> barHelperClass = Class.forName("nl.craftsmen.java9demo.bar.util.BarHelper");
            Method[] methods = barHelperClass.getMethods();
            System.out.println(Arrays.stream(methods).map(Method::toString).collect(Collectors.toList()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
