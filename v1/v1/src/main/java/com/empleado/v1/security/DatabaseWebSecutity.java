package com.empleado.v1.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class DatabaseWebSecutity extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource datasource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(datasource).
        usersByUsernameQuery("select username, password, estatus from tbl_usuarios where username=?").
        authoritiesByUsernameQuery("select u.username, p.nom_perfil from usuario_perfil up "+
        "inner join tbl_usuarios u on u.id=up.id_usuario "+
        "inner join tbl_perfiles p on p.id =up.id_perfil "+
        "where u.username = ?");
        
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// Los recursos estáticos no requieren autenticación
		.antMatchers(
			"/bootstrap-datepicker-1.9.0-dist/**",
			"/images/**",
            "/images/logos/**",
			"js/**").permitAll()
		// Las vistas públicas no requieren autenticación
		.antMatchers("/",
			"/index",
            "/usuario/create" 
            
			).permitAll()
			

         // Asignar permisos a URLs por ROLES
        .antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
        .antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
        .antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
		// Todas las demás URLs de la Aplicación requieren autenticación
		.anyRequest().authenticated()
		// El formulario de Login no requiere autenticacion
		.and().formLogin().permitAll();
	}


}