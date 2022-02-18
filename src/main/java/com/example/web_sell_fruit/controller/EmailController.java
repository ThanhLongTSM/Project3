package com.example.web_sell_fruit.controller;


import com.example.web_sell_fruit.models.AccountDTO;
import com.example.web_sell_fruit.other.SimpleMailSender;
import com.example.web_sell_fruit.dao.impl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping(value = "/admin/Email")
public class EmailController {

    @Autowired
    private SimpleMailSender simpleMailSender;

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/home")
    public String home(HttpServletRequest request) {
        List<AccountDTO> accountDTOs = accountService.getList();
        request.setAttribute("accounts", accountDTOs);
        return "admin/email/home";
    }

    @PostMapping(value = "/send")
    public String send(@RequestParam(name = "emails", required = true) String[] emails,
                       @RequestParam(name = "subject") String subject,
                       @RequestParam(name = "text") String text
    ) {
        for (String email : emails) {
            simpleMailSender.send(email, subject, text);
        }

        return "redirect:/admin/Email/home";
    }

}
