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
				// action 요청파라미터 값을 확인한다.
				String action = request.getParameter("action");
				
				/* action 값(select/select-all)에 따라 적절한 메소드를 선택하여 호출한다.
				 * (select 이면 selectProduct(), select-all 이면 selectAllProduct() 메소드 호출) */
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
		  // 요청파라미터 값을 확인하고 검증
        String productID = request.getParameter("productID");
        if ((productID == null) || (productID.length() == 0)) {
            productID = "sams110";//TODO 뭘로 바꿀까
            
            // 서비스 객체를 통해 적절한 비즈니스 로직을 수행
            ProductService productService = new ProductServiceImpl();
            Product product = productService.findProduct(productID);
            
            // request scope 속성에 조회된 product를 저장하고
            request.setAttribute("selectedProduct", product);
            
            // RequestDispatcher 객체를 통해 뷰 페이지(selectProduct.jsp)로 요청을 전달한다.
            RequestDispatcher dispatcher = request.getRequestDispatcher("selectProduct.jsp");
            dispatcher.forward(request, response);
        }
		
	}

	private void selectAllProducts(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		
		ProductService productService = new ProductServiceImpl();
        Product[] productList = productService.getAllProducts();

        // request scope 속성에 조회된 productList를 저장하고
        request.setAttribute("productList", productList);
        
        // RequestDispatcher 객체를 통해 뷰 페이지(selectAllProducts.jsp)로 요청을 전달한다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
        dispatcher.forward(request, response);
		
	}

	private void registerProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		// 요청파라미터 값을 받는다.
		String productID = request.getParameter("productID");
		
		// 서비스 객체를 통해 적절한 비즈니스 로직을 수행
		ProductService productService = new ProductServiceImpl();
		// 물품ID로 검색 후 등록이 되어있지 않다면 물품을 등록
		Product product = productService.findProduct(productID);
		if (product == null) {
			Product newProduct = new Product();//TODO argument 수정 필요 어떻게 객체를 만들어서 등록할 것인가
        	productService.registerProduct(newProduct);
        	
        	// RequestDispatcher 객체를 통해 뷰 페이지(selectAllProducts.jsp)로 요청을 전달한다.
        	RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
        	dispatcher.forward(request, response);
        }
        
		
	}
	
	private void updateProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		//요청 파라미터 값을 받는다.
		String productID = request.getParameter("productID");
		// 서비스 객체를 통해 적절한 비즈니스 로직을 수행
		ProductService productService = new ProductServiceImpl();
		// 물품ID로 검색 후 등록이 되어있다면 내용을 수정
		Product product = productService.findProduct(productID);
		if(product != null){
			productService.updateProduct(product);
			
			// RequestDispatcher 객체를 통해 뷰 페이지(selectAllProducts.jsp)로 요청을 전달한다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("selectAllProducts.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void removeProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		//요청 파라미터 값을 받는다.
		String productID = request.getParameter("productID");
		// 서비스 객체를 통해 적절한 비즈니스 로직을 수행
		ProductService productService = new ProductServiceImpl();
		// 물품ID로 검색 후 등록이 되어있다면 내용을 수정
		Product product = productService.findProduct(productID);
		if(product != null){
			productService.removeProduct(product);
			
			// RequestDispatcher 객체를 통해 뷰 페이지(selectAllProducts.jsp)로 요청을 전달한다.
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
