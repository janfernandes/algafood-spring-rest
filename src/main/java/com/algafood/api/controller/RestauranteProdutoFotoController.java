package com.algafood.api.controller;

import com.algafood.api.model.input.FotoProdutoInput;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/restaurantes/{id}/produtos/{produtoId}/foto")
public class RestauranteProdutoFotoController {

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void atualizarFoto(@PathVariable Long id,
                              @PathVariable Long produtoId,
                              @Valid FotoProdutoInput fotoProdutoInput){

        String filename = UUID.randomUUID().toString()
                + "_" + fotoProdutoInput.getArquivo().getOriginalFilename();

        String arquivoFoto = "/Users/ferna/" + filename;

        System.out.println(fotoProdutoInput.getDescricao());
        System.out.println(arquivoFoto);
        System.out.println(fotoProdutoInput.getArquivo().getContentType());

        try {
            fotoProdutoInput.getArquivo().transferTo(Paths.get(arquivoFoto));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
