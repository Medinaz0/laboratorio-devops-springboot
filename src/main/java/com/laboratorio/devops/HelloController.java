package com.laboratorio.devops;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String environment;

    public HelloController(@Value("${APP_ENVIRONMENT:LOCAL}") String environment) {
        this.environment = environment;
    }

    @GetMapping("/api/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hola desde DevOps", environment);
    }

    @GetMapping("/api/status")
    public HelloResponse status() {
        return new HelloResponse("Aplicacion funcionando correctamente", environment);
    }


    @GetMapping("/api/status2")
    public HelloResponse status2() {
        return new HelloResponse("Aplicacion funcionando", environment);
    }
}
