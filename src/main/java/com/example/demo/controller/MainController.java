package com.example.demo.controller;

import com.example.demo.mail.EmailServiceImpl;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.model.UserType;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
private ReservationRepository reservationRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private EmailServiceImpl emailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(ModelMap map) {
        map.addAttribute("allMenu", menuRepository.findAll());
        map.addAttribute("allRestaurants", restaurantRepository.findAll());

        return "index";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        StringBuilder sb = new StringBuilder();
        if (result.hasErrors()) {
            for (ObjectError objectError : result.getAllErrors()) {
                sb.append(objectError.getDefaultMessage() + "<br>");
            }


        }
        return "redirect:/login?message=" + sb.toString();
    }


    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSuccess() {
        CurrentUser principal = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.getUser().getUserType() == UserType.ADMIN) {
            return "redirect:/admin";
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

@PostMapping("/reservation3eq2a23")
    public ResponseEntity reservationSave(@RequestBody Reservation reservation){
    reservationRepository.save(reservation);
    emailService.sendSimplMessage(reservation.getEmail(),"Welcome","Hy,you booked table");
    return ResponseEntity.ok("created");

}


}