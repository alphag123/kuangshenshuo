package com.kuang.lambda;

/*
推导lambda表达式
 */
public class TestLambda1 {

    //3.静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}