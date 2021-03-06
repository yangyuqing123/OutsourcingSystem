package com.zhy.controller.back;

import com.zhy.service.mybatis.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * @author: zhangocean
 * @Date: Created in 13:03 2018/1/14
 * Describe: 视图跳转
 */
@Controller
public class BackControl {

    @Autowired
    UserRegisterService userRegisterService;

    @GetMapping("/index")
    public String index(Model model, @AuthenticationPrincipal Principal principal){

        String userName = userRegisterService.getUserNameByPhone(principal.getName());
        model.addAttribute("userName", userName);

        return "project";
    }

    @GetMapping({"/login_register","/"})
    public String redirectLoginAndRegister(){
        return "login_register";
    }

    @GetMapping("/user")
    public String user(){
        return "userInfo";
    }

    @GetMapping("/faceCheck")
    public String faceCheck(){
        return "faceCheck";
    }

    @GetMapping("/manager")
    public String manager(Model model, @AuthenticationPrincipal Principal principal, HttpServletRequest request, HttpServletResponse response){
        String token = (String) request.getSession().getAttribute("X-CSRF-TOKEN");
        System.out.println("跳到管理界面的X-CSRF-TOKEN：" + token);
        response.setHeader("X-CSRF-TOKEN",token);

        String userName = userRegisterService.getUserNameByPhone(principal.getName());
        model.addAttribute("userName", userName);

        return "manager";
    }

    @GetMapping("/release")
    public String release(){
        return "release";
    }

    @GetMapping("/staff")
    public String staff(Model model, @AuthenticationPrincipal Principal principal){
        String userName = userRegisterService.getUserNameByPhone(principal.getName());
        model.addAttribute("userName", userName);
        return "staff";
    }

    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal Principal principal){
        String userName = userRegisterService.getUserNameByPhone(principal.getName());
        model.addAttribute("userName", userName);
        return "admin";
    }
}
