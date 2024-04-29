package br.com.unisatc.news.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.unisatc.news.models.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity,Long> {
    
    @Query("SELECT p FROM NewsEntity p ORDER BY p.news_date DESC")
    List<NewsEntity> findByDateDesc();
}
