package com.algafood;

import static org.hamcrest.Matchers.equalTo;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import com.algafood.util.DatabaseCleaner;
import com.algafood.util.ResourceUtils;
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


import io.restassured.RestAssured;
import io.restassured.http.ContentType;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"/application-test.properties"})
public class CadastroCozinhaIT {

//    testes de integração

//    @Autowired
//    private CadastroCozinhaService cadastroCozinhaService;
//
//    @Test
//    public void deveAtribuirIdQuandoCadastrarCozinhaComDadosCorretos() { //caminho Feliz
//        //cenário
//        Cozinha cozinha = new Cozinha();
//        cozinha.setNome("Chinesa");
//
//        //ação
//        cozinha = cadastroCozinhaService.salvar(cozinha);
//
//        //validação
//        assertThat(cozinha).isNotNull();
//        assertThat(cozinha.getId()).isNotNull();
//    }
//
//    @Test(expected = ConstraintViolationException.class)
//    public void deveFalharQuandoCadastrarCozinhaSemNome() {
//        Cozinha cozinha = new Cozinha();
//        cozinha.setNome(null);
//
//        cadastroCozinhaService.salvar(cozinha);
//    }
//
//    @Test(expected = EntidadeEmUsoException.class)
//    public void deveFalharQuandoExcluirCozinhaEmUso() {
//        cadastroCozinhaService.excluir(1L);
//    }
//
//    @Test(expected = EntidadeNaoEncontradaException.class)
//    public void deveFalharQuandoExcluirCozinhaInexistente() {
//        cadastroCozinhaService.excluir(100L);
//    }

//    testes de API

    private static final int COZINHA_ID_INEXISTENTE = 100;

    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    private Cozinha cozinhaAmericana;
    private int quantidadeCozinhasCadastradas;
    private String jsonCorretoCozinhaChinesa;

//    @Autowired
//    private Flyway flyway;

    @Before
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";

        jsonCorretoCozinhaChinesa = ResourceUtils.getContentFromResource(
                "/json/correto/cozinha-chinesa.json");

//        flyway.migrate();
        databaseCleaner.clearTables();
        prepararDados();
    }

    @Test
    public void deveRetornarStatusOkQuandoConsultarCozinhas() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get()
                .then()
                    .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveRetornarQuantidadeCorretaCozinhasQuandoConsultarCozinhas() {
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get()
                .then()
                    .body("", Matchers.hasSize(quantidadeCozinhasCadastradas))
//                    .body("nome", Matchers.hasItems("Tailandesa", "Americana"))
        ;
    }

    @Test
    public void deveRetornarStatusCreatedQuandoCadastrarCozinha(){
        RestAssured
                .given()
                    .body(jsonCorretoCozinhaChinesa)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .post()
                .then()
                    .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void deveRetornarRespostaEStatusCorretosQuandoConsultarCozinhaExistente(){
        RestAssured
                .given()
                    .pathParam("id", cozinhaAmericana.getId())
                    .accept(ContentType.JSON)
                .when()
                    .get("/{id}")
                .then()
                    .statusCode(HttpStatus.OK.value())
                    .body("nome", equalTo(cozinhaAmericana.getNome()));
    }

    @Test
    public void deveRetornarStatusNotFoundQuandoConsultarCozinhaExistente(){
        RestAssured
                .given()
                    .pathParam("id", COZINHA_ID_INEXISTENTE)
                    .accept(ContentType.JSON)
                .when()
                    .get("/{id}")
                .then()
                    .statusCode(HttpStatus.NOT_FOUND.value());
    }

    private void prepararDados(){
        Cozinha cozinhaTailandesa = new Cozinha();
        cozinhaTailandesa.setNome("Tailandesa");
        cozinhaRepository.save(cozinhaTailandesa);

        cozinhaAmericana  = new Cozinha();
        cozinhaAmericana .setNome("Americana");
        cozinhaRepository.save(cozinhaAmericana );

        quantidadeCozinhasCadastradas = (int) cozinhaRepository.count();
    }


}
