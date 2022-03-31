package ir.mapsa.jlottery.jlottery.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("within(ir.mapsa.jlottery.jlottery.service..*)")
    public void allServices() {
    }

    @Pointcut("within(ir.mapsa.jlottery.jlottery.controller..*)")
    public void allControllers() {
    }

    @Pointcut("within(ir.mapsa.jlottery.jlottery.util.jwt..*)")
    public void jwt() {
    }

    @AfterThrowing(pointcut = "allServices() || jwt() || allControllers()", throwing = "error")
    public void afterThrowingAdvice(JoinPoint jp, Throwable error) {
        log.error("Method Signature: " + jp.getSignature());
        log.error("Exception: " + error);
    }

/*    @Around("allServices() || jwt()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(String.format("The method: %s is going to call from class: %s",
                joinPoint.getSignature().toString(),
                joinPoint.getTarget().getClass().getSimpleName()
        ));
        Object returnObj = joinPoint.proceed(joinPoint.getArgs());


        log.info(String.format("The method: %s has called from class %s with return value type: %s",
                joinPoint.getSignature().toString(),
                joinPoint.getThis().getClass().getSimpleName(),
                returnObj.getClass().getSimpleName()
        ));
        return returnObj;
    }*/


}
