package com.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.springidol.Thinkier.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts) {}

    @Before("thinking(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("Catch volounters thoughts: " + thoughts);
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
