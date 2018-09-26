package com.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AroundAudience {
    //<start id="audience_around_bean"/>
    @Pointcut("execution (* com.springidol.Performer.perform(..))")
    public void performance() {

    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinpoint) {
        try {
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis(); //<co id="co_beforeProceed"/>

            joinpoint.proceed(); //<co id="co_proceed"/>

            long end = System.currentTimeMillis(); // <co id="co_afterProceed"/>
            System.out.println("CLAP CLAP CLAP CLAP CLAP");
            System.out.println("The performance took " + (end - start)
                    + " milliseconds.");
        } catch (Throwable t) {
            System.out.println("Boo! We want our money back!"); //<co id="co_afterException"/>
        }
    }
    //<end id="audience_around_bean"/>
}
