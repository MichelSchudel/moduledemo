package nl.craftsmen.java9demo.foo;

import nl.craftsmen.java9demo.bar.Bar;

//import nl.craftsmen.java9demo.bar.util.BarHelper;

public class Foo {

    private Bar bar;
    //private BarHelper barhelper  = new BarHelper();

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.execute();
    }

    public Foo() {
        this.bar = new Bar();
    }

    public void execute() {
        executePublicBar();
        executePrivateishBarHelper();
        executeBarHelpWithReflection();
    }

    private void executeBarHelpWithReflection() {
        try {
            Class<?> barHelperClass = Class.forName("nl.craftsmen.java9demo.bar.util.BarHelper");
            barHelperClass.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    private void executePrivateishBarHelper() {
        //barhelper.execute();
    }

    private void executePublicBar() {
        bar.execute();
    }
}
