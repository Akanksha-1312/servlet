import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/submit")
public class ProductService extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static int id=1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ArrayList<Product> list=new ArrayList<>();
		

			String name=req.getParameter("pname");
			String price=req.getParameter("pprice");
			
			LocalDate date = LocalDate.now();
			String da=date.toString();
			Product ob=new Product(1,name,price,da);
			list.add(ob);
		
		
		
		HttpSession session=req.getSession();
		
		
		
		
		session.setAttribute("list", list);
		
		resp.sendRedirect("target.jsp");
		

	}
	

}