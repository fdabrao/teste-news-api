package fdabrao.app_test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TestApiClient {

    @Value("${serviceapi.key}")
    private String serviceApiKey;

    private final String serviceUrl = "https://newsapi.org/v2/top-headlines";

    public List<Map<String, Object>> buscarUltimosArtigos(String pais) {
        RestTemplate restTemplate = new RestTemplate();
        
        String url = UriComponentsBuilder.fromHttpUrl(serviceUrl)
                .queryParam("country", pais)
                .queryParam("apiKey", serviceApiKey)
                .toUriString();

        return (List<Map<String, Object>>) restTemplate.getForObject(url, Map.class).get("articles");
    }

}
