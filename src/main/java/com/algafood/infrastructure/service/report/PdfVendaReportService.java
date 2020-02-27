package com.algafood.infrastructure.service.report;


import com.algafood.domain.filter.VendaDiariaFilter;
import com.algafood.domain.model.dto.VendaDiaria;
import com.algafood.domain.service.VendaQueryService;
import com.algafood.domain.service.VendaReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class PdfVendaReportService implements VendaReportService {

    @Autowired
    private VendaQueryService vendaQueryService;

    @Override
    public byte[] emitirVendasDiarias(VendaDiariaFilter filter, String timeOffset) {

        try {

            InputStream inputStream = this.getClass().getResourceAsStream(
                    "/relatorios/vendas-diarias.jasper");

            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));

            List<VendaDiaria> vendaDiarias = vendaQueryService.consultarVendasDiarias(filter, timeOffset);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(vendaDiarias);

            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);


            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            throw new ReportException("Não foi possível emitir relatório de vendas diárias", e);
        }
    }
}
