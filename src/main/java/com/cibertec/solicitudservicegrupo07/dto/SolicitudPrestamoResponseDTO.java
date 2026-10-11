package com.cibertec.solicitudservicegrupo07.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SolicitudPrestamoResponseDTO {
    public Long idSolicitud;
    public String codigoSolicitud;
    public LocalDateTime fechaSolicitud;
    public Long clienteId;
    public Double montoSolicitado;
    public Integer plazoMeses;
    public String estadoSolicitud;
    public List<CuotaPrestamoDTO> listaCuotasProyectadas;
    public Double tasaInteresAnual;
    public Double montoTotalPagar;
}
