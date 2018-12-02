package com.video.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * �������û���¼����������ֹ�û���δ��¼�����֮�£�ִ�ж�Ӧ�Ĳ���
 * 
 * @author Administrator
 *
 */
public class LoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		String[] noUris = new String[] {"", "", "", "", "", "", ""};
		String uri = request.getRequestURI();
		boolean isFilter = true;
		for (String noUri : noUris)
			if (uri.indexOf(noUri) != -1) {
				isFilter = false;
				break;
			}
		if (isFilter) {
			Object usr = request.getSession().getValue("usr");
			if (usr == null) {
				response.sendRedirect("login");
			} else {
				chain.doFilter(request, response);
			}

		} else {
			chain.doFilter(request, response);
		}
	}

	private static boolean isAjaxRequest(HttpServletRequest request) {

		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}
}
