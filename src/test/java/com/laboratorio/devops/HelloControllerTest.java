package com.laboratorio.devops;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HelloControllerTest {

    @Test
    void helloReturnsMessageAndEnvironment() {
        HelloController controller = new HelloController("TEST");

        HelloResponse response = controller.hello();

        assertThat(response.message()).isEqualTo("Hola desde DevOps");
        assertThat(response.environment()).isEqualTo("TEST");
    }

    @Test
    void statusReturnsMessageAndEnvironment() {
        HelloController controller = new HelloController("TEST");

        HelloResponse response = controller.status();

        assertThat(response.message()).isEqualTo("Aplicacion funcionando correctamente");
        assertThat(response.environment()).isEqualTo("TEST");
    }

    @Test
    void status2ReturnsMessageAndEnvironment() {
        HelloController controller = new HelloController("TEST");

        HelloResponse response = controller.statustwo();

        assertThat(response.message()).isEqualTo("Aplicacion funcionando");
        assertThat(response.environment()).isEqualTo("TEST");
    }
}
