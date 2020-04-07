package cn.bjtu.i18n;

import org.junit.Test;

import java.security.PublicKey;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author shkstart
 * @create 2020-03-24 11:09
 */
public class I18nTest {
    @Test
    public void testLocale(){
        // 获取系统默认的语言、国家信息
//        Locale locale = Locale.getDefault();
//        System.out.println(locale);

//        for (Locale availableLocale : Locale.getAvailableLocales()) {
//            System.out.println(availableLocale);
//        }

        // 获取中文，中文的常量的Locale对象
        System.out.println(Locale.CHINA);
        // 获取英文，美国的常量的Locale对象
        System.out.println(Locale.US);
    }

    @Test
    public void testi18n(){
        // 得到我们需要的Locale对象
        Locale locale = Locale.CHINA;
        // 通过指定的basename和Locale对象，读取 相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        System.out.println("用户名：" + bundle.getString("username"));
        System.out.println("密码：" + bundle.getString("password"));
        System.out.println("性别：" + bundle.getString("sex"));
        System.out.println("年龄：" + bundle.getString("age"));
    }
}
