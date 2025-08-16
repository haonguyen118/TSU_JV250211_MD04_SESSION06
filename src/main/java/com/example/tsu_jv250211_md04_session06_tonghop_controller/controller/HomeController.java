package com.example.tsu_jv250211_md04_session06_tonghop_controller.controller;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Movie;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Schedule;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.service.MovieService;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    MovieService movieService;
    @Autowired
    ScheduleService scheduleService;
    @RequestMapping("/home")
    public String home(Model model) {
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movieList", movies);
        return "home";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable Long id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Movie movie = movieService.getMovieById(id);
        List<Schedule> schedules = scheduleService.getSchedules();
        model.addAttribute("movie", movie);
        model.addAttribute("schedules", schedules);
        model.addAttribute("formatter", dtf);
        return "detailMovie";


    }

}
