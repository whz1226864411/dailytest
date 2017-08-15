package client;

import bean.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad(){
        BeanFactory bf =new XmlBeanFactory(new ClassPathResource(("beanFactoryTest.xml")));
        User myTestBean = (User)bf.getBean("aa");
        System.out.println(myTestBean.getEmail());
    }
}
