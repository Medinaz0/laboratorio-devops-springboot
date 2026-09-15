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
}
