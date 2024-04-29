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
@Table(name = "TB_NEWS")
public class NewsEntity extends RepresentationModel<NewsEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long news_id;
    private String news_title;
    private String news_country;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate news_date;
}
