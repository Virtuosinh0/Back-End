package br.com.unisatc.news.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unisatc.news.dtos.NewsRecordDTO;
import br.com.unisatc.news.models.NewsEntity;
import br.com.unisatc.news.services.NewsService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping
    public ResponseEntity<NewsEntity> saveNews(@RequestBody @Valid NewsRecordDTO newsRecordDTO) {
        return newsService.saveNews(newsRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<NewsEntity>> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("{news_id}")
    public ResponseEntity<Object> getOneNews(@PathVariable(value = "news_id")Long news_id) {
        return newsService.getOneNews(news_id);
    }

    @PutMapping("{news_id}")
    public ResponseEntity<Object> updateNews(@PathVariable(value = "news_id")Long news_id, @RequestBody @Valid NewsRecordDTO newsRecordDTO) {
        return newsService.updateNews(news_id, newsRecordDTO);
    }
    
    @DeleteMapping("{news_id}")
    public ResponseEntity<Object> deleteNews(@PathVariable(value = "news_id")Long news_id) {
        return newsService.deleteNews(news_id);
    }
}
