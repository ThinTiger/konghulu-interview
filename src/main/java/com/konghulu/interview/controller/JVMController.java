package com.konghulu.interview.controller;

import com.konghulu.interview.domain.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jvm")
public class JVMController {

    @RequestMapping("/address")
    public String address(){
	Person[] arrary = new Person[10];
	arrary[0] = new Person();
	arrary[1] = new Person();

	System.out.println(arrary);
	System.out.println(arrary[0]);
	System.out.println(arrary[1]);

	System.out.println(arrary.hashCode());
	System.out.println(arrary[0].hashCode());
	System.out.println(arrary[1].hashCode());
        return "123!~";
    }
}
