package mall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.domain.Basket;
import mall.domain.Customer;
import mall.domain.Product;
import mall.service.BasketService;
import mall.service.BuyService;
import mall.service.CustomerService;
import mall.service.DataNotFoundException;
import mall.service.ProductService;

/**
 * Servlet implementation class BasketController
 */
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		 try {
				// action ��û�Ķ���� ���� Ȯ���Ѵ�.
				String action = request.getParameter("action");
				
				/* action ��(select/select-all)�� ���� ������ �޼ҵ带 �����Ͽ� ȣ���Ѵ�.
				 * (select �̸� selectProduct(), select-all �̸� selectAllProduct() �޼ҵ� ȣ��) */
				if (action.equals("select")) {
					selectBasketItem(request, response);
				} else if (action.equals("select-all")) {
					selectAllBasketItem(request, response);
				} else if (action.equals("register")) {
					registerBasketItem(request, response);
	            } else if (action.equals("update")) {
					buyBasketItem(request, response);
	            } else if (action.equals("remove")) {
					removeBasketItem(request, response);
	            } 
				
	        } catch (DataNotFoundException ex) {
	        	throw new ServletException(ex);
	        }
	 }
	
	private void selectBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		String customerID = request.getParameter("customerID");
		String productID = request.getParameter("productID");
		if ((customerID == null) || (customerID.length() == 0)||(productID == null) || (productID.length() == 0)) {
            customerID = "agy";
			productID = "sams110";//TODO ���� �ٲܱ�?
        }
		// ���� ��ü�� ���� ������ ����Ͻ� ������ ����
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProduct(productID);
        
        // request scope �Ӽ��� ��ȸ�� product�� �����ϰ�
        request.setAttribute("selectedProduct", product);
        
        // RequestDispatcher ��ü�� ���� �� ������(selectProduct.jsp)�� ��û�� �����Ѵ�.
        RequestDispatcher dispatcher = request.getRequestDispatcher("selectProduct.jsp");
        dispatcher.forward(request, response);
		
	}

	private void selectAllBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		ProductService productService = new ProductServiceImpl();
        Product[] productList = productService.getAllProducts();

        // request scope �Ӽ��� ��ȸ�� productList�� �����ϰ�
        request.setAttribute("productList", productList);
        
        // RequestDispatcher ��ü�� ���� �� ������(selectAllProducts.jsp)�� ��û�� �����Ѵ�.
        RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
        dispatcher.forward(request, response);
        
	}

	private void registerBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		//��û �Ķ���͸� ��´�.
		String customerID = request.getParameter("customerID");
		String productID = request.getParameter("productID");
		// ���� ��ü�� ���� ������ ����Ͻ� ������ ����
		CustomerService customerService = new CustomerServiceImpl();
		ProductService productService = new ProductServiceImpl();
		BasketService basketService = new BasketServiceImpl();
		
		Customer customer = customerService.findCustomer(customerID);
		Product product = productService.findProduct(productID);
		
		if (customer == null || product == null) {
            
			Customer newCustomer = new Customer();
			Product newProduct = new Product();
            
            basketService.registerBasketItem(newCustomer, newProduct);
            
            // request scope �Ӽ��� ��ȸ�� product�� �����ϰ�
            request.setAttribute("selectedProduct", product);
            
            // RequestDispatcher ��ü�� ���� �� ������(selectProduct.jsp)�� ��û�� �����Ѵ�.
            RequestDispatcher dispatcher = request.getRequestDispatcher("selectProduct.jsp");
            dispatcher.forward(request, response);
        }
		
	}

	private void buyBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		//��û �Ķ���͸� ��´�.
		String customerID = request.getParameter("customerID");
		String productID = request.getParameter("productID");
		//���� ��ü�� ���� �ϰ��� �ϴ� ����� �����Ѵ�.
		BasketService basketService = new BasketServiceImpl();
		BuyService buyService = new BuyServiceImpl();
		//��ٱ��Ͽ� ��ǰ�� ��ϵǾ� �ִ��� Ȯ��
		Basket basket = basketService.findBasketItem(customerID, productID);
		//��ǰ�� ��ϵǾ� �ִٸ� �� ��ǰ�� ���������� �����Ѵ�.
		if(basket != null){
			buyService.registerBuyItem(basket);
			
			request.setAttribute("buyItem", basket);
		
		}
		
		
	}

	private void removeBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		//��û �Ķ���͸� ��´�.
		String customerID = request.getParameter("customerID");
		String productID = request.getParameter("productID");
		//���� ��ü�� ���� �ϰ��� �ϴ� ����� �����Ѵ�.
		BasketService basketService = new BasketServiceImpl();
		//��ٱ��Ͽ� ��ǰ�� ��ϵǾ� �ִ��� Ȯ��
		Basket basket = basketService.findBasketItem(customerID, productID);
		//��ǰ�� ��ϵǾ� �ִٸ� �� ��ǰ�� ���������� �����Ѵ�.
		if(basket != null){
			basketService.removeBasketItem(basket);
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
