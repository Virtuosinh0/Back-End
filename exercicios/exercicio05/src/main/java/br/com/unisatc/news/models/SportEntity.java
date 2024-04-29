package br.com.unisatc.news.models;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_SPORTS")
public class SportEntity extends RepresentationModel<SportEntity> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sport_id;
    private String sport_title;
    private String sport_team;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate sport_date;
    
}
