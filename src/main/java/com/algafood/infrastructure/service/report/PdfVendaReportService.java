package com.algafood.infrastructure.service.report;


import com.algafood.domain.filter.VendaDiariaFilter;
import com.algafood.domain.service.VendaReportService;
import org.springframework.stereotype.Service;

@Service
public class PdfVendaReportService implements VendaReportService {
    @Override
    public byte[] emitirVendasDiarias(VendaDiariaFilter filter, String timeOffset) {
        return new byte[0];
    }
}
