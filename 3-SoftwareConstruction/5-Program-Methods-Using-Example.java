package com.lab9.airstatechecker.controller;

import com.lab9.airclearstatechecker.entity.InformationAnswer;
import com.lab9.airclearstatechecker.entity.InformationRequest;
import com.lab9.airclearstatechecker.entity.AirClear;
import com.lab9.airclearstatechecker.entity.User;
import com.lab9.airclearstatechecker.service.AnswerService;
import com.lab9.airclearstatechecker.service.AirClearService;
import com.lab9.airclearstatechecker.service.RequestService;
import com.lab9.airclearstatechecker.service.UserService;
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
    public String doLogin(@RequestParam String username, @RequestParam String gender, @RequestParam String dateOfBirth) {
        if (username.equals("Artem") && gender.equals("male") && dateOfBirth.equals("18.07.2003")) {
            userService.save(new User("Artem", "male", "18.07.2003"));
            return "main-page";
        }
        return "login";
    }

    //а ось тут маємо функцію для отримання інформації про стан повітря, що потім передається як атрибут моделі для відображення на наступній сторінці
  
    @PostMapping("/air-clear-info")
    public String airClearStateInfo(@RequestParam String username, @RequestParam String gender, Model model) {

        AirClear airClear = new AirClear();
        String airClearInfo = airClear.getAirClearStateInfo(gender);
        model.addAttribute("airClearInfo", airClearInfo);

        return "air-Clear-info";
    }

}
