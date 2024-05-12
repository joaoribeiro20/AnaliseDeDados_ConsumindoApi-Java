package br.com.projeto.alura.estudos.springBootData.main;

import br.com.projeto.alura.estudos.springBootData.model.typeDataOmdbApiEpisode;
import br.com.projeto.alura.estudos.springBootData.model.typeDataOmdbApiSeason;
import br.com.projeto.alura.estudos.springBootData.service.ConsumoApi;
import br.com.projeto.alura.estudos.springBootData.service.ConverteDados;
import br.com.projeto.alura.estudos.springBootData.model.typeDataOmdbApiMain;
import br.com.projeto.alura.estudos.springBootData.service.Episode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//http://www.omdbapi.com/?t=Game%20of%20Thrones&Season=1&apikey=6253d200
//http://www.omdbapi.com/?t=you&apikey=6253d200
public class Index {
    private Scanner ler = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6253d200";
    ConverteDados conversor = new ConverteDados();

    public void context() {
        System.out.printf("Digite o nome da serie: ");
        var nome = ler.nextLine();
        var json = consumo.obterDados(ENDERECO + nome.replace(" ", "+") + API_KEY);
        typeDataOmdbApiMain dados = conversor.obterDados(json, typeDataOmdbApiMain.class);
        //System.out.print(dados);
        //System.out.printf(ENDERECO + nome.replace("", "+") + API_KEY);
        //System.out.printf(json);

        List<typeDataOmdbApiSeason> seasons = new ArrayList<>();

        for (int i = 0; i <= dados.totalSeasons(); i++) {
            json = consumo.obterDados(ENDERECO + nome.replace(" ", "+") + "&Season=" + i + API_KEY);
            typeDataOmdbApiSeason dadosTemporada = conversor.obterDados(json, typeDataOmdbApiSeason.class);
            seasons.add(dadosTemporada);
        }
       //seasons.forEach(System.out::println);

//        for (int i = 0; i < dados.totalSeasons(); i++) {
//            //quando tentmos atribuir um valor null a um campo de uma lista é gerado uma execessao
//            //portanto antes de adicionar os epesodios em episodiosTemporada que é do tipo list typeDataOmdbApiEpisode é necessario verificar se nao tem nenhum dado do returno da api como null
//            if(seasons.get(i).episodes() == null){
//                seasons.remove(i);
//            }
//            List<typeDataOmdbApiEpisode> episodiosTemporada = seasons.get(i).episodes();
//            for (int j = 0; j < episodiosTemporada.size(); j++) {
//                System.out.println(episodiosTemporada.get(j).Title());
//            }
//        }
        //no exemplo a cima faz a mesma coisa no codigo a baixo porem esse a baixo usa função lamda
//        seasons.forEach(t -> {
//            if (t.episodes() != null) {
//                t.episodes().forEach(e -> System.out.println(e.Title()));
//            }
//        });

//        List<typeDataOmdbApiEpisode> dadosep = seasons.stream()
//                .filter(e -> e.episodes() != null)
//                .flatMap(t -> t.episodes().stream())
//                .collect(Collectors.toList());

        //filtando e exibindo os top 5 episodios
//        dadosep.stream()
//                .filter(e -> !e.imdbRating().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(typeDataOmdbApiEpisode::imdbRating).reversed())
//                .limit(5)
//                .forEach(System.out::println);


        List<Episode> eps = seasons.stream()
                .filter(e -> e.episodes() != null)
                .flatMap(t -> t.episodes().stream()
                        .map(d -> new Episode(t.season(), d)))
                .collect(Collectors.toList());

        eps.stream()
                .forEach(System.out::println);


    }
}

