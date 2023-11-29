package com.lab9.airchecker.controller;

import com.lab9.airclearchecker.entity.InformationAnswer;
import com.lab9.airclearchecker.entity.InformationRequest;
import com.lab9.airclearchecker.entity.AirClear;
import com.lab9.airclearchecker.entity.User;
import com.lab9.airclearchecker.service.AnswerService;
import com.lab9.airclearchecker.service.AirClearService;
import com.lab9.airclearchecker.service.RequestService;
import com.lab9.airclearchecker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
//маємо клас контроллеру, що обробляє всі запити
@Controller
public class MyController {
    private AirClearService AirClearService;
    private UserService userService;
    private RequestService requestService;
    private AnswerService answerService;

    @Autowired
    public MyController(AirClearService airClearService, UserService userService, RequestService requestService, AnswerService answerService) {
        this.airClearService = airClearService;
        this.userService = userService;
        this.requestService = requestService;
        this.answerService = answerService;
    }

    @RequestMapping("/")
    public String login() {
        return "login";
    }
    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String username, @RequestParam String password, @RequestParam String location) {
        if (username.equals("Artem") && password.equals("12345678") && location.equals("Odessa")) {
            userService.save(new User("Artem", "12345678", "Odessa"));
            return "main-page";
        }
        return "login";
    }

    //а ось тут маємо функцію для отримання інформації про стан чистоти повітря, що потім передається як атрибут моделі для відображення на наступній сторінці
  
    @PostMapping("/air-clear-info")
    public String airClearInfo(@RequestParam String username, @RequestParam String location, Model model) {

        AirClear airClear = new AirClear();
        String airClearInfo = airClear.getAirClearInfo(location);
        model.addAttribute("airClearInfo", airClearInfo);

        return "air-Clear-info";
    }

}
