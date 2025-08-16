package com.example.tsu_jv250211_md04_session06_tonghop_controller.controller;

import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Customer;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Movie;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.Role;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.model.entities.UserSession;
import com.example.tsu_jv250211_md04_session06_tonghop_controller.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;


    @GetMapping
    public String listMovies(Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập để xem danh sách các phim.");
            return "redirect:/login";

        }
        model.addAttribute("movieList", movieService.getMovies());
        return "listMovies";
    }

    @GetMapping("/add")
    public String showAddMovieForm(Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập để xem danh sách các phim.");
        }

        model.addAttribute("movieList", new Movie());
        return "addMovieForm";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute("movie") Movie movie,Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập để xem danh sách các phim.");
            return "redirect:/login";
        }
        if (movie.getMovieTitle() == null || movie.getMovieTitle().isEmpty()) {
            model.addAttribute("message", "Tiêu đề không được để trống.");
            return "addMovieForm";
        }
        movieService.addMovie(movie);
        redirectAttributes.addFlashAttribute("message", "Thêm mới phim thành công.");
        return "redirect:/movies";
    }
    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập để xem danh sách các phim.");
            return "redirect:/login";
        }
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "updateMovieForm";
    }
    @PostMapping("/edit/{id}")
    public String updateMovie( @PathVariable Long id,@ModelAttribute Movie movie,Model model, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập để xem danh sách các phim.");
            return "redirect:/login";
        }
        if (movie.getMovieTitle() == null || movie.getMovieTitle().isEmpty()) {
            model.addAttribute("message", "Tên phim không được để trống");
            return "addMovieForm";
        }
        movie.setMovieId(id);
        movieService.updateMovie(movie);
        redirectAttributes.addFlashAttribute("message", "Cập nhật phim thành công");
        return "redirect:/movies";
    }
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Customer customer = UserSession.customer;
        if (customer == null || customer.getRole() != Role.ADMIN) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập");
            return "redirect:/login";
        }
        movieService.deleteMovie(id);
        redirectAttributes.addFlashAttribute("message", "Xóa phim thành công");
        return "redirect:/movies";
    }


}



