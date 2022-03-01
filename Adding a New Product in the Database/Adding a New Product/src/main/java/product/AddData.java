package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@WebServlet("/adddata")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String cost=request.getParameter("price");
		int price=Integer.parseInt(cost);
		String quant=request.getParameter("quantity");
		int quantity=Integer.parseInt(quant);
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Product prod= new Product(name, price, quantity);
		session.save(prod);
		tx.commit();
		session.close();
		response.getWriter().print("<h1 align='center'style='color: green'>Your product is successfully saved to the database.</h1>");
		
	}

}
