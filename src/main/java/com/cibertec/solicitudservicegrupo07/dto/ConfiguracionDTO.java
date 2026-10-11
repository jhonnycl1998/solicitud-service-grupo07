package com.cibertec.solicitudservicegrupo07.dto;

public class ConfiguracionDTO {

    private String tasaInteresBase;

    private String montoMaximoPrestamo;

    private String mensajeComercial;

    private String comisionDesembolso;

    private String datasourceUrl;

    public ConfiguracionDTO(String tasaInteresBase, String montoMaximoPrestamo, String mensajeComercial, String comisionDesembolso, String datasourceUrl) {
        this.tasaInteresBase = tasaInteresBase;
        this.montoMaximoPrestamo = montoMaximoPrestamo;
        this.mensajeComercial = mensajeComercial;
        this.comisionDesembolso = comisionDesembolso;
        this.datasourceUrl = datasourceUrl;
    }

    public String getTasaInteresBase() {
        return tasaInteresBase;
    }

    public String getMontoMaximoPrestamo() {
        return montoMaximoPrestamo;
    }

    public String getMensajeComercial() {
        return mensajeComercial;
    }

    public String getComisionDesembolso() {
        return comisionDesembolso;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }
}
