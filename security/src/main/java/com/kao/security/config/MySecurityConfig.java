package com.kao.security.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //訂製規則
        http.authorizeRequests().antMatchers("/").permitAll()//permitAll() 所有人可以訪問
                .antMatchers("/level1/**").hasRole("VIP1")//hasRole 用於指定誰可以訪問
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
//      開啟login功能
//      一但自訂loginPage,那麼loginPage的請求就是登陸
//      登入要用post方式
        http.formLogin()
                .usernameParameter("user") //跟html相呼應的部分
                .passwordParameter("pwd") //跟html相呼應的部分
                .loginPage("/userlogin"); //如沒權限直接進入login頁面
//                .loginProcessingUrl("/login") //指定處裡請求

//      註銷
        http.logout().logoutSuccessUrl("/"); //自訂返回首頁面
//      當註銷成功會返回到 /login?logout 頁面 ->默認的規則

//      記住我功能，會給cookie保存user
        http.rememberMe()
            .rememberMeParameter("remember");//remember 適用於跟html呼應


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        //通過登錄機制來配置相關的使用者
        auth.inMemoryAuthentication()
                .withUser("kao").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("Gustavo").password("2266").roles("VIP2","VIP3")
                .and()
                .withUser("Maria").password("1312").roles("VIP3","VIP2");
    }
}
