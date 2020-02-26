package com.algafood.infrastructure.service;

import com.algafood.domain.filter.VendaDiariaFilter;
import com.algafood.domain.model.dto.VendaDiaria;
import com.algafood.domain.service.VendaQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaQueryServiceImpl implements VendaQueryService {


    @Override
    public List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro) {
        return null;
    }
}
