package factorybean;

import bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class UserFactoryBean implements FactoryBean<User>{
    private String infors;
    public User getObject() throws Exception {

        return null;
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public void setInfors(String infors) {
        this.infors = infors;
    }
}
