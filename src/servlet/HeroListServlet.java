package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDao;

public class HeroListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int start=0;int count=5;
		try{
			start=Integer.parseInt(request.getParameter("start"));
		}catch(NumberFormatException e){
			
		}
		String username=(String)request.getSession().getAttribute("name");
		if(null==username){
			response.sendRedirect("login.html");
			return;
		}
		int next=start+count;
		int pre=start-count;
		int total=new HeroDao().getTotal();
		int last=0;
		if(0==total%count)
			last=total-count;
		else
			last=total-total%count;
		List<Hero> heros=new HeroDao().listHero(start, count);
		pre=pre<0? 0:pre;
		next=next>last? last:next;
		request.setAttribute("heros", heros);
		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);
		request.getRequestDispatcher("listHero.jsp").forward(request, response);
	}
}
