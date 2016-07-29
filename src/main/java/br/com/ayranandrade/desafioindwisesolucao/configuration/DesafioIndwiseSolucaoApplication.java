package br.com.ayranandrade.desafioindwisesolucao.configuration;

import br.com.ayranandrade.desafioindwisesolucao.model.ProductionDao;
import br.com.ayranandrade.desafioindwisesolucao.persistence.ProductionDaoFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
//        String path=downloadProductionFile();
//        return new ProductionDaoFile(path);
//        Código usado em desenvolvimento na minha máquina.
        return new ProductionDaoFile(System.getProperty("user.dir")
                +File.separator+"original"+File.separator+"producao.json");
        }
        
        private String downloadProductionFile() throws MalformedURLException, IOException
        {
        String path=System.getProperty("user.dir")+File.separator+"producao.json";
        File test=new File(path);
          if(test.exists())
          {
          return path;
          }
        System.out.println("Let's start the download of producao.json, where information belongs.");
        URL url = new URL("https://cdn.rawgit.com/Goostavo/desafioIndwise/master/producao.json");
        
          try (FileOutputStream fos = new FileOutputStream(path);InputStream is = url.openStream()) 
          {
          int bytes;
          System.out.println("downloading...");
            while ((bytes = is.read()) != -1)
            {
            fos.write(bytes);
            } 
          }
        System.out.println("download finished.");
        return path;
        }
}