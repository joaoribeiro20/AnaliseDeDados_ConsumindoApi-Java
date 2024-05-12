package br.com.projeto.alura.estudos.springBootData.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record typeApiViaCep(
        @JsonAlias("cep")
        String cep,
        @JsonProperty("logradouro")
        String logradouro,
        @JsonAlias("uf")
        String uf,
        @JsonAlias("bairro")
        String bairro
) {
}
