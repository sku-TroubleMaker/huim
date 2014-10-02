package mall.test;

import mall.domain.Product;
import mall.service.DataNotFoundException;
import mall.service.ProductService;
import mall.service.ProductServiceImpl;

public class Test {
	 
	
	
	
	public static void main(String[] args) throws DataNotFoundException {
		
		ProductService ps;
		ps = new ProductServiceImpl();
		Product product = new Product("sh2020", "이름몰라", "사이즈커", 500, 5, 40, 20, "현경이네", "", "아우터", "자켓");
		
		System.out.println(ps.findProduct(product.getCode()).getCode());	
	
	}
}
