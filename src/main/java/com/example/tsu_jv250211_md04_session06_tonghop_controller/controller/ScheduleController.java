package com.example.tsu_jv250211_md04_session06_tonghop_controller.controller;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.*;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.service.MovieService;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.service.ScheduleService;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.service.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public String ListSchedule(Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập trước");
            return "redirect:/login";
        }
        List<Schedule> schedules = scheduleService.getSchedules();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("schedules", schedules);
        model.addAttribute("formatter", dtf);
        return "listSchedule";
    }

    @GetMapping("/add")
    public String AddSchedule(Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập trước.");
            return "redirect:/login";
        }
        List<ScreenRoom> screenRooms = screenRoomService.findAll();
        List<Movie> movieList = movieService.getMovies();
        model.addAttribute("movieList", movieList);
        model.addAttribute("schedules", new Schedule());
        model.addAttribute("screenRooms", screenRooms);
        return "addScheduleForm";
    }

    @PostMapping("/add")
    public String AddSchedule(@ModelAttribute Schedule schedule, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập trước.");
            return "redirect:/login";
        }
        scheduleService.addSchedule(schedule);
        return "redirect:/schedules";
    }
    @GetMapping("/edit/{id}")
    public String EditSchedule(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message","Bạn vui lòng đăng nhập trước");
            return "redirect:/login";
        }
        Schedule schedule = scheduleService.getScheduleById(id);
        model.addAttribute("schedule", schedule);
        return "editScheduleForm";
    }
    @PostMapping("/edit/{id}")
    public String EditSchedule( @PathVariable Long id,@ModelAttribute Schedule schedule, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập trước.");
            return "redirect:/login";
        }
        scheduleService.getScheduleById(id);
        scheduleService.updateSchedule(schedule);
        return "redirect:/schedules";
    }
    @GetMapping("/delete/{id}")
    public String DeleteSchedule(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message","Vui lòng đăng nhập trước.");
            return "redirect:/login";
        }
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules";
    }
    @PostMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message","Vui lòng đăng nhập trước");
            return "redirect:/login";
        }
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules";
    }
}
