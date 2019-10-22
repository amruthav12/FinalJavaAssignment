package com.ThymeLeaf.Practice.SpringMVC.Controller;

import com.ThymeLeaf.Practice.SpringMVC.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MVCController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User usr) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("User-Data");
        mv.addObject("Usrr", usr);
        return mv;
    }
//spring interpolation
    @GetMapping ("/add/{id}")
    public String add(@PathVariable int id, Model model) {
        User user = new User();
        user.setEmail("xyz.abc@tmail.com");
        user.setName("ABC");
        user.setId(id);
        model.addAttribute("usr", user);
        return "myDetails";
    }
}
//        @RequestMapping("/add")
//            public String add(Model model){
//        User user  = new User();
//        user.setEmail("xyz.abc@tmail.com");
//        user.setName("ABC");
//        model.addAttribute("usr",user);
//        return "myDetails";
//    }
//        }
