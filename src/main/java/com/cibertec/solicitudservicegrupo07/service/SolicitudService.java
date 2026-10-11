package com.cibertec.solicitudservicegrupo07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.solicitudservicegrupo07.client.EvaluacionClient;
import com.cibertec.solicitudservicegrupo07.dto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitudService {

    @Autowired
    public EvaluacionClient evaluacionClient;

    public SolicitudPrestamoResponseDTO obtenerSolicitud(Long idSolicitud) {
        SolicitudPrestamoResponseDTO s = new SolicitudPrestamoResponseDTO();
        s.idSolicitud = idSolicitud;
        s.codigoSolicitud = "SOL-" + idSolicitud;
        s.fechaSolicitud = LocalDateTime.now();
        s.clienteId = 1L;
        s.montoSolicitado = 10000.0;
        s.plazoMeses = 12;
        s.estadoSolicitud = "EN_EVALUACION";
        s.tasaInteresAnual = 0.15;

        double interesTotal = s.montoSolicitado * s.tasaInteresAnual;
        s.montoTotalPagar = s.montoSolicitado + interesTotal;
        double cuota = s.montoTotalPagar / s.plazoMeses;
        double capital = s.montoSolicitado / s.plazoMeses;
        double interesCuota = interesTotal / s.plazoMeses;

        s.listaCuotasProyectadas = new ArrayList<>();
        for (int i = 1; i <= s.plazoMeses; i++) {
            CuotaPrestamoDTO c = new CuotaPrestamoDTO();
            c.numeroCuota = i;
            c.fechaVencimiento = LocalDate.now().plusMonths(i);
            c.montoCuota = Math.round(cuota * 100.0) / 100.0;
            c.capital = Math.round(capital * 100.0) / 100.0;
            c.interes = Math.round(interesCuota * 100.0) / 100.0;
            c.estadoCuota = "PENDIENTE";
            s.listaCuotasProyectadas.add(c);
        }
        return s;
    }

    public SolicitudPrestamoResponseDTO evaluarYAprobar(Long idSolicitud) {
        SolicitudPrestamoResponseDTO sol = obtenerSolicitud(idSolicitud);
        ScoringRiesgoDTO scoring = evaluacionClient.getScoring(sol.clienteId);

        boolean capacidadValida = sol.montoSolicitado <= scoring.capacidadMaxEndeudamiento;
        boolean riesgoValido = "BAJO".equalsIgnoreCase(scoring.nivelRiesgo) || "MEDIO".equalsIgnoreCase(scoring.nivelRiesgo);

        if (capacidadValida && riesgoValido) {
            sol.estadoSolicitud = "APROBADO";
        } else {
            sol.estadoSolicitud = "RECHAZADO_POR_RIESGO";
        }
        return sol;
    }

    public ResumenCrediticioClienteDTO obtenerResumen(Long clienteId) {
        ScoringRiesgoDTO scoring = evaluacionClient.getScoring(clienteId);
        SolicitudPrestamoResponseDTO sol = obtenerSolicitud(100L);
        sol.clienteId = clienteId;

        ResumenCrediticioClienteDTO res = new ResumenCrediticioClienteDTO();
        res.clienteId = clienteId;
        res.nombreCliente = "Juan Perez";
        res.dni = "45879632";
        res.scoringActual = scoring;
        res.historialSolicitudes = List.of(sol);

        if ("BAJO".equalsIgnoreCase(scoring.nivelRiesgo) || "MEDIO".equalsIgnoreCase(scoring.nivelRiesgo)) {
            res.estadoCrediticioGlobal = "APTO";
        } else {
            res.estadoCrediticioGlobal = "NO_APTO";
        }
        return res;
    }
}