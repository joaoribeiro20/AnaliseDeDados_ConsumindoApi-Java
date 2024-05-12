package br.com.projeto.alura.estudos.springBootData.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record typeDataOmdbApiSeason(

        @JsonAlias("Season")
        Integer season,
        @JsonAlias("Episodes")
        List<typeDataOmdbApiEpisode> episodes
) {
}
