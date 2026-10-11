package com.cibertec.solicitudservicegrupo07.controller;

import com.cibertec.solicitudservicegrupo07.dto.ConfiguracionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import com.cibertec.solicitudservicegrupo07.dto.ResumenCrediticioClienteDTO;
import com.cibertec.solicitudservicegrupo07.dto.SolicitudPrestamoResponseDTO;
import com.cibertec.solicitudservicegrupo07.service.SolicitudService;

@RestController
@RequestMapping("/api/v1/solicitudes")
@RefreshScope
public class SolicitudController {

    @Autowired
    public SolicitudService solicitudService;

    @GetMapping("/{idSolicitud}")
    public SolicitudPrestamoResponseDTO getSolicitud(@PathVariable Long idSolicitud) {
        return solicitudService.obtenerSolicitud(idSolicitud);
    }

    @GetMapping("/evaluar-y-aprobar/{idSolicitud}")
    public SolicitudPrestamoResponseDTO evaluar(@PathVariable Long idSolicitud) {
        return solicitudService.evaluarYAprobar(idSolicitud);
    }

    @GetMapping("/resumen-cliente/{clienteId}")
    public ResumenCrediticioClienteDTO getResumen(@PathVariable Long clienteId) {
        return solicitudService.obtenerResumen(clienteId);
    }

    @Value("${fintech.tasa-interes-base}")
    private String tasaInteresBase;
    @Value("${fintech.monto-maximo-prestamo}")
    private String montoMaximoPrestamo;
    @Value("${fintech.mensaje-comercial}")
    private String mensajeComercial;
    @Value("${fintech.comision-desembolso}")
    private String comisionDesembolso;
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @GetMapping("/configuracion")
    public ConfiguracionDTO configuracion(){
        return new ConfiguracionDTO(tasaInteresBase,montoMaximoPrestamo,
                mensajeComercial,comisionDesembolso,datasourceUrl);

    }
}