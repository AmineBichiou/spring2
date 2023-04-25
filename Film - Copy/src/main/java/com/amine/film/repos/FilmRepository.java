package com.amine.film.repos;

import com.amine.film.entities.Film;
import com.amine.film.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path = "rest")
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByNomFilm(String nom);
    List<Film> findByNomFilmContains(String nom);
    @Query("select f from Film f where f.genre = ?1")
    List<Film> findByGenre(Genre genre);
    List<Film> findByGenreIdGenre(Long id);
    List<Film> findByOrderByNomFilmAsc();
    @Query("select f from Film f order by f.nomFilm ASC, f.rateFilm DESC")
    List<Film> trierFilmNomsRate();


}
