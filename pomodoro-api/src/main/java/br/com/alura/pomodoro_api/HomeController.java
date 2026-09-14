package br.com.alura.pomodoro_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController // Reconhece como um componente que irá expor endpoints para outras aplicações
public class HomeController {
    @GetMapping("/")     // Serve para mapear requisições GET do controller
    // Ao fazer uma requisição GET, o Spring Boot procura quem possui esta anotação
    // No parâmetro é passado o 'path' ao qual o Tomcat foi inicializado
        public Map<String, String> home() {

            return Map.of("message", "Primeira versão API Pomodoro");

        }

}
