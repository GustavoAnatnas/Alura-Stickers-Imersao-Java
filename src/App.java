import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
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
        System.out.println("\u001b[37;1m \u001b[44;1m" + movie.get("fullTitle") + "\u001b[0m");
        System.out.println("\u001b[1m Rank:\u001b[m " + movie.get("rank"));
        System.out.println("\u001b[1m Ano de Lançamento: \u001b[m" + movie.get("year"));
        System.out.println(movie.get("image"));
        System.out.println("\u001b[1m Elenco: \u001b[m" + movie.get("crew"));
        System.out.println("\u001b[1m Contagem de Avaliações: \u001b[m" + movie.get("imDbRatingCount"));
        int floatToIntDbRating = (int) Float.parseFloat(movie.get("imDbRating"));
        System.out.println("\u001b[1m Avaliação: \u001b[m" + floatToIntDbRating);
        int nEstrelas = 0;
        if (floatToIntDbRating <= 2) {
            nEstrelas = 1;
        } else if (floatToIntDbRating <= 4) {
            nEstrelas = 2;
        } else if (floatToIntDbRating <= 6) {
            nEstrelas = 3;
        } else if (floatToIntDbRating <= 8) {
            nEstrelas = 4;
        } else {
            nEstrelas = 5;
        }
        for (int i = 0; i < nEstrelas; i++) {
            System.out.print("\u2B50");
        }
        System.out.println("\n");

        String urlImage = movie.get("image");
        String title = movie.get("title");
        String archiveName = title.replace(":", "-") + ".png";

        InputStream inputStream = new URL(urlImage).openStream();
        var generateSticker = new BuildStickers();
        generateSticker.build(inputStream, archiveName);
       }
    }
}