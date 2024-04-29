package br.com.unisatc.news.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.unisatc.news.controllers.NewsController;
import br.com.unisatc.news.dtos.NewsRecordDTO;
import br.com.unisatc.news.models.NewsEntity;
import br.com.unisatc.news.repositories.NewsRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public ResponseEntity<NewsEntity> saveNews(NewsRecordDTO newsRecordDTO) {
        NewsEntity newsEntity = new NewsEntity();
        BeanUtils.copyProperties(newsRecordDTO, newsEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newsRepository.save(newsEntity));
    }

    public ResponseEntity<List<NewsEntity>> getAllNews() {
        List<NewsEntity> news = newsRepository.findByDateDesc();
        if(!news.isEmpty()) {
            for(NewsEntity newsEntity : news) {
                Long news_id = newsEntity.getNews_id();
                newsEntity.add(linkTo(methodOn(NewsController.class).getOneNews(news_id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(news);
    }

    public ResponseEntity<Object> getOneNews(Long id) {
        Optional<NewsEntity> news = newsRepository.findById(id);
        if(news.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum noticia com este id");
        }
        news.get().add(linkTo(methodOn(NewsController.class).getAllNews()).withRel("Todas as noticias"));
        return ResponseEntity.status(HttpStatus.OK).body(news);
    }

    public ResponseEntity<Object> updateNews(Long id, NewsRecordDTO newsRecordDTO) {
        Optional<NewsEntity> news = newsRepository.findById(id);
        if(news.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum noticia com este id");
        }
        NewsEntity newsEntity = news.get();
        BeanUtils.copyProperties(newsRecordDTO, newsEntity);
        return ResponseEntity.status(HttpStatus.OK).body(newsRepository.save(newsEntity));
    }

    public ResponseEntity<Object> deleteNews(Long id) {
        Optional<NewsEntity> news = newsRepository.findById(id);
        if(news.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum noticia com este id");
        }
        newsRepository.delete(news.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
