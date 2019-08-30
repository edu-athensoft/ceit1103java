package com.athensoft.java.advanced.annotation;

public class ReflectTest {
	@Reflect
    public static void sayHello(final String name) {
        System.out.println("==>> Hi, " + name + " [sayHello]");
    }

    @Reflect(name = "AngelaBaby")
    public static void sayHelloToSomeone(final String name) {
        System.out.println("==>> Hi, " + name + " [sayHelloToSomeone]");
    }

    public static void main(final String[] args) throws Exception {
        final ReflectProcessor relectProcessor = new ReflectProcessor();
        relectProcessor.parseMethod(ReflectTest.class);
        
        //mycode
        ReflectTest rt = new ReflectTest();
        rt.sayHello("Yaya");
    }
}
