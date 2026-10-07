package com.ExceptionHandling.GlobalExceptionHandler.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    @GetMapping("/api4")
    public void method2() {
//        try{
//            String a=null;
//            a.length();
//            return "Hi";
//        } catch (Exception e) {
//            return e.getClass()+":"+e.getMessage();
//        }
        String a=null;
        a.length();

    }

    @GetMapping("/api5")
    public String method3() throws  Exception{
//        try{
//            throw new Exception("this is a greate exception");
//        } catch (TestException e) {
//            return e.getClass()+":"+e.getMessage();
//        }
        throw new Exception("This is exception2");
    }
    @GetMapping("/api6")
    public String method4() throws  Exception{
//        try{
//            throw new Exception("this is a greate exception");
//        } catch (TestException e) {
//            return e.getClass()+":"+e.getMessage();
//        }
        throw new Exception("This is exception is using exception clas");
    }
}
