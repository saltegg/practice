package fzu.com.test;

public class ExtendsTest extends Person{

    public void show() {
        System.out.println("zi");
    }

    public static void main(String[] args) {
        ExtendsTest test = new ExtendsTest();
        //test.show();
        // test.show("bbb", 12);
        Integer a = 10;
        a = 12;
        System.out.println(a);
    }
}

class Person {

    private String name;
    private int age;

    private void show() {
        System.out.println("fu");
    }

}
