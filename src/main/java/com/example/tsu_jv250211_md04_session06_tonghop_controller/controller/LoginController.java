package com.example.tsu_jv250211_md04_session06_tonghop_controller.controller;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Customer;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Role;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.UserSession;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @PostMapping("/login")
    public String ProcessLogin(String email, String password, Model model, RedirectAttributes redirectAttributes) {
        Customer customer = userService.login(email, password);
        if (customer != null) {
            UserSession.customer = customer;
            redirectAttributes.addFlashAttribute("message", "Đăng nhập thành công");
            if (customer.getRole() == Role.USER) {
                return "redirect:/home";
            } else if (customer.getRole() == Role.ADMIN) {
                return "redirect:/admin";

            }
        }
        model.addAttribute("error", "Thông tin đăng nhập không hợp lệ");
        return "login";
    }

}
