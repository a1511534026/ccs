import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroText {
    public static void main(String[] args) {
        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-first.ini");
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan","123456");

        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        boolean b = subject.isAuthenticated();
        System.out.println(b);
    }
}
