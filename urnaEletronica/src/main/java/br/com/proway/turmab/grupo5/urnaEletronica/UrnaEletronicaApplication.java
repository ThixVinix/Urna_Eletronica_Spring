package br.com.proway.turmab.grupo5.urnaEletronica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class UrnaEletronicaApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(UrnaEletronicaApplication.class, args);
	}

	/**
	 * <p>
	 * Metodo de configuracao de reconhecimento dos arquivos estaticos
	 * </p>
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
		registry.addResourceHandler("/templates/**")
				.addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
		super.addResourceHandlers(registry);
	}

}