package br.com.ayranandrade.desafioindwisesolucao.configuration;

import br.com.ayranandrade.desafioindwisesolucao.persistence.ProductionDao;
import br.com.ayranandrade.desafioindwisesolucao.persistence.ProductionDaoImpl;
import java.io.File;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.ayranandrade")
public class DesafioIndwiseSolucaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioIndwiseSolucaoApplication.class, args);
	}
        
        @Bean
        public ProductionDao productionDao() throws IOException
        {
        return new ProductionDaoImpl(System.getProperty("user.dir")
                +File.separator+"producao.json");
        }
}
