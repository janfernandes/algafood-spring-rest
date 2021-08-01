package com.algaworks.algafood;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.util.DatabaseCleaner;
import com.algaworks.algafood.util.ResourceUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"/application-test.properties"})
public class CadastroRestauranteIT {

    private static final int RESTAURANTE_ID_INEXISTENTE = 100;

    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CozinhaRepository cozinhaRepository;

    private Restaurante restauranteDelivery;
    private int quantidadeRestaurantesCadastrados;
    private String jsonCorretoRestauranteIndiano;

    @Before
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/restaurantes";

        jsonCorretoRestauranteIndiano = ResourceUtils.getContentFromResource(
                "/json/correto/restaurante-indiano.json");

        databaseCleaner.clearTables();
        prepararDados();
    }

    @Test
    public void deveRetornarStatusOkQuandoConsultarRestaurantes() {
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarQuantidadeCorretaQuandoConsultarRestaurantes() {
        RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .body("", Matchers.hasSize(quantidadeRestaurantesCadastrados));
    }

    @Test
    public void deveRetornarStatusCreatedQuandoCadastrarRestaurante(){
        RestAssured
                .given()
                .body(jsonCorretoRestauranteIndiano)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void deveRetornarRespostaEStatusCorretosQuandoConsultarRestauranteExistente(){
        RestAssured
                .given()
                .pathParam("id", restauranteDelivery.getId())
                .accept(ContentType.JSON)
                .when()
                .get("/{id}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("nome", equalTo(restauranteDelivery.getNome()));
    }

    @Test
    public void deveRetornarStatusNotFoundQuandoConsultarCozinhaExistente(){
        RestAssured
                .given()
                .pathParam("id", RESTAURANTE_ID_INEXISTENTE)
                .accept(ContentType.JSON)
                .when()
                .get("/{id}")
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }


    private void prepararDados(){
        Cozinha cozinhaBrasileira = new Cozinha();
        cozinhaBrasileira.setNome("Brasileira");
        cozinhaRepository.save(cozinhaBrasileira);

        Restaurante restauranteGourmet = new Restaurante();
        restauranteGourmet.setNome("Comida caseira");
        restauranteGourmet.setTaxaFrete(new BigDecimal(15));
        restauranteGourmet.setCozinha(cozinhaBrasileira);
        restauranteRepository.save(restauranteGourmet);

        Cozinha cozinhaTailandesa = new Cozinha();
        cozinhaTailandesa.setNome("Tailandesa");
        cozinhaRepository.save(cozinhaTailandesa);

        restauranteDelivery  = new Restaurante();
        restauranteDelivery .setNome("Thay Delivery");
        restauranteDelivery.setTaxaFrete(new BigDecimal(8));
        restauranteDelivery.setCozinha(cozinhaTailandesa);
        restauranteRepository.save(restauranteDelivery);

        quantidadeRestaurantesCadastrados = (int) restauranteRepository.count();
    }
}
