package br.com.ayranandrade.desafioindwisesolucao.controller;

import br.com.ayranandrade.desafioindwisesolucao.model.ResultProductionPerDay;
import br.com.ayranandrade.desafioindwisesolucao.model.ProductionDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ayran
 */
@Controller
public class HomeController 
{
    private final ProductionDao dao;

    @Autowired
    public HomeController(ProductionDao dao) {
        this.dao = dao;
    }
    
    /**
     * Este método descobre a produção por dia em um determinado intervalo
     * de dias. Ou seja, com ele podemos saber que, por exemplo, quantas 
     * unidades do produto foram fabricadas por dia entre os dias 17 e 20 de 
     * março de 2016.
     * @param initialDate A data inicial do intervalo. Este atributo é do tipo 
     * String, pois caso fosse java.util.Date e fosse passada uma String 
     * inválida para o servidor, o 
     * Spring atirava uma exceção na qual eu não consegui capturar e contornar.
     * @param finalDate A data final do intervalo. O motivo deste parâmetro ser 
     * String é o mesmo do parâmetro de cima.
     * @param model Usado para retornar atributos para a view.
     * @return A página web que a view deve mostrar.
     */
    @RequestMapping(value="/search",method=RequestMethod.POST)
    public String productionPerDayForPeriod(@RequestParam(value="initialDate") 
    String initialDate, @RequestParam("finalDate") String finalDate, Model model)
    {
    DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    List<ResultProductionPerDay> results=new ArrayList<>();
    LocalDate start,end;
    
      try
      {
      start=LocalDate.parse(initialDate,format);
      end=LocalDate.parse(finalDate,format);
      }
      catch(DateTimeParseException ex)
      {
      model.addAttribute("error",true);
      return "search";
      }
    
    dao.findProductionBetween(start,end).stream().collect(Collectors
                 .groupingBy(p->p.getProductionTime().toLocalDate()))
                 .values().forEach(p->results.add(
                         new ResultProductionPerDay(p.size(),p.get(0)
                                 .getProductionTime().toLocalDate()
                         )));
    
    Collections.sort(results,Collections.reverseOrder());
    
    model.addAttribute("results",results);
    return "index";
    }
    
    @RequestMapping(value="/production",method=RequestMethod.GET)
    public String productionPerDaySinceEver(Model model)
    {
    List<ResultProductionPerDay> results=new ArrayList<>();
    
    dao.findAll().stream().collect(Collectors.groupingBy(p->
            p.getProductionTime().toLocalDate())).values().forEach(p->
                    results.add(new ResultProductionPerDay(p.size(),p.get(0)
                                 .getProductionTime().toLocalDate()
                         )));
    
    Collections.sort(results,Collections.reverseOrder());
    
    model.addAttribute("results",results);
    return "index";
    }    
    
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index()
    {
    return "redirect:/production";
    }
    
    @RequestMapping(value="/search",method = RequestMethod.GET)
    public String search()
    {
    return "search";
    }
}