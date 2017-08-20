package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class Chicken {
    @Autowired
    @Qualifier("egg")
    public Egg egg;

}
