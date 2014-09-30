package mall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.domain.Product;
import mall.service.DataNotFoundException;
import mall.service.ProductService;
import mall.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
	
		 try {
				// action ��û�Ķ���� ���� Ȯ���Ѵ�.
				String action = request.getParameter("action");
				
				/* action ��(select/select-all)�� ���� ������ �޼ҵ带 �����Ͽ� ȣ���Ѵ�.
				 * (select �̸� selectProduct(), select-all �̸� selectAllProduct() �޼ҵ� ȣ��) */
				if (action.equals("select")) {
					selectProduct(request, response);
				} else if (action.equals("select-all")) {
					selectAllProducts(request, response);
				} else if (action.equals("register")) {
					registerProduct(request, response);
				} else if (action.equals("update")) {
					updateProduct(request, response);
				} else if (action.equals("remove")) {
					removeProduct(request, response);
				}


				
	        } catch (DataNotFoundException ex) {
	        	throw new ServletException(ex);
	        }
		
	}
	

	private void selectProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		  // ��û�Ķ���� ���� Ȯ���ϰ� ����
        String productID = request.getParameter("productID");
        if ((productID == null) || (productID.length() == 0)) {
            productID = "sams110";//TODO ���� �ٲܱ�
            
            // ���� ��ü�� ���� ������ ����Ͻ� ������ ����
            ProductService productService = new ProductServiceImpl();
            Product product = productService.findProduct(productID);
            
            // request scope �Ӽ��� ��ȸ�� product�� �����ϰ�
            request.setAttribute("selectedProduct", product);
            
            // RequestDispatcher ��ü�� ���� �� ������(selectProduct.jsp)�� ��û�� �����Ѵ�.
            RequestDispatcher dispatcher = request.getRequestDispatcher("selectProduct.jsp");
            dispatcher.forward(request, response);
        }
		
	}

	private void selectAllProducts(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		
		ProductService productService = new ProductServiceImpl();
        Product[] productList = productService.getAllProducts();

        // request scope �Ӽ��� ��ȸ�� productList�� �����ϰ�
        request.setAttribute("productList", productList);
        
        // RequestDispatcher ��ü�� ���� �� ������(selectAllProducts.jsp)�� ��û�� �����Ѵ�.
        RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
        dispatcher.forward(request, response);
		
	}

	private void registerProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		// ��û�Ķ���� ���� �޴´�.
		String productID = request.getParameter("productID");
		
		// ���� ��ü�� ���� ������ ����Ͻ� ������ ����
		ProductService productService = new ProductServiceImpl();
		// ��ǰID�� �˻� �� ����� �Ǿ����� �ʴٸ� ��ǰ�� ���
		Product product = productService.findProduct(productID);
		if (product == null) {
			Product newProduct = new Product();//TODO argument ���� �ʿ� ��� ��ü�� ���� ����� ���ΰ�
        	productService.registerProduct(newProduct);
        	
        	// RequestDispatcher ��ü�� ���� �� ������(selectAllProducts.jsp)�� ��û�� �����Ѵ�.
        	RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
        	dispatcher.forward(request, response);
        }
        
		
	}
	
	private void updateProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		//��û �Ķ���� ���� �޴´�.
		String productID = request.getParameter("productID");
		// ���� ��ü�� ���� ������ ����Ͻ� ������ ����
		ProductService productService = new ProductServiceImpl();
		// ��ǰID�� �˻� �� ����� �Ǿ��ִٸ� ������ ����
		Product product = productService.findProduct(productID);
		if(product != null){
			productService.updateProduct(product);
			
			// RequestDispatcher ��ü�� ���� �� ������(selectAllProducts.jsp)�� ��û�� �����Ѵ�.
			RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void removeProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		//��û �Ķ���� ���� �޴´�.
		String productID = request.getParameter("productID");
		// ���� ��ü�� ���� ������ ����Ͻ� ������ ����
		ProductService productService = new ProductServiceImpl();
		// ��ǰID�� �˻� �� ����� �Ǿ��ִٸ� ������ ����
		Product product = productService.findProduct(productID);
		if(product != null){
			productService.removeProduct(product);
			
			// RequestDispatcher ��ü�� ���� �� ������(selectAllProducts.jsp)�� ��û�� �����Ѵ�.
			RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
