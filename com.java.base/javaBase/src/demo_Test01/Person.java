package demo_Test01;

public class Person {

    String name;
    public void sayName(String name){
        System.out.println("你好："+this.name);
        //this就是调用上面的name，否则就是就近原则，而且哪个对象调用该方法，this就是那个对象
    }
}
