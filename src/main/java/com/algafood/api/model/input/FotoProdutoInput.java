package com.algafood.api.model.input;

import com.algafood.core.validation.FileContentType;
import com.algafood.core.validation.FileSize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FotoProdutoInput {

    @NotNull
    @FileSize(max= "500KB")
    @FileContentType(allowed = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    private MultipartFile arquivo;
    @NotNull
    private String descricao;
}
