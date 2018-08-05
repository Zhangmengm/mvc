package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDao;

public class HeroAddServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
        float hp  = Float.parseFloat(request.getParameter("hp"));
        int damage=Integer.parseInt(request.getParameter("damage"));
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(hp);
        hero.setDamage(damage);
        new HeroDao().addHero(hero);
        response.sendRedirect("listHero");
	}
}
