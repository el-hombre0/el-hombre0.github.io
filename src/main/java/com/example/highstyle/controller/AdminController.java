package com.example.highstyle.controller;

import com.example.highstyle.model.News;
import com.example.highstyle.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/newsList")
    public String newsList(Model model) {
        Iterable<News> news = newsRepository.findAll();
        model.addAttribute("news", news);
        return "newsList";
    }

    @GetMapping("newsList/add")
    public String newsListAdd(Model model) {
        News news = new News();
        model.addAttribute("news", news);
        return "newsForm";
    }

    @PostMapping("newsList/add")
    public String newsListAddSubmit(@ModelAttribute News news, Model model){
        newsRepository.save(news);
        model.addAttribute("news", newsRepository.findAll());
        return "newsList";
    }

    @GetMapping("/newsList/delete/{newsId}")
    public String newsListDelete(@PathVariable("productId") Integer id, Model model) {
        newsRepository.deleteById(id);
        model.addAttribute("news", newsRepository.findAll());
        return "newsList";
    }

    @GetMapping("/newsList/edit/{newsId}")
    public String newsListEdit(@PathVariable("newsId") Integer id, Model model) {
        News news = newsRepository.findById(id).orElse(null);
        model.addAttribute("news", news);
        return "newsForm";
    }
}
