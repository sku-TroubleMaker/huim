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
				System.out.println("수정되나요");
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
		// session scope에서 로그인한 회원의 정보를 확인한다.

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "로그인이 필요합니다.");
			return;
		}
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		if (customer == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"로그인이 필요합니다.");
			return;
		}
		String customerID = null/* customer.getCustomerID() */;

		// 비즈니스 로직을 수행할 CustomerService 객체를 생성하여
		CustomerService custService = new CustomerServiceImpl();

		// customerID로 회원를 검색한다.(CustomerService의 findCustomer() 사용)
		Customer selectedCust = custService.findCustomer(customerID);

		// request scope 속성에 조회된 customer를 저장하고
		request.setAttribute("selectedCust", selectedCust);

		// RequestDispatcher 객체를 통해 뷰 페이지(updateCust.jsp)로 요청을 전달한다.
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("updateCust.jsp");
		dispatcher.forward(request, response);
	}

	private void registerCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			DataNotFoundException {
		// 요청 파라미터를 통해 HTML 폼 데이터를 얻어낸다.
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
				// 폼 데이터의 유효성을 검증하는 처리를 한다.
				// 에러 메시지들을 저장할 리스트
				List<String> errorMsgs = new ArrayList<String>();

				// 폼 데이터가 유효한 지 검증
				/*if ((name == null) || (name.length() == 0)) {
					errorMsgs.add("이름을 입력해주세요.");
				}
				if ((customerID == null) || (customerID.length() == 0)) {
					errorMsgs.add("회원아이디를 입력해주세요.");
				}
				if ((password == null) || (password.length() == 0)) {
					errorMsgs.add("패스워드를 입력해주세요.");
				}
				if ((tel1  == null) || (tel1.length() == 0)) {
					errorMsgs.add("전화번호를 입력해주세요.");
				}
				if ((tel2  == null) || (tel2.length() == 0)) {
					errorMsgs.add("전화번호를 입력해주세요.");
				}
				if ((tel3  == null) || (tel3.length() == 0)) {
					errorMsgs.add("전화번호를 입력해주세요.");
				}
				if ((email == null) || (email.length() == 0)) {
					errorMsgs.add("이메일주소를 입력해주세요.");
				}
				if ((address1 == null) || (address1.length() == 0)) {
					errorMsgs.add("주소를 입력해주세요.");
				}
				if ((address2 == null) || (address2.length() == 0)) {
					errorMsgs.add("주소를 입력해주세요.");
				}*/

				// 유효하지 않은 데이터가 있으면
				if (!errorMsgs.isEmpty()) {
					// 에러 내용을 request scope 속성에 저장하고
					request.setAttribute("errorMsgs", errorMsgs);
					// 에러 페이지 뷰(userError.jsp)로 요청을 전달한다.
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("userError.jsp");
					dispatcher.forward(request, response);
					return;
				}

				// 새로운 회원을 등록하는 처리를 한다.
				// 적절한 데이터를 가진 Customer 객체를 생성하여
				Customer customer = new Customer(customerID, name, password, tel,
						email, addr);

				// CustomerService 객체에 위임하여 회원을 등록한다.
				CustomerService customerService = new CustomerServiceImpl();
				customerService.registerCustomer(customer);

				// request scope 속성에 등록된 customer를 저장하고
				request.setAttribute("customer", customer);
				// RequestDispatcher 객체를 통해 뷰 페이지(thankYou.jsp)로 요청을 전달한다.
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
					"로그인이 필요합니다.");
			return;
		}

		String customerID = ((Customer) session.getAttribute("loginCustomer")).getCustomerID();
		
		// 세션을 통해 HTML 폼 데이터를 얻어낸다.
		
		
		
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
		
		// 에러 메시지들을 저장할 리스트
			List<String> errorMsgs = new ArrayList<String>();

			// 폼 데이터가 유효한 지 검증
			if ((password == null) || (password.length() == 0)) {
				errorMsgs.add("패스워드를 입력해주세요.");
			}
			if ((name == null) || (name.length() == 0)) {
				errorMsgs.add("이름을 입력해주세요.");
			}
			if ((email == null) || (email.length() == 0)) {
				errorMsgs.add("이메일주소를 입력해주세요.");
			}

			// 유효하지 않은 데이터가 있으면 에러 내용을 request scope 속성에 저장하고
			// 에러 페이지 뷰(userError.jsp)로 요청을 전달한다.
			if (!errorMsgs.isEmpty()) {
				request.setAttribute("errorMsgs", errorMsgs);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("userError.jsp");
				dispatcher.forward(request, response);
				return;
			}

			// 적절한 데이터를 가진 객체를 생성하여
			Customer customer = new Customer(customerID, name, password, tel, email, address, grade, (java.sql.Date) customerDate);
					
			// CustomerService 객체에 위임하여 회원을 등록한다.
			CustomerService customerService = new CustomerServiceImpl();
			customerService.updateCustomer(customer);

			// request scope 속성에 등록된 customer를 저장하고
			session.setAttribute("loginCustomer", customer);
			
			// RequestDispatcher 객체를 통해 뷰 페이지(index.jsp)로 요청을 전달한다.
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
				
		
		
	}

	private void removeCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			DataNotFoundException {

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "로그인이 필요합니다.");
			return;
		}
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		if (customer == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"로그인이 필요합니다.");
			return;
		}
		String customerID = customer.getCustomerID();

		// 비즈니스 로직을 수행할 CustomerService 객체를 생성하여
		CustomerService customerService = new CustomerServiceImpl();

		// customerID로 회원를 검색한다.(CustomerService의 findCustomer() 사용)
		Customer selectedCustomer = customerService.findCustomer(customerID);

		// request scope 속성에 조회된 customer를 저장하고
		request.setAttribute("selectedCustomer", selectedCustomer);

		// RequestDispatcher 객체를 통해 뷰 페이지(updateCustomer.jsp)로 요청을 전달한다.
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("updateCustomer.jsp");
		dispatcher.forward(request, response);
	}

	private void loginCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터로부터 customerID와 password를 받아

		
		String customerID = request.getParameter("customerID");
		String password = request.getParameter("password");

		
		// CustomerService 객체에 위임하여 로그인 가능 여부를 확인한다.
		CustomerService service = new CustomerServiceImpl();
		Customer customer = service.loginCheck(customerID, password);
		
		
		
		
		// check 값을 확인하여
		int check = customer.getCheck();

		if (check == Customer.VALID_CUSTOMER) {
			// 1. 유효한 회원일 경우 세션 객체를 얻어 session scope 속성에 회원 정보를 저장한다.
			HttpSession session = request.getSession();
			session.setAttribute("loginCustomer", customer);
			// RequestDispatcher 객체를 통해 메인 페이지(index.jsp)로 요청을 전달한다.
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		} else {
			// 유효하지 않을 경우 request scope 속성에 에러 메시지를 저장하고
			// RequestDispatcher 객체를 통해 메인 페이지(index.jsp)로 요청을 전달한다.
			String loginErrorMsg = null;

			if (check == Customer.INVALID_ID) {
				loginErrorMsg = "아이디가 존재하지 않습니다.";
			} else if (check == Customer.INVALID_PASSWORD) {
				loginErrorMsg = "패스워드가 일치하지 않습니다.";
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
