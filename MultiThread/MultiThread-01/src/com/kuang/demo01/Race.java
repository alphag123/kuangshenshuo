package com.kuang.demo01;

//模拟龟兔赛跑
public class Race implements Runnable{

    //胜利者
    private static String winner;

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            //判断比赛是否结束

            if(Thread.currentThread().getName().equals("兔子")&& i%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameover(i);
            if(flag){
                break;
            }


            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }

    //判断是否完成比赛
    private boolean gameover(int Steps){
        //判断是否有胜利者
        if(winner!=null){
            return true;
        }{
            if (Steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("winnner is"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
