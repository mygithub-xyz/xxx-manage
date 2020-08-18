package com.nanjing.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //用户认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存里面放着
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                //添加用户，密码，角色
                .withUser("sa").password("").roles("AAA")
                //链式编程
                .and()
                .withUser("ls").password("123").roles("BBB")
                .and()
                .withUser("ww").password("123").roles("CCC", "primary")
                .and()
                .withUser("admin").password("").roles("primary");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login.html")           // 设置登录页面
                .loginProcessingUrl("/login")  // 自定义的登录接口
                .successForwardUrl("/user/index")
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html", "/logout.html", "/css/**", "/favicon.ico", "/img/**", "/js/**", "/plugins/**").permitAll()     // 设置所有人都可以访问登录页面
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and().headers().frameOptions().disable()
                .and()
                .csrf().disable();// 关闭csrf防护
    }
}

