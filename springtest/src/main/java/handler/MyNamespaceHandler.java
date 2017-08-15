package handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import parser.UserBeanDefinitionPaser;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionPaser());
    }
}
