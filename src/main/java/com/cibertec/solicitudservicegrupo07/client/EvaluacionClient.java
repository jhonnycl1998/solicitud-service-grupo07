package com.cibertec.solicitudservicegrupo07.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cibertec.solicitudservicegrupo07.dto.ScoringRiesgoDTO;

@FeignClient(name = "evaluacion-service-grupo07")
public interface EvaluacionClient {

    @GetMapping("/api/v1/evaluaciones/scoring/{clienteId}")
    ScoringRiesgoDTO getScoring(@PathVariable("clienteId") Long clienteId);
}