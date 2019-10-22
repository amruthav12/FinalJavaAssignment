package com.Srping2.UserCollection.UserInfo.Controller;

import com.Srping2.UserCollection.UserInfo.Entity.User;
import com.Srping2.UserCollection.UserInfo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("/FirstPage")
    public String user() {
        return "user";
    }

    @RequestMapping("/seeAllUser")
    public String getAllUser(Model model) {
        List<User> ls = service.getAllUsers();
        model.addAttribute("User", ls);
        return "UserList";
    }
    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String CreateOrUpdate(User usr){
        service.CreateOrUpdate(usr);
        return "redirect:/"; // to the same place we are working.
    }

    @RequestMapping(path = {"/edit","/edit/{id}"})
    public String getEmployeeByID(Model model, @PathVariable("id") Optional<Long> idop) throws Exception {
        if(idop.isPresent()){
            User usr =service.getUserByID(idop.get());
            model.addAttribute("user",usr);
        }else{
            model.addAttribute("user",new User());

        }
        return "addingNewUser";
    }
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) throws Exception{
        service.deleteEmployeeById(id);
        return "redirect:/";
    }
}
