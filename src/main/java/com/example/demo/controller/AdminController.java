package com.example.demo.controller;

import com.example.demo.model.Menu;
import com.example.demo.model.Restaurants;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.RestaurantRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by user on 9/04/2018.
 */
@Controller
public class AdminController {


    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuRepository menuRepository;

    @Value("${restaurant.menu.upload.path}")
    private String imageUploadPath;
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap map) {
        map.addAttribute("restaurants", new Restaurants());
        map.addAttribute("menu", new Menu());
        return "admin";
    }

    @RequestMapping(value = "/addRestaurant", method = RequestMethod.POST)
    public String addRestaurant(@ModelAttribute(name = "restaurant") Restaurants restaurants, @RequestParam(value = "image")MultipartFile file)throws IOException {
        File dir = new File(imageUploadPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String picName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File(imageUploadPath + picName);
        file.transferTo(picture);
        restaurants.setPicUrl(picName);
        restaurantRepository.save(restaurants);
        return "redirect:/admin";

    }



    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    public String addBrand(@ModelAttribute(name = "menu") Menu menu, @RequestParam(value = "image") MultipartFile file) throws IOException {
        File dir = new File(imageUploadPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String picName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File(imageUploadPath + picName);
        file.transferTo(picture);
        menu.setPicUrl(picName);
        menuRepository.save(menu);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/menu/image", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response, @RequestParam("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream(imageUploadPath + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

}

