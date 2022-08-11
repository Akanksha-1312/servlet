package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samples.domain.ProductInfo;
import com.samples.service.ProductService;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductService productService;

	public void init() throws ServletException {
		super.init();
		this.productService = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ProductInfo> product = this.productService.getProductInfo();

		request.setAttribute("product", product);

		RequestDispatcher rd = request.getRequestDispatcher("/viewproduct.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String sid=request.getParameter("id");
		
		String scost=request.getParameter("cost");
		
	
		
		if (name.equals("")||scost.equals("")||sid.equals("") ){
			PrintWriter out=response.getWriter();
			out.println("Missing Input Please fill all values.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Product.html");
			rd.include(request, response);
			
		}else {
		int id = Integer.parseInt(sid);
		long cost = Integer.parseInt(scost);
		ProductInfo products = new ProductInfo(id,name,cost);

		this.productService.addProductInfo(products);

		List<ProductInfo> product= this.productService.getProductInfo();

		request.setAttribute("product", product);

		RequestDispatcher rd = request.getRequestDispatcher("/viewproduct.jsp");
		rd.forward(request, response);
	}

}}