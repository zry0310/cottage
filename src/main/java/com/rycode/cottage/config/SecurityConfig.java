//package com.rycode.cottage.config;
//
//import com.rycode.cottage.mapper.AdminInfoMapper;
//import com.rycode.cottage.model.AdminInfo;
//import com.rycode.cottage.utils.JwtUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.util.CollectionUtils;
//
//import javax.annotation.Resource;
//import javax.servlet.http.Cookie;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static com.rycode.cottage.utils.JwtUtil.TOKEN_HEADER;
//
//@Slf4j
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Resource
//    private AdminInfoMapper adminInfoMapper;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//              .antMatchers("/css/**", "/", "/index", "/loginPage").permitAll() // 无需认证
//                .anyRequest().authenticated() // 其他请求都需要认证
//        ;
//
//        http.formLogin() // 开启登录，如果没有权限，就会跳转到登录页
////                .loginPage("/loginPage") // 自定义登录页，默认/login（get请求）
//                .loginProcessingUrl("/login") // 登录处理地址，默认/login（post请求）
//                .usernameParameter("name") // 自定义username属性名，默认username
//                .passwordParameter("password") // 自定义password属性名，默认password
//        ;
//
//        http.rememberMe() // 开启记住我
//                .rememberMeParameter("rememberMe") // 自定义rememberMe属性名
//        ;
//
//        http.logout() // 开启注销
//                .logoutUrl("/logout") // 注销处理路径，默认/logout
//                .logoutSuccessUrl("/") // 注销成功后跳转路径
//        ;
//
//        http.csrf().disable(); // 禁止csrf
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            AdminInfo user = adminInfoMapper.selectByName(username);
//            if (user == null) {
//                throw new UsernameNotFoundException("账号或密码错误！");
//            }
//            String roleCodeArray = String.valueOf(user.getIsAdmin());
////            String[] roleCodeArray = user.getRoleIds().stream().map(Role::getCode).toArray(String[]::new);
//
//            return User.withUsername(user.getName())
//                    .password(user.getPassword())
//                    .roles(roleCodeArray)
//                    .build();
//        };
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler loginSuccessHandler() {
//        return (request, response, authentication) -> {
//            List<String> authorities = new ArrayList<>();
//            if (!CollectionUtils.isEmpty(authentication.getAuthorities())) {
////                authorities.addAll(authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
//                authorities.add("is_admin");
//            }
//            String token = JwtUtil.generateToken(authentication.getName(), authorities);
//            // 将token添加到header中
//            response.setHeader(TOKEN_HEADER, JwtUtil.TOKEN_PREFIX + token);
//            // 将token添加到cookie中
//            Cookie cookie = new Cookie(TOKEN_HEADER, JwtUtil.TOKEN_PREFIX + token);
//            cookie.setPath("/");
//            cookie.setMaxAge(JwtUtil.TTL_COOKIE);
//            response.addCookie(cookie);
//            log.info("登录成功，username: {}, token: {}", authentication.getName(), token);
//        };
//    }
//}
