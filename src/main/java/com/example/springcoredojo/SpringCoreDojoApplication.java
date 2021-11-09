package com.example.springcoredojo;

import com.example.springcoredojo.Entidades.Config;
import com.example.springcoredojo.Entidades.Usuario;
import com.example.springcoredojo.EstidadesYoutuber.Youtuber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreDojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDojoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			//Los metodos jamas van en mayuscula
			creacionBean ();
			creacionBeanYoutuber();
			CreacionBeanXml();
		};


	}

	//Metodo de xml
	private void CreacionBeanXml() {
		//Es para llamar la configuracion del Bean aplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("ejem-Alum-config.xml");
		Usuario u = (Usuario) context.getBean("usuario");
		System.out.println(" ");
		System.out.println("Alumn@: " + u.getAlumno().getNombre()  );
		System.out.println("Apellido " + u.getAlumno().getApellido());
		System.out.println("Edad: " + u.getAlumno().getEdad() );
	}

	private void creacionBeanYoutuber() {

		ApplicationContext context = new ClassPathXmlApplicationContext("user-bean-config.xml");
		Youtuber Yotuber = context.getBean(Youtuber.class);
		System.out.println("Youtuber: " + Yotuber.getNombre());
	}

	private void creacionBean() {

		//EN sout el nombre de la calse si puede ser mayuscula en el get bean debe ser minuscula

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Usuario UsuarioGenadoPorBean = context.getBean("usuario", Usuario.class);
		System.out.println("usuario: " + UsuarioGenadoPorBean);
	}


}
