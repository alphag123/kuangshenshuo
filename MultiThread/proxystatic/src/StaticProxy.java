//静态代理模式
//真实对象和代理对象都需要实现同一个接口
//代理对象要代理真实角色

//好处：
    //代理对象可以做很多真实对象做不了的事情
    //真实对象专注做自己的事情

public class StaticProxy {

    public static void main(String[] args) {

        You you = new You();//你要结婚

        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.HappyMarry();
    }

}

interface Marry{
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("秦老师要结婚了，超开心");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry{

    //代理谁--真是目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这就是真实对象
        after();
    }

    public void after(){
        System.out.println("结婚之后，收尾款");
    }

    public void before(){
        System.out.println("结婚之前，布置现场");
    }
}
