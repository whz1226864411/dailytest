package client;

import bean.Chicken;
import bean.Egg;
import bean.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.security.acl.LastOwnerException;
import java.util.Locale;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        Object[] params = {"whz"};
        System.out.println(context.getMessage("test",params, Locale.CHINA));
        System.out.println(context.getMessage("test",params, Locale.US));
    }
}
