package com.test.springtest.Aspect;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springtest.annotation.LimitKey;
import com.test.springtest.pojo.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author  作者 : 小布
 * @version 创建时间 : 2019年6月11日 下午3:57:27
 * @explain 类说明 : 限制访问次数
 */
@Component
@Order
@Aspect
public class LimitAspect {

    private Map limitMap = new HashMap();


    private static final Logger log = LoggerFactory.getLogger(LimitAspect.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Pointcut("@annotation(limitKey)")
    public void limit(LimitKey limitKey) {
    }

    @Around("limit(limitKey)")
    public Object aroundLog(ProceedingJoinPoint joinpoint,LimitKey limitKey) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
        int frequency = limitKey.frequency();
        String methodName = limitKey.methodName();
        String paramKey = limitKey.paramKey();
        String url = limitKey.url();
        //入参
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinpoint.getArgs();
        System.out.println("***********************************参数***************************************");
        System.out.println(parameterNames[1]);
        System.out.println(args[1]);
        System.out.println(methodName);
        System.out.println(url);
        Object obj = null ;

        for(int i = 0 ; i < parameterNames.length;i++) {
            if(parameterNames[i].equals(paramKey)) {
                obj = args[i];
                break;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(url).append("/_").append(methodName).append("_").append(paramKey).append("_").append(obj).append("_key");
        if(limitMap.get(sb.toString()) == null ) {
            System.out.println("-----------------------------------------------------------");
            limitMap.put(sb.toString(),frequency-1);
        } else {
            int l = (int) limitMap.get(sb.toString());
            if(l > 0){
                limitMap.put(sb.toString(), --l);
            } else {
                Map<String, Object> mp = new HashMap<String, Object>();
                System.out.println("********************************************************");
                mp.put("msg", "接口超过请求次数");
                return (Student)mp;
            }
        }
        System.err.println("剩余次数："+limitMap.get(sb.toString())+" 自定义key:"+sb.toString());
        Object object =joinpoint.proceed();
        System.out.println("*****************************返回值***************************");
        System.out.println(object);
        return object;
    }

}
