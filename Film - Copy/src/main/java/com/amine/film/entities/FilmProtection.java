package com.amine.film.entities;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomFilm", types = { Film.class })

public interface FilmProtection {
    public String getNomFilm();
}
