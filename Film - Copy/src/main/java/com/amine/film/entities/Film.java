package com.amine.film.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;




@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm;
    @NotNull
    @Size(min = 4,max = 15)
    private String nomFilm;

    private Double rateFilm;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreation;
    @ManyToOne
    private Genre genre;


    public Film() {
        super();
    }

    public Film(String nomFilm, Double rateFilm, Date dateCreation,Genre genre) {
        super();
        this.nomFilm = nomFilm;
        this.rateFilm = rateFilm;
        this.dateCreation = dateCreation;
        this.genre=genre;
    }

    public long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public double getRateFilm() {
        return rateFilm;
    }

    public void setRateFilm(Double rateFilm) {
        this.rateFilm = rateFilm;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", rateFilm=" + rateFilm + ", DateCreation="
                + dateCreation + "]";
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}