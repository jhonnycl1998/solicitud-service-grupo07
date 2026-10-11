package com.cibertec.solicitudservicegrupo07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.solicitudservicegrupo07.dto.ResumenCrediticioClienteDTO;
import com.cibertec.solicitudservicegrupo07.dto.SolicitudPrestamoResponseDTO;
import com.cibertec.solicitudservicegrupo07.service.SolicitudService;

@RestController
@RequestMapping("/api/v1/solicitudes")
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
}