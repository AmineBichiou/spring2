package com.amine.film.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilm=0L;
    @NotNull
    @Size(min = 4,max = 15)
    private String nomFilm;
    @DecimalMax("10.0") @DecimalMin("1.1")
    private Double rateFilm= 0.0 ;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreation;
    @ManyToOne
    private Genre genre;


    public Film() {
        super();
    }

    public Film(String nomFilm, Double rateFilm, Date dateCreation) {
        super();
        this.nomFilm = nomFilm;
        this.rateFilm = rateFilm;
        this.dateCreation = dateCreation;
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
}