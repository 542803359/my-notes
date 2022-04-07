package com.xiaowenxing.demoproxy.aspect;

import com.xiaowenxing.demoproxy.annotation.AccessLimit;
import com.xiaowenxing.demoproxy.annotation.ParamMark;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 吃饭切面类
 *
 * @author XWX
 * @date 2021/6/9 16:22
 * @since 3.6
 **/
@Component
@Aspect
public class EatAspect {

    /**
     * 定义切入点,表示需要切入的位置,比如某些类或者某些方法,也就是先定一个范围
     * <p>
     * 1）execution(* *(..))
     * 表示匹配所有方法
     * <p>
     * 2）execution(* com.xiaowenxing.demoproxy.xxx.*(..))
     * 表示匹配com.xiaowenxing.demoproxy.xxx中所有的公有方法
     * <p>
     * 3）execution(* com.xiaowenxing.demoproxy..*.*(..))
     * 表示匹配com.xiaowenxing.demoproxy包及其子包下的所有方法
     */
    @Pointcut("execution(* com.xiaowenxing.demoproxy.aspect.*.*(..))")
    public void eatPointcut() {
    }

    /**
     * @Aspect：切面。表示一个横切进业务的一个对象。它里面包含切入点(Pointcut)和Advice（通知）。
     * @Pointcut：切入点。表示需要切入的位置，比如某些类或者某些方法，也就是先定一个范围。
     * @Before：Advice（通知）的一种，切入点的方法体执行之前执行。
     * @Around：Advice（通知）的一种，环绕切入点执行也就是把切入点包裹起来执行。
     * @After：Advice（通知）的一种，在切入点正常运行结束后执行。
     * @AfterReturning：Advice（通知）的一种，在切入点正常运行结束后执行，异常则不执行
     * @AfterThrowing：Advice（通知）的一种，在切入点运行异常时执行
     */

    // @Before("eatPointcut()")
    public void Before(JoinPoint jp) {
        MethodSignature signature = (MethodSignature) jp.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        System.out.println("切面拦截,执行方法=====" + method.getName());
        System.out.println("吃饭前要洗手");
    }

    //  @After("eatPointcut()")
    public void After() {
        System.out.println("吃饭后散步");
    }

    //  @Around("eatPointcut()")
    public void Around(ProceedingJoinPoint pjp) {
        long beginTime = System.currentTimeMillis();
        // 执行方法,ob为方法的返回值
        try {
            try {
                pjp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } finally {
            // 执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;

            MethodSignature signature = (MethodSignature) pjp.getSignature();
            //获取切入点所在的方法
            Method method = signature.getMethod();
            System.out.println("方法 + " + method.getName() + " 执行时间 : " + time);

        }
    }


    /**
     * 切点为某一个指定的方法
     */
    @Pointcut("execution(* com.xiaowenxing.demoproxy.aspect.EatController.drinkWater())")
    public void drinkWater() {
    }

    @After("drinkWater()")
    public void AfterWater() {
        System.out.println("喝太多水,要上厕所");
    }


    /**
     * 切点为某一个指定的注解
     */
    @Pointcut("@annotation(com.xiaowenxing.demoproxy.annotation.AccessLimit)")
    public void getVcode() {
    }


    @Before("getVcode()")
    public void getVcodePointcut(JoinPoint jp) {
        System.out.println("获取验证码进行拦截,查看手机号获取验证码的次数");
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法名===" + method.getName());
        AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);

        try {
            Class<?> forName = Class.forName(accessLimit.className());
            Method method1 = forName.getMethod(accessLimit.methodName());
            Object getParam = method1.invoke(forName.newInstance(), (Object[]) null);
            System.out.println("手机号===" + getParam.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 切点为某一个指定的注解
     */
    @Pointcut("@annotation(com.xiaowenxing.demoproxy.annotation.ParamHandle)")
    public void paramHandle() {
    }

    /**
     * 拦截方法,修改方法返回值
     *
     * @param jp
     * @return
     */
    @Around("paramHandle()")
    public Object paramHandleAround(ProceedingJoinPoint jp) {

        try {
            //执行方法,获取执行结果
            Object obj = jp.proceed();
            //处理获取的结果,拿到结果中的字段属性
            Field[] fields = obj.getClass().getDeclaredFields();
            //遍历字段
            for (Field field : fields) {
                //判断字段是否带有自定义注解,如果有则处理
                boolean annotationPresent = field.isAnnotationPresent(ParamMark.class);
                if (annotationPresent) {
                    //将private私有开放
                    field.setAccessible(true);
                    Object result = field.get(obj);
                    System.out.println(result.toString());
                    //处理字段值
                    field.set(obj, result + "AOP");
                    field.setAccessible(false);
                }
            }
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}
