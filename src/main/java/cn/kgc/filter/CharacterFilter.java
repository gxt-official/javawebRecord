package cn.kgc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mr
 * @Date 2019/10/21 14:01
 */
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println ("====================过滤器初始化=====================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //设置编码
        req.setCharacterEncoding ("UTF-8");
        resp.setCharacterEncoding ("UTF-8");
        //刷新提交
        filterChain.doFilter (req, resp);
    }

    @Override
    public void destroy() {
        System.out.println ("==========================销毁=======================");
    }
}
