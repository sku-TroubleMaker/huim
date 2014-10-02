package mall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		try {
			if (action.equals("select")) {
				selectCustomer(request, response);
			} else if (action.equals("register")) {
				registerCustomer(request, response);
			} else if (action.equals("update")) {
				System.out.println("�����ǳ���");
				updateCustomer(request, response);
			} else if (action.equals("remove")) {
				removeCustomer(request, response);
			} else if (action.equals("login")) {
				loginCustomer(request, response);
			} else if (action.equals("logout")) {
				logoutCustomer(request, response);
			}
		} catch (DataNotFoundException e) {
			throw new ServletException(e);

		}

	}

	private void selectCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			DataNotFoundException {
		// session scope���� �α����� ȸ���� ������ Ȯ���Ѵ�.

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "�α����� �ʿ��մϴ�.");
			return;
		}
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		if (customer == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"�α����� �ʿ��մϴ�.");
			return;
		}
		String customerID = null/* customer.getCustomerID() */;

		// ����Ͻ� ������ ������ CustomerService ��ü�� �����Ͽ�
		CustomerService custService = new CustomerServiceImpl();

		// customerID�� ȸ���� �˻��Ѵ�.(CustomerService�� findCustomer() ���)
		Customer selectedCust = custService.findCustomer(customerID);

		// request scope �Ӽ��� ��ȸ�� customer�� �����ϰ�
		request.setAttribute("selectedCust", selectedCust);

		// RequestDispatcher ��ü�� ���� �� ������(updateCust.jsp)�� ��û�� �����Ѵ�.
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("updateCust.jsp");
		dispatcher.forward(request, response);
	}

	private void registerCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			DataNotFoundException {
		// ��û �Ķ���͸� ���� HTML �� �����͸� ����.
				String name = request.getParameter("name");
				String customerID = request.getParameter("customerID");
				String password = request.getParameter("password");
				String tel1 = request.getParameter("tel1");
				String tel2 = request.getParameter("tel2");
				String tel3 = request.getParameter("tel3");
				String email = request.getParameter("email");
				String zipcode1 = request.getParameter("zipcode1");
				String zipcode2 = request.getParameter("zipcode2");
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");

				String tel = tel1+"|"+tel2+"|"+tel3;
				String addr = zipcode1+"|"+zipcode2+"|"+address1+"|"+address2;
				
				
				System.out.println(tel1);
				// �� �������� ��ȿ���� �����ϴ� ó���� �Ѵ�.
				// ���� �޽������� ������ ����Ʈ
				List<String> errorMsgs = new ArrayList<String>();

				// �� �����Ͱ� ��ȿ�� �� ����
				/*if ((name == null) || (name.length() == 0)) {
					errorMsgs.add("�̸��� �Է����ּ���.");
				}
				if ((customerID == null) || (customerID.length() == 0)) {
					errorMsgs.add("ȸ�����̵� �Է����ּ���.");
				}
				if ((password == null) || (password.length() == 0)) {
					errorMsgs.add("�н����带 �Է����ּ���.");
				}
				if ((tel1  == null) || (tel1.length() == 0)) {
					errorMsgs.add("��ȭ��ȣ�� �Է����ּ���.");
				}
				if ((tel2  == null) || (tel2.length() == 0)) {
					errorMsgs.add("��ȭ��ȣ�� �Է����ּ���.");
				}
				if ((tel3  == null) || (tel3.length() == 0)) {
					errorMsgs.add("��ȭ��ȣ�� �Է����ּ���.");
				}
				if ((email == null) || (email.length() == 0)) {
					errorMsgs.add("�̸����ּҸ� �Է����ּ���.");
				}
				if ((address1 == null) || (address1.length() == 0)) {
					errorMsgs.add("�ּҸ� �Է����ּ���.");
				}
				if ((address2 == null) || (address2.length() == 0)) {
					errorMsgs.add("�ּҸ� �Է����ּ���.");
				}*/

				// ��ȿ���� ���� �����Ͱ� ������
				if (!errorMsgs.isEmpty()) {
					// ���� ������ request scope �Ӽ��� �����ϰ�
					request.setAttribute("errorMsgs", errorMsgs);
					// ���� ������ ��(userError.jsp)�� ��û�� �����Ѵ�.
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("userError.jsp");
					dispatcher.forward(request, response);
					return;
				}

				// ���ο� ȸ���� ����ϴ� ó���� �Ѵ�.
				// ������ �����͸� ���� Customer ��ü�� �����Ͽ�
				Customer customer = new Customer(customerID, name, password, tel,
						email, addr);

				// CustomerService ��ü�� �����Ͽ� ȸ���� ����Ѵ�.
				CustomerService customerService = new CustomerServiceImpl();
				customerService.registerCustomer(customer);

				// request scope �Ӽ��� ��ϵ� customer�� �����ϰ�
				request.setAttribute("customer", customer);
				// RequestDispatcher ��ü�� ���� �� ������(thankYou.jsp)�� ��û�� �����Ѵ�.
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("thankYou.jsp");
				dispatcher.forward(request, response);

	}

	private void updateCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			DataNotFoundException {
		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginCustomer") == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"�α����� �ʿ��մϴ�.");
			return;
		}

		String customerID = ((Customer) session.getAttribute("loginCustomer")).getCustomerID();
		
		// ������ ���� HTML �� �����͸� ����.
		
		
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String email = request.getParameter("email");
		String zipcode1 = request.getParameter("zipcode1");
		String zipcode2 = request.getParameter("zipcode2");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String grade = ((Customer) session.getAttribute("loginCustomer")).getGrade();
		Date customerDate = ((Customer) session.getAttribute("loginCustomer")).getCustomerDate();
		
		String tel = tel1+"|"+tel2+"|"+tel3;
		String address = zipcode1+"|"+zipcode2+"|"+address1+"|"+address2;
		
		// ���� �޽������� ������ ����Ʈ
			List<String> errorMsgs = new ArrayList<String>();

			// �� �����Ͱ� ��ȿ�� �� ����
			if ((password == null) || (password.length() == 0)) {
				errorMsgs.add("�н����带 �Է����ּ���.");
			}
			if ((name == null) || (name.length() == 0)) {
				errorMsgs.add("�̸��� �Է����ּ���.");
			}
			if ((email == null) || (email.length() == 0)) {
				errorMsgs.add("�̸����ּҸ� �Է����ּ���.");
			}

			// ��ȿ���� ���� �����Ͱ� ������ ���� ������ request scope �Ӽ��� �����ϰ�
			// ���� ������ ��(userError.jsp)�� ��û�� �����Ѵ�.
			if (!errorMsgs.isEmpty()) {
				request.setAttribute("errorMsgs", errorMsgs);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("userError.jsp");
				dispatcher.forward(request, response);
				return;
			}

			// ������ �����͸� ���� ��ü�� �����Ͽ�
			Customer customer = new Customer(customerID, name, password, tel, email, address, grade, (java.sql.Date) customerDate);
					
			// CustomerService ��ü�� �����Ͽ� ȸ���� ����Ѵ�.
			CustomerService customerService = new CustomerServiceImpl();
			customerService.updateCustomer(customer);

			// request scope �Ӽ��� ��ϵ� customer�� �����ϰ�
			session.setAttribute("loginCustomer", customer);
			
			// RequestDispatcher ��ü�� ���� �� ������(index.jsp)�� ��û�� �����Ѵ�.
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
				
		
		
	}

	private void removeCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			DataNotFoundException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "�α����� �ʿ��մϴ�.");
			return;
		}
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		if (customer == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"�α����� �ʿ��մϴ�.");
			return;
		}
		String customerID = customer.getCustomerID();

		// ����Ͻ� ������ ������ CustomerService ��ü�� �����Ͽ�
		CustomerService customerService = new CustomerServiceImpl();

		// customerID�� ȸ���� �˻��Ѵ�.(CustomerService�� findCustomer() ���)
		Customer selectedCustomer = customerService.findCustomer(customerID);

		// request scope �Ӽ��� ��ȸ�� customer�� �����ϰ�
		request.setAttribute("selectedCustomer", selectedCustomer);

		// RequestDispatcher ��ü�� ���� �� ������(updateCustomer.jsp)�� ��û�� �����Ѵ�.
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("updateCustomer.jsp");
		dispatcher.forward(request, response);
	}

	private void loginCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��û �Ķ���ͷκ��� customerID�� password�� �޾�

		
		String customerID = request.getParameter("customerID");
		String password = request.getParameter("password");

		
		// CustomerService ��ü�� �����Ͽ� �α��� ���� ���θ� Ȯ���Ѵ�.
		CustomerService service = new CustomerServiceImpl();
		Customer customer = service.loginCheck(customerID, password);
		
		
		
		
		// check ���� Ȯ���Ͽ�
		int check = customer.getCheck();

		if (check == Customer.VALID_CUSTOMER) {
			// 1. ��ȿ�� ȸ���� ��� ���� ��ü�� ��� session scope �Ӽ��� ȸ�� ������ �����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("loginCustomer", customer);
			// RequestDispatcher ��ü�� ���� ���� ������(index.jsp)�� ��û�� �����Ѵ�.
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} else {
			// ��ȿ���� ���� ��� request scope �Ӽ��� ���� �޽����� �����ϰ�
			// RequestDispatcher ��ü�� ���� ���� ������(index.jsp)�� ��û�� �����Ѵ�.
			String loginErrorMsg = null;

			if (check == Customer.INVALID_ID) {
				loginErrorMsg = "���̵� �������� �ʽ��ϴ�.";
			} else if (check == Customer.INVALID_PASSWORD) {
				loginErrorMsg = "�н����尡 ��ġ���� �ʽ��ϴ�.";
			}

			request.setAttribute("loginErrorMsg", loginErrorMsg);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void logoutCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("loginCustomer");
			session.invalidate();
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
