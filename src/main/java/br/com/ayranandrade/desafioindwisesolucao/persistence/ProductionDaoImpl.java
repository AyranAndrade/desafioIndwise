package br.com.ayranandrade.desafioindwisesolucao.persistence;

import br.com.ayranandrade.desafioindwisesolucao.model.Production;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ayran
 */
public class ProductionDaoImpl implements ProductionDao
{
private final List<Production> production;

    public ProductionDaoImpl(String path) throws IOException 
    {
    ObjectMapper mapper = new ObjectMapper();
    production=mapper.readValue(new File(path),mapper.getTypeFactory()
            .constructCollectionType(List.class,Production.class));    
    }

    @Override
    public Collection<Production> findProductionBetween(LocalDateTime initialDate,
            LocalDateTime finalDate) 
    {
    return production.stream().filter(l->l.getProductionTime().isAfter(initialDate)
              && l.getProductionTime().isBefore(finalDate))
              .collect(Collectors.toList());
    }

    @Override
    public Collection<Production> findProductionBetween(LocalDate initialDate, 
            LocalDate finalDate) 
    {
    return production.stream().filter(l->l.getProductionTime().toLocalDate()
            .isAfter(initialDate)
              && l.getProductionTime().toLocalDate().isBefore(finalDate))
              .collect(Collectors.toList());
    }

    @Override
    public Collection<Production> findAll()
    {
    return production;
    }
}