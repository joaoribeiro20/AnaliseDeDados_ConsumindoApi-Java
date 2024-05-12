package br.com.projeto.alura.estudos.springBootData;

import br.com.projeto.alura.estudos.springBootData.main.Index;
import br.com.projeto.alura.estudos.springBootData.model.typeApiViaCep;
import br.com.projeto.alura.estudos.springBootData.service.ConsumoApi;
import br.com.projeto.alura.estudos.springBootData.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;

@SpringBootApplication
public class SpringBootDataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*var consumoapi = new ConsumoApi();
	var json = consumoapi.obterDados("https://viacep.com.br/ws/01001000/json/");
	//System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		typeApiViaCep dados = conversor.obterDados(json, typeApiViaCep.class);
		System.out.println(dados);*/


		Index start = new Index();
		start.context();
	}
}
