package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class LocaleSelectFilter
 */
@WebFilter("/localeSelect")
public class LocaleSelectFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LocaleSelectFilter.class);
	
    public LocaleSelectFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		logger.debug(req.getRequestURI());
		
		LocaleSelectWrapper localeSelectWrapper = new LocaleSelectWrapper(req);
		localeSelectWrapper.getParameter("locale");
		
		chain.doFilter(localeSelectWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
