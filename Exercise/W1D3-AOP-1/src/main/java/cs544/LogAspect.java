package cs544;
import org.apache.logging.log4j.Level;
import  org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());
    @After("execution(* cs544.EmailSender.sendEmail(..))")

    public void logTargetAfter(JoinPoint joinpoint)
    {
        EmailSender sender= (EmailSender) joinpoint.getTarget();
        logger.warn(String.format("method =%s address=%s message=%s" +
                        " outgoing mail server=%s",joinpoint.getSignature().getName(),
                joinpoint.getArgs()[0],
                joinpoint.getArgs()[1],
                sender.getOutgoingMailServer()));
       // System.out.println("From Logger");
    }
    @Around("execution(* cs544.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        System.out.println(String.format("Time to execute save = %s",totaltime));
        return retVal;
    }

}
