package systemcontext;

import javax.servlet.*;
import java.io.IOException;

public class SystemContextFilter implements Filter {
	int pageSize;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		try {
			int pageIndex = 1;
			int pageSize = 5;
			try {
				//根据浏览器URL，后面的pageIndex=2
				pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
			} catch (NumberFormatException e) {
			}
			//根据页面重新设置
			SystemContext.setPageIndex(pageIndex);
			SystemContext.setPageSize(pageSize);
			chain.doFilter(req, resp);
		} finally {
			SystemContext.removePageIndex();
			SystemContext.removePageSize();
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 15;
		}
	}

}
