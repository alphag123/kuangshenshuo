import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {

        //用户实际调用的业务层，dao层不需要接触
        /*UserService userService = new UserServiceImpl();
        userService.getUser();*/
        //获取ApplicationContext
        //拿到Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    }

}
