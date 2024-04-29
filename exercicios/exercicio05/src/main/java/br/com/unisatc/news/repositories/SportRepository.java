package br.com.unisatc.news.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.unisatc.news.models.SportEntity;

public interface SportRepository extends JpaRepository<SportEntity, Long> {

    @Query("SELECT p FROM SportEntity p ORDER BY p.sport_date DESC")
    List<SportEntity> findByDataDesc();
    
}
