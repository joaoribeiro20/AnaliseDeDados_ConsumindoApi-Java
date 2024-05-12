package br.com.projeto.alura.estudos.springBootData.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record typeDataOmdbApiMain(
        @JsonAlias("Title")
        String Title,
        //@JsonAlias("Episode") Integer Episode,
        @JsonAlias("Released")
        String Released,
        @JsonAlias("imdbRating")
        String imdbRating,
        @JsonAlias("totalSeasons")
        Integer totalSeasons

) {
}
