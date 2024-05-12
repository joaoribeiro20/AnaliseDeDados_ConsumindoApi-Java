package br.com.projeto.alura.estudos.springBootData.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record typeDataOmdbApiEpisode(
        @JsonAlias("Title")
        String Title,
        @JsonAlias("Episode")
        Integer episode,
        @JsonAlias("imdbRating")
        String imdbRating,
        @JsonAlias("Released")
        String Released
) {
}
