package mall.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mall.domain.Customer;
import mall.service.CustomerService;
import mall.service.CustomerServiceImpl;
import mall.service.DataNotFoundException;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, DataNotFoundException{
		String action = request.getParameter("action");
		
		try {
			if(action.equals("select")){
				selectCustomer(request, response);
			}else if(action.equals("register")){
				registerCustomer(request, response);
			}else if(action.equals("update")){
				updateCustomer(request, response);
			}else if(action.equals("remove")){
				removeCustomer(request, response);
			}else if(action.equals("login")){
				loginCustomer(request, response);
			}else if(action.equals("logout")){
				logoutCustomer(request, response);
			}
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	
	

	private void selectCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, DataNotFoundException{
		// session scope에서 로그인한 회원의 정보를 확인한다.
		
		HttpSession session = request.getSession(false);        
        if (session == null) {
        	response.sendError(HttpServletResponse.SC_FORBIDDEN, "로그인이 필요합니다.");
        	return;
        }
        Customer customer = (Customer) session.getAttribute("loginCustomer");
        if (customer == null) {
        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
        	return;
        }
        String customerID = null/*customer.getCustomerID()*/;
        
        // 비즈니스 로직을 수행할 MemberService 객체를 생성하여
        CustomerService custService = new CustomerServiceImpl();
        
        // memberID로 회원를 검색한다.(CustomerService의 findMember() 사용)
        Customer selectedCust = custService.findCustomer(customerID);

        // request scope 속성에 조회된 customer를 저장하고
        request.setAttribute("selectedCust", selectedCust);
        
        // RequestDispatcher 객체를 통해 뷰 페이지(updateCust.jsp)로 요청을 전달한다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateCust.jsp");
        dispatcher.forward(request, response);
	}
	
	private void registerCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private void updateCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private void removeCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void loginCustomer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void logoutCustomer(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
