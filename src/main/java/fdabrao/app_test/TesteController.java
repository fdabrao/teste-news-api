package fdabrao.app_test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

    @Autowired
    private TestApiClient testApiClient;

    @GetMapping("/")
    public String getNews(Model model) {
        List<Map<String, Object>> articles = testApiClient.buscarUltimosArtigos("us");
        model.addAttribute("artigos", articles);
        return "noticias";
    }
    
}
