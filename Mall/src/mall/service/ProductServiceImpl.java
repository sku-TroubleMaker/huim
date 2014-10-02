package mall.service;

import mall.dataaccess.ProductDaoImpl;
import mall.domain.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDataAccess;
	
	public ProductServiceImpl() {
    	productDataAccess = new ProductDaoImpl();
    }    
	
	@Override
	public void registerProduct(Product product) throws DataNotFoundException {
		
		
	}

	@Override
	public Product findProduct(String productID) throws DataNotFoundException {
		Product product = productDataAccess.selectProduct(productID);
		System.out.println(product.getName());
		return product;
	}

	@Override
	public Product[] getSearchedNameProducts(String productName)
			throws DataNotFoundException {
		Product[] nameProducts = productDataAccess.selectNameProduct(productName);
		return nameProducts;
	}
	
	@Override
	public Product[] getSearchedCategoryProducts(String productCategory)
			throws DataNotFoundException {
		Product[] categoryProducts = productDataAccess.selectNameProduct(productCategory);
		return categoryProducts;
	}
	
	@Override
	public Product[] getAllProducts() throws DataNotFoundException {
		Product[] allProducts = productDataAccess.selectAllProducts();
		return allProducts;
	}

	@Override
	public void updateProduct(Product product) throws DataNotFoundException {
		productDataAccess.insertProduct(product);
		
	}

	@Override
	public void removeProduct(String productID) throws DataNotFoundException {
		productDataAccess.deleteProduct(productID);
		
	}

}
