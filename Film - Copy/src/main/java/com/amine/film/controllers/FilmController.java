package com.amine.film.controllers;

import com.amine.film.entities.Film;
import com.amine.film.service.FilmService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FilmController {
    @Autowired
    FilmService filmService;
    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        modelMap.addAttribute("film",new Film());
        modelMap.addAttribute("mode", "new");

        return "formFilm";
    }
    @RequestMapping("/saveFilm")
    public String saveFilm(@Valid  Film film,BindingResult bindingResult)

    {
        if (bindingResult.hasErrors()) /*return "redirect:/ListeFilms"*/return "formFilm";
        filmService.saveFilm(film);

        return "redirect:/ListeFilms";
    }
    @RequestMapping("/ListeFilms")
    public String listeFilms(ModelMap modelMap,
                                @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "4") int size)
    {
        Page<Film> prods = filmService.getAllFilmsParPage(page, size);
        modelMap.addAttribute("films", prods);
        modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);

        /*List<Film> fil = filmService.getAllFilm();
        modelMap.addAttribute("films", fil);*/
        return "listeFilms";
    }
    @RequestMapping("/supprimerFilm")
    public String supprimerFilm(@RequestParam("id") Long id,
                                   ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                   @RequestParam (name="size", defaultValue = "4") int size)
    {
        filmService.deleteFilmById(id);
        Page<Film> prods = filmService.getAllFilmsParPage(page,
                size);
        modelMap.addAttribute("films", prods);
        modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeFilms";
    }
    /*@RequestMapping("/modifierFilm")
    public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Film p= filmService.getFilm(id);
        modelMap.addAttribute("produit", p);
        return "editerFilm";
    }
    @RequestMapping("/updateFilm")
    public String updateProduit(@ModelAttribute("film") Film film,
                                @RequestParam("date") String date,
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        film.setDateCreation(dateCreation);

        filmService.updateFilm(film);
        List<Film> prods = filmService.getAllFilmsParPage();
        modelMap.addAttribute("films", prods);
        return "listeProduits";
    }*/
    @RequestMapping("/modifierFilm")
    public String editerFilm(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Film p= filmService.getFilm(id);
        modelMap.addAttribute("film", p);
        modelMap.addAttribute("mode", "edit");
        return "formFilm";
    }
    @RequestMapping("/updateFilm")
    public String updateFilm(@ModelAttribute("film") Film film,ModelMap modelMap)
    {
        filmService.updateFilm(film);
        List<Film> F = filmService.getAllFilm();
        modelMap.addAttribute("film", F);

        return "listeFilms";
    }



}
