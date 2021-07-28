package curso.springboot.security;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebConfigSecurity  extends WebSecurityConfigurerAdapter{ //estende classe de segurança do spring 
	@Autowired
	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
	
	@Override //Configura as solicitações de acesso por http
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
		.disable() //Desativa as configurações padrão de memória do spring 
		.authorizeRequests() // Permite restringir acessos
		.antMatchers(HttpMethod.GET, "/").permitAll() //qualquer usuario acessa a pagina inicial
        .anyRequest().authenticated()
        .and().formLogin().permitAll() // permite qualquer usuario
        .and().logout()// mapeia url de logout e invalida usuario autenticado 
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override // Cria autenticação do usuario com banco de dados ou em memória 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(implementacaoUserDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
		
		
		/*
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.withUser("roberto")
		.password("$2a$10$Xnjw09p8DffXlccIuqEV.OcmmdBGd71QrqmtLrvTAqiZIqa6rtky6")
		.roles("ADMIN");
		
		*/
	}
	
	@Override //Ignora url especificas 
		public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/materialize/**");
		
		
		
		
		}

}
