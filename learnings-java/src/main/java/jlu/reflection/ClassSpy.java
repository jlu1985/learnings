package jlu.reflection;

import java.util.Arrays;

enum ClassMember {
    ALL, CLASS, CONSTRUCTOR, FIELD, METHOD
}

public class ClassSpy {
    public static void main(String... args) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, SecurityException {
        try {
            Class<?> c = Class.forName("jlu.reflection.ClassSpy");
            Package p = c.getPackage();

            Arrays.stream(c.getFields()).forEach(System.out::println);
            Arrays.stream(c.getDeclaredMethods()).forEach(System.out::println);

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private ClassSpy member1;

    public void method1() {
    }

    public void sayHello() {
        System.out.println("Hello world!");
    }

    private void sayHelloSecretly() {
        System.out.println("Secretly say hello");
    }

}