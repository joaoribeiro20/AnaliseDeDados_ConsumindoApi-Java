package br.com.projeto.alura.estudos.springBootData.service;

public interface IconverteDados {

    <T> T obterDados(String json, Class<T> classe);
}
