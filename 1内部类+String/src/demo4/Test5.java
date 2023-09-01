package demo4;

/**
 * ClassName: Test5
 * Package: demo4
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/5/7 1:01
 * Version 1.0
 */
public class Test5 {
    public String name = "Admin";
    public String password = "123456";

    public void login(String name,String password)
            throws UserNameException,PassWordException {
        if (!this.name.equals(name)) {
            System.out.println("用户名错误！");
            throw new UserNameException();
        }
        if (!this.password.equals(password)) {
            System.out.println("密码错误!");
            throw new PassWordException();
        }
    }
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        try {
            test5.login("admin","12345");
        }catch (UserNameException e) {
            e.printStackTrace();
            System.out.println("用户名异常");
        }catch (PassWordException e){
            e.printStackTrace();
            System.out.println("密码异常");
        }  finally{

        }

    }
}
