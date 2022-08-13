package com.empresa.apiRest_DataPrint.WebSecurityConfigurer;


import com.empresa.apiRest_DataPrint.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService usuarioDetailService;

    @Autowired
    private JWTokenFilter filter;
    @Autowired
    private EntryPoint entryPoint;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioDetailService).passwordEncoder(encriptado());
    }
    public static final String privilegesClients []={
            "/rest/v1/carrito/agregarCarrito/**",
            "/stripe/**",
            "api/v1/ventas/create/**"
    };
    
    public static final String privilegesUsuarios[]= {
            "/rest/v1/usuarios/**",
            "/rest/v1/cliente/**",
    		"/rest/v1/producto/**",
            "/rest/v1/proveedor/**",
            "/rest/v1/empleado/**",
            "/rest/v1/categoria/**",
            "/rest/v1/categoria/eliminar/**",
            "/rest/v1/caracterizticas/**"
    };
    public static final String permitAll[]= {
            "/stripe/paymentIntent",
            "/stripe/confirm/**",
            "/validarCodigoVerificacion/**",
            "/registrar/**",
            "/",
            "/rest/v1/usuarios/crearToken",
            "/p/**"
    };

    // Configurar la parte generica
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.anonymous().disable();
        http.authorizeRequests()
                .antMatchers(permitAll).permitAll()
                .antMatchers(privilegesClients).hasRole("CLIENTE")
                .antMatchers(privilegesUsuarios).hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .cors()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }
    @Bean
    public PasswordEncoder encriptado(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



   /* @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    */
}
