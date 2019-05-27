package com.huashu.interceptor;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @Auther: wyan
 * @Date: 2019/2/25 02:42
 * @Description:
 */

public class JwtFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 需要排除（不拦截）的URL的正则表达式
     */
    private Pattern excepUrlPattern;

    /**
     * 检查不通过时，转发的URL
     */
    private String redirectUrl ="http://localhost";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        // * 请求 http://127.0.0.1:8080/webApp/home.jsp?&a=1&b=2 时
        // * request.getRequestURL()：http://127.0.0.1:8080/webApp/home.jsp
        // * request.getContextPath()： /webApp
        // * request.getServletPath()：/home.jsp
        // * request.getRequestURI()： /webApp/home.jsp
        // * request.getQueryString()：a=1&b=2
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        // 如果请求的路径与forwardUrl相同，或请求的路径是排除的URL时，则直接放行
        if (servletPath.equals(redirectUrl)
                || excepUrlPattern.matcher(servletPath).matches()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        final String authHeader = request.getHeader("Authorization");
        // 如果请求头为空，则跳转到指定页面
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendRedirect(redirectUrl);

        }else {
            final String token = authHeader.substring(7); // The partafter "Bearer "
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                response.sendRedirect(redirectUrl);
            }

        }
    }

    @Override
    public void destroy() {

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //不拦截的访问资源
        excepUrlPattern = Pattern.compile("^.*(login|assert|favicon|js|img|css).*$");
    }

}