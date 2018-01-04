package com.baqiwudi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private String age;

    @Value("${content}")
    private String content;

    @Autowired
    private Boy boy;


    @RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
    public String sayHello(){
        return "hello or hi word"+boy.getCupSize();
    }

    @RequestMapping(value = {"/{id}/hello2"}, method = RequestMethod.GET)
    public String sayHello2(@PathVariable(value = "id") Integer id){
        return "sayHello2"+id;
    }


    @RequestMapping(value = {"/hello3"}, method = RequestMethod.GET)
    public String sayHello3(@RequestParam(value = "id",defaultValue = "0") Integer id){
        return "sayHello3"+id;
    }
}
