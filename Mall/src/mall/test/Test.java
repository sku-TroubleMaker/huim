package mall.test;

import mall.domain.Product;
import mall.service.DataNotFoundException;
import mall.service.ProductService;
import mall.service.ProductServiceImpl;

public class Test {
	 
	
	
	
	public static void main(String[] args) throws DataNotFoundException {
		
		ProductService ps;
		ps = new ProductServiceImpl();
		Product product = new Product("sh2020", "�̸�����", "������Ŀ", 500, 5, 40, 20, "�����̳�", "", "�ƿ���", "����");
		
		System.out.println(ps.findProduct(product.getCode()).getCode());	
	
	}
}
