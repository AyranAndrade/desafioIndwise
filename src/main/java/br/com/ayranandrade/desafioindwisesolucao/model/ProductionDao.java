package br.com.ayranandrade.desafioindwisesolucao.model;

import br.com.ayranandrade.desafioindwisesolucao.model.Production;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ayran
 */
@Repository
public interface ProductionDao 
{
    public Collection<Production> findProductionBetween
        (LocalDateTime initialDate, LocalDateTime finalDate);
        
    public Collection<Production> findProductionBetween
        (LocalDate initialDate, LocalDate finalDate);
        
        public Collection<Production> findAll();
}