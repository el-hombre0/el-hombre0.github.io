package com.example.highstyle.controller;

import com.example.highstyle.model.News;
import com.example.highstyle.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    NewsRepository newsRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<News> news = newsRepository.findAll();
        model.addAttribute("news", news);
        return "index";
    }

    @GetMapping("news")
    public String news(@RequestParam("id") Integer id, Model model){
        Optional<News> news_ind = newsRepository.findById(id);
        news_ind.ifPresent(o -> model.addAttribute("news_ind", o));
        return "news";
    }

    @GetMapping("/historical")
    public String historical(Model model){
        return "historical";
    }

    @GetMapping("/classification")
    public String classification(Model model){
        return "classification";
    }
}
