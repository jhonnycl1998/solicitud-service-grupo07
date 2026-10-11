package com.cibertec.solicitudservicegrupo07.dto;

import java.util.List;

public class ResumenCrediticioClienteDTO {
    public Long clienteId;
    public String nombreCliente;
    public String dni;
    public ScoringRiesgoDTO scoringActual;
    public List<SolicitudPrestamoResponseDTO> historialSolicitudes;
    public String estadoCrediticioGlobal;
}