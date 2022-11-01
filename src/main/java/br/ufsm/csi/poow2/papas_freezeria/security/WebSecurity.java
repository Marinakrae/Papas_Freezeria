package br.ufsm.csi.poow2.papas_freezeria.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

//    public DaoAuthenticationProvider authProvider(){
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(this.userDetailsService);
//        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
//        return authProvider;
//    }

    @Autowired
    public void configureAutenticacao(AuthenticationManagerBuilder builder) throws Exception{
        System.out.println("**** configureAutenticacao ****");
        builder.userDetailsService(this.userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(this.authProvider());
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
//                .authenticationProvider(this.authProvider())
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/freezeria/login").permitAll()
                .antMatchers(HttpMethod.GET, "/freezeria/pedido/listar").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/freezeria/pedido/{id}").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/pedido/salvar").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/pedido/apagar/{id}").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/freezeria/pedido/editar/{id}").hasAnyAuthority("USER", "ADMIN")

                .antMatchers(HttpMethod.GET, "/freezeria/complementos/listar").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/freezeria/complementos/{id}").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/complementos/salvar").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/complementos/apagar/{id}").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/freezeria/complementos/editar/{id}").hasAnyAuthority("USER", "ADMIN")

                .antMatchers(HttpMethod.GET, "/freezeria/jogador/listar").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/freezeria/jogador/{id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/jogador/salvar").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/jogador/apagar/{id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/freezeria/jogador/editar/{id}").hasAnyAuthority("USER", "ADMIN")

                .antMatchers(HttpMethod.GET, "/freezeria/nivel/listar").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/freezeria/nivel/{id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/nivel/salvar").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/freezeria/nivel/apagar/{id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/freezeria/nivel/editar/{id}").hasAuthority("ADMIN")
                .anyRequest().denyAll();
    }

}
