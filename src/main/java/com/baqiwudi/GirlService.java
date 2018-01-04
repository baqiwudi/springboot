package com.baqiwudi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Gril girl = new Gril();
        girl.setCupSize("A");
        girl.setAge(10);
        girlRepository.save(girl);

        Gril girl2 = new Gril();
        girl2.setCupSize("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        girl2.setAge(11);
        girlRepository.save(girl2);
    }

}
