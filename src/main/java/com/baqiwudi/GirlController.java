package com.baqiwudi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController
{
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有人员列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Gril> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加人员（一般都用post请求）
     * @return
     */
    @PostMapping(value = "/girls")
    public Gril grilAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Gril girl = new Gril();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 通过ID获取人员
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Gril girlFindOne( @PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }
    /**
     * 通过ID更新人员(一般为Put请求)
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Gril girlUpdate( @PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Gril girl = new Gril();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    /**
     * 通过ID删除人员(一般为Delete请求)
     * @return
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete( @PathVariable("id") Integer id){
         girlRepository.delete(id);
    }

    /**
     * 查询年龄查询人员列表
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Gril> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 查询年龄查询人员列表
     * @return
     */
    @GetMapping(value = "/girls/insertTwo")
    public void girlListByAge(){
        girlService.insertTwo();
    }

}
