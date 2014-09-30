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
		// session scope���� �α����� ȸ���� ������ Ȯ���Ѵ�.
		
		HttpSession session = request.getSession(false);        
        if (session == null) {
        	response.sendError(HttpServletResponse.SC_FORBIDDEN, "�α����� �ʿ��մϴ�.");
        	return;
        }
        Customer customer = (Customer) session.getAttribute("loginCustomer");
        if (customer == null) {
        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "�α����� �ʿ��մϴ�.");
        	return;
        }
        String customerID = null/*customer.getCustomerID()*/;
        
        // ����Ͻ� ������ ������ MemberService ��ü�� �����Ͽ�
        CustomerService custService = new CustomerServiceImpl();
        
        // memberID�� ȸ���� �˻��Ѵ�.(CustomerService�� findMember() ���)
        Customer selectedCust = custService.findCustomer(customerID);

        // request scope �Ӽ��� ��ȸ�� customer�� �����ϰ�
        request.setAttribute("selectedCust", selectedCust);
        
        // RequestDispatcher ��ü�� ���� �� ������(updateCust.jsp)�� ��û�� �����Ѵ�.
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
