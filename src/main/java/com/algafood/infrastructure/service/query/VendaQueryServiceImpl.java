package com.algafood.infrastructure.service.query;

import com.algafood.domain.filter.VendaDiariaFilter;
import com.algafood.domain.model.Pedido;
import com.algafood.domain.model.StatusPedido;
import com.algafood.domain.model.dto.VendaDiaria;
import com.algafood.domain.service.VendaQueryService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class VendaQueryServiceImpl implements VendaQueryService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffset) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<VendaDiaria> query = criteriaBuilder.createQuery(VendaDiaria.class);
        Root<Pedido> root = query.from(Pedido.class);
        ArrayList<Predicate> predicates = new ArrayList<>();

        Expression<Date> functionConvertTzDataCriacao = criteriaBuilder.function(
                "convert_tz", Date.class, root.get("dataCriacao"),
                criteriaBuilder.literal("+00:00"),
                criteriaBuilder.literal(timeOffset));

        Expression<Date> functionDataCriacao = criteriaBuilder.function(
                "date", Date.class, functionConvertTzDataCriacao);

        CompoundSelection<VendaDiaria> selection = criteriaBuilder.construct(VendaDiaria.class,
                functionDataCriacao,
                criteriaBuilder.count(root.get("id")),
                criteriaBuilder.sum(root.get("valorTotal")));

        if (filtro.getRestauranteId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("restaurante"), filtro.getRestauranteId()));
        }

        if (filtro.getDataCriacaoInicio() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataCriacao"),
                    filtro.getDataCriacaoInicio()));
        }

        if (filtro.getDataCriacaoFim() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dataCriacao"),
                    filtro.getDataCriacaoFim()));
        }

        predicates.add(root.get("status").in(
                StatusPedido.CONFIRMADO, StatusPedido.ENTREGUE));

        query.select(selection);
        query.where(predicates.toArray(new Predicate[0]));
        query.groupBy(functionDataCriacao);

        return manager.createQuery(query).getResultList();

    }
}

