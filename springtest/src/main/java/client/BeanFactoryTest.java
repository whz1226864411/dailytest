package client;

import bean.MyTestBean;
import org.junit.Assert;
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
        MyTestBean myTestBean = (MyTestBean)bf.getBean("myTestBean");
        System.out.println(myTestBean.getName());
    }
}
