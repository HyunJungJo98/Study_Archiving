package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    //http의 body부에 데이터를 직접 넣어줄 것
    @ResponseBody
    public String helloString(@RequestParam(value = "name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    //http의 body부에 데이터를 직접 넣어줄 것
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체 넘기기
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
