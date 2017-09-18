package advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Administrator on 2017/8/20 0020.
 */
@Aspect
public class AspectJTest {
    @Pointcut("execution(* *.test())")
    public void test(){

    }
    @Before("test()")
    public void beforeTest(){
        System.out.println("start test");
    }
    @After("test()")
    public void afterTst(){
        System.out.println("end test");
    }
    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint point){
        System.out.println("开始环绕");
        Object o = null;
        try {
            o = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("结束环绕");
        return o;
    }
}
