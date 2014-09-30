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
				// action 요청파라미터 값을 확인한다.
				String action = request.getParameter("action");
				
				/* action 값(select/select-all)에 따라 적절한 메소드를 선택하여 호출한다.
				 * (select 이면 selectProduct(), select-all 이면 selectAllProduct() 메소드 호출) */
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
			productID = "sams110";//TODO 뭘로 바꿀까?
        }
		// 서비스 객체를 통해 적절한 비즈니스 로직을 수행
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProduct(productID);
        
        // request scope 속성에 조회된 product를 저장하고
        request.setAttribute("selectedProduct", product);
        
        // RequestDispatcher 객체를 통해 뷰 페이지(selectProduct.jsp)로 요청을 전달한다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("selectProduct.jsp");
        dispatcher.forward(request, response);
		
	}

	private void selectAllBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		
		ProductService productService = new ProductServiceImpl();
        Product[] productList = productService.getAllProducts();

        // request scope 속성에 조회된 productList를 저장하고
        request.setAttribute("productList", productList);
        
        // RequestDispatcher 객체를 통해 뷰 페이지(selectAllProducts.jsp)로 요청을 전달한다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
        dispatcher.forward(request, response);
        
	}

	private void registerBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		//요청 파라미터를 얻는다.
		String customerID = request.getParameter("customerID");
		String productID = request.getParameter("productID");
		// 서비스 객체를 통해 적절한 비즈니스 로직을 수행
		CustomerService customerService = new CustomerServiceImpl();
		ProductService productService = new ProductServiceImpl();
		BasketService basketService = new BasketServiceImpl();
		
		Customer customer = customerService.findCustomer(customerID);
		Product product = productService.findProduct(productID);
		
		if (customer == null || product == null) {
            
			Customer newCustomer = new Customer();
			Product newProduct = new Product();
            
            basketService.registerBasketItem(newCustomer, newProduct);
            
            // request scope 속성에 조회된 product를 저장하고
            request.setAttribute("selectedProduct", product);
            
            // RequestDispatcher 객체를 통해 뷰 페이지(selectProduct.jsp)로 요청을 전달한다.
            RequestDispatcher dispatcher = request.getRequestDispatcher("selectProduct.jsp");
            dispatcher.forward(request, response);
        }
		
	}

	private void buyBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		//요청 파라미터를 얻는다.
		String customerID = request.getParameter("customerID");
		String productID = request.getParameter("productID");
		//서비스 객체를 통해 하고자 하는 기능을 실행한다.
		BasketService basketService = new BasketServiceImpl();
		BuyService buyService = new BuyServiceImpl();
		//장바구니에 물품이 등록되어 있는지 확인
		Basket basket = basketService.findBasketItem(customerID, productID);
		//물품이 등록되어 있다면 그 물품의 구매정보를 수정한다.
		if(basket != null){
			buyService.registerBuyItem(basket);
			
			request.setAttribute("buyItem", basket);
		
		}
		
		
	}

	private void removeBasketItem(HttpServletRequest request,
			HttpServletResponse response) {
		//요청 파라미터를 얻는다.
		String customerID = request.getParameter("customerID");
		String productID = request.getParameter("productID");
		//서비스 객체를 통해 하고자 하는 기능을 실행한다.
		BasketService basketService = new BasketServiceImpl();
		//장바구니에 물품이 등록되어 있는지 확인
		Basket basket = basketService.findBasketItem(customerID, productID);
		//물품이 등록되어 있다면 그 물품의 구매정보를 삭제한다.
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
