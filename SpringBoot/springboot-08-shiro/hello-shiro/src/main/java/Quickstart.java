import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class Quickstart {

    private static final transient Logger log = (Logger) LoggerFactory.getLogger(Quickstart.class);

    public static void main(String[] args) {

        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = (SecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager((org.apache.shiro.mgt.SecurityManager) securityManager);

        //获取当前的Subject，调用SecurityUtils.getSubject()
        Subject currentUser = SecurityUtils.getSubject();
        //测试使用session
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");

        if (value.equals("aValue")) {
            log.info("Retrieved the correct value! [" + value + "]");
        }


        //当前的用户是否已经被认证，即是否已经登录，调用Subject的isAuthenticated()
        if (!currentUser.isAuthenticated()) {
            //把用户名和密码封装为UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            //rememberMe
            token.setRememberMe(true);//设置记住我

            try {
                //执行登录
                currentUser.login(token);
            } catch (UnknownAccountException uae) {//若没有指定的账户，则shiro抛出UnknownAccountException未知的账户异常
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {//若账户存在，密码不匹配，shiro会抛出IncorrectCredentialsException错误的凭证异常
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {//若账户被锁定，则抛出LockedAccountException账户锁定异常
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            //所有认证异常的父类（总认证异常）
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }


        //currentUser.getPrincipal()获取用户名
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
        //测试是否拥有某一个角色，调用Subject的hasRole()方法
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }
        //测试拥有某一个行为，调用Subject的isPermitted()方法
        if (currentUser.isPermitted("lightsaber:wield")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }
        //测试拥有某一个更加具体行为，比如：让user对zhangsan进行selete(让用户对张三进行删除)
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }
        //注销注销，调用Subject的logout()方法
        currentUser.logout();
        System.exit(0);
    }
}