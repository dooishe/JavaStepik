import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class YandexWheather {

    private static final String API_KEY = "f081fe0a-fbc1-4d6a-b0af-e055e00502a4";

    public static void main(String[] args) throws IOException, InterruptedException {

        double lat = 55.7558; // Широта
        double lon = 37.6173; //Долгота


//        String url = String.format(
//                "https://api.weather.yandex.ru/v2/forecast?lat=%f&lon=%f", lat, lon);

        String url = String.format(
                "https://api.weather.yandex.ru/v2/forecast?lat=55.75&lon=37.61");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-Yandex-API-Key", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}
