package br.com.ayranandrade.desafioindwisesolucao.model;

import br.com.ayranandrade.desafioindwisesolucao.infraestructure.ProductionJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDateTime;

/**
 *
 * @author Ayran
 */
@JsonDeserialize(using=ProductionJsonDeserializer.class)
public class Production 
{
    private LocalDateTime productionTime;
    private Long radioId;
    private String uniqueId;
    private Double speedInSeconds;
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LocalDateTime getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(LocalDateTime productionTime) {
        this.productionTime = productionTime;
    }

    public Long getRadioId() {
        return radioId;
    }

    public void setRadioId(Long radioId) {
        this.radioId = radioId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Double getSpeedInSeconds() {
        return speedInSeconds;
    }

    public void setSpeedInSeconds(Double speedInSeconds) {
        this.speedInSeconds = speedInSeconds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}