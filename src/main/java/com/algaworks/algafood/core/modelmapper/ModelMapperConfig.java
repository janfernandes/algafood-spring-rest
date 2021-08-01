package com.algaworks.algafood.core.modelmapper;

import com.algaworks.algafood.api.model.EnderecoModel;
import com.algaworks.algafood.api.model.input.ItemPedidoInput;
import com.algaworks.algafood.api.model.input.PedidoInput;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.ItemPedido;
import com.algaworks.algafood.domain.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.createTypeMap(Restaurante.class, RestauranteModel.class)
//        .addMapping(Restaurante::getTaxaFrete, RestauranteModel::setPrecoFrete);

        modelMapper.createTypeMap(ItemPedidoInput.class, ItemPedido.class)
                .addMappings(mapper -> mapper.skip(ItemPedido::setId));

        modelMapper.createTypeMap(PedidoInput.class, Pedido.class)
                .addMappings(mapper -> mapper.skip(Pedido::setId));

        modelMapper.createTypeMap(Endereco.class, EnderecoModel.class)
                .<String>addMapping(src -> src.getCidade().getEstado().getNome(),
                        (dest, value) -> dest.getCidade().setEstado(value));

        return modelMapper;
    }
}
