package org.saurabhsood.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.saurabhsood.models.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.saurabhsood.models.User;

@Controller
public class HomeController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());
        return "user";
    }

    @RequestMapping(value = "/currency", method = RequestMethod.POST)
    public String currency(@Validated Currency currency, Model model) {
        System.out.println("Currency Page Requested");
        model.addAttribute("currencyCode", currency.getCurrencyCode());
        return "currency";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        System.out.println("Index Page Requested");
        return "index1";
    }
}