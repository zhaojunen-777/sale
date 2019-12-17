package com.atguigu.sale;
interface Foo{
    //public void sayHello();
    public int add(int x, int y);
}
public class Hello {
    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("hello");
//            }
//        };
//        foo.sayHello();
//        Foo foo1 = ()->{System.out.println("hello");};
//        foo1.sayHello();
        Foo foo = (x,y)->{
            return x+y;
        };
        System.out.println(foo.add(5,5));
    }
}
