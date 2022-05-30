package com.java_springboot.java_springboot.WebController;

import com.java_springboot.java_springboot.Service.regservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller// this is different from the rest controller
@RequestMapping("web")
public class WEB {
    @Autowired
    regservice regs;

    @GetMapping("home1")
    public String gethome1(Model model){
        model.addAttribute("Thisiskey","model is used to include the java object in html and in the form of key and " +
                "value");
    return "home1.html";
    }

    @GetMapping("list")
    public String getlist(Model model){
        List<String> obj=new ArrayList<>();
        obj.add("list1");
        obj.add("list2");
        obj.add("list3");
        obj.add("list4");
        obj.add("list5");
        obj.add("list6");
        model.addAttribute("Thisiskey","model is used to include the java object in html and in the form of key and " +
                "value");
        model.addAttribute("addinglist",obj);
        return "list.html";
    }
    @GetMapping("database")
    public String getdatabase(Model model){
        model.addAttribute("listfromdb",regs.Selectcustomers());
        return "Databse.html";
    }
}
