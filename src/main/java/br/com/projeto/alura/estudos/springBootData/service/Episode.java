package br.com.projeto.alura.estudos.springBootData.service;

import br.com.projeto.alura.estudos.springBootData.model.typeDataOmdbApiEpisode;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;

    private String title;

    private Integer episode;

    private Double imdbRating;

    private LocalDate released;


    public Episode(Integer season, typeDataOmdbApiEpisode dados) {
        this.season = season;
        this.title = dados.Title();
        this.episode = dados.episode();

        try {
            this.imdbRating = Double.valueOf(dados.imdbRating());
        } catch (NumberFormatException ex) {
            this.imdbRating = 0.0;
        }
        try {
            this.released = LocalDate.parse(dados.Released());
        } catch (DateTimeParseException ex) {
            this.released = null;
        }

    }
    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", title='" + title + '\'' +
                ", episode=" + episode +
                ", imdbRating=" + imdbRating +
                ", released=" + released +
                '}';
    }
}
