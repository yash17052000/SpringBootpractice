package com.ExceptionHandling.GlobalExceptionHandler.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api1")
    public String method1() {
//        try{
//            int a=10/0;
//            return "Hello";
//        } catch (Exception e) {
//             return e.getClass()+":"+20;
//        }
        int a=10/0;
        return "Hello";
    }


    @GetMapping("/api2")
    public String method2() {
//        try{
//            String a=null;
//            a.length();
//            return "Hi";
//        } catch (Exception e) {
//            return e.getClass()+":"+e.getMessage();
//        }
        String a=null;
        a.length();
        return "Hi";

    }

    @GetMapping("/api3")
    public String method3() throws  Exception{
//        try{
//            throw new Exception("this is a greate exception");
//        } catch (TestException e) {
//            return e.getClass()+":"+e.getMessage();
//        }
        throw new TestException("this is a greate exception");
    }
}
