package com.believexin.wage.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Title: WageFilter</p>
 * <p>Description: 过滤器</p>
 * <p>Company: thunisoft </p> 
 * @author zhangxin
 * @date 2018年5月6日 上午11:45:23
 */
public class WageFilter implements Filter{
	
	/**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
    	// 统一设置编码
 		request.setCharacterEncoding("utf-8");
 		response.setContentType("text/html;charset=utf-8");
 		String uri = request.getRequestURI();
		String app = request.getContextPath();
						
		if (  !uri.equals(app + "/index.html") 
				&& !uri.equals(app + "/login") 
				&& !uri.equals(app + "/404.jsp") 
				&& !uri.equals(app + "/api") 
				&& !uri.equals(app + "/error.jsp") 
				&& !uri.startsWith(app + "/css") 
				&& !uri.startsWith(app + "/js") 
				&& !uri.startsWith(app + "/images")) {
			
			HttpSession session = request.getSession();			
			String empLoginName = (String) session.getAttribute("username");
			
			if (empLoginName == null) {
/*				PrintWriter out = response.getWriter();
				out.write(401);*/
				response.setStatus(401);
				return;
			}
		}
		// 继续向下执行
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
