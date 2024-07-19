package br.gov.caixa.psi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class PsiMasterTiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsiMasterTiApplication.class, args);
	}
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Contratos de Crédito Imobiliário")
                        .version("1.0")
                        .description("Documentação da API de Contratos de Crédito Imobiliário"));
    }

}
