package com.tyust.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import com.tyust.bean.user.TBaseUserInfo;
public class CodeFilter implements Filter {

	private String charset;
	private FilterConfig filterConfig;
	public void destroy() {
		filterConfig = null;
	}
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request1 = (HttpServletRequest)request;
		HttpSession session = request1.getSession();
		String ctx = request1.getContextPath();
		request.setCharacterEncoding(charset);
		request1.setCharacterEncoding(charset);
	    response.setCharacterEncoding(charset);
	    response.setContentType("text/html;charset=UTF-8");
	    HttpServletResponse r = (HttpServletResponse) response;
	    TBaseUserInfo user=(TBaseUserInfo)session.getAttribute("user");
		if(user == null){
			if(request1.getRequestURI().indexOf("login.do")>0){
				
			}else if(request1.getRequestURI().indexOf(".do")>0){
				response.getWriter().print("<script type=\"text/javascript\">window.top.document.location.href='/login.jsp'</script>");
				response.getWriter().close();
				return;
			}
			if(request1.getRequestURI().matches("/login.jsp")){
				
			}else if(request1.getRequestURI().indexOf(".jsp")>0){
				response.getWriter().print("<script type=\"text/javascript\">window.top.document.location.href='/login.jsp'</script>");
				response.getWriter().close();
				return;
			}
			
		}else{
       
			  /**
	         * 思路：
	         *      1、ServletContext对象（对于整个项目是全局的）中存放一个HashMap对象，这个对象存放着格式为："用户名,密码",所对应的sessionId。
	         *      每登录一个用户就覆盖HashMap对象中"用户名,密码"对应的sessionId。
	         *      2、在过滤器中通过user对象的"用户名,密码"取出HashMap中的sessionId。如果和自己客户端的sessionId相同，就能正常操作。否则，将session中的user删除。
	         */
		 ServletContext application=request1.getSession().getServletContext();
		 HashMap<TBaseUserInfo,String> userMap=(HashMap<TBaseUserInfo,String>)application.getAttribute("userMap");
		 	if(userMap!=null && user!=null){
		 		String userSessionId=userMap.get(user.getUserName()+","+user.getPassword());
		 		if(userSessionId!=session.getId() || userSessionId==null){
		 			/**root不做限制**/
		 			if(!user.getUserName().trim().toLowerCase().equals("root")){
		 				if(request1.getHeader("X-Requested-With")!=null && request1.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")){    
				 		       PrintWriter out =response.getWriter();
				 		       out.print("asynchronous");
				 		       out.close();
				 		       return;
				 		   }
		 				session.removeAttribute("user");
		 				PrintWriter out =response.getWriter();
			 			out.print("<script type=\"text/javascript\">alert('此用户已经在别处登陆!');window.top.document.location.href='/login.jsp'</script>");
			 			out.close();
			 			return;
		 			}
		 		}
		 	}
		}
        arg2.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
         charset =  arg0.getInitParameter("charset");
         this.filterConfig = arg0;
	}

}
