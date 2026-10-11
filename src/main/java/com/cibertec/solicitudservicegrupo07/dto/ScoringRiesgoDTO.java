package com.cibertec.solicitudservicegrupo07.dto;

public class ScoringRiesgoDTO {
    public Long clienteId;
    public Integer puntajeCrediticio;
    public String nivelRiesgo;
    public Double capacidadMaxEndeudamiento;
    public String dictamenRiesgo;

    public ScoringRiesgoDTO() {
    }

    public ScoringRiesgoDTO(Long clienteId, Integer puntajeCrediticio, String nivelRiesgo, Double capacidadMaxEndeudamiento, String dictamenRiesgo) {
        this.clienteId = clienteId;
        this.puntajeCrediticio = puntajeCrediticio;
        this.nivelRiesgo = nivelRiesgo;
        this.capacidadMaxEndeudamiento = capacidadMaxEndeudamiento;
        this.dictamenRiesgo = dictamenRiesgo;
    }
}