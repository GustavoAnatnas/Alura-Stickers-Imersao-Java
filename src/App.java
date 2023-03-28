import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> responde = client.send(request, BodyHandlers.ofString()) ;
        String body = responde.body();
        // System.out.println(body);

        JsonParser parserJson = new JsonParser();
        List<Map<String, String>> moviesList = parserJson.parse(body);
        // System.out.println(moviesList);

        for(Map<String, String> movie : moviesList){
        System.out.println(movie.get("fullTitle"));
        System.out.println("Rank" + ":" + movie.get("rank"));
        System.out.println("Ano de Lançamento" + ":" + movie.get("year"));
        System.out.println(movie.get("image"));
        System.out.println("Elenco" + ":" + movie.get("crew"));
        System.out.println("Avaliação Geral" + ":" + movie.get("imDbRating"));
        System.out.println("Contagem de Avaliações" + ":" + movie.get("imDbRatingCount"));
        so
       }
    }
}
