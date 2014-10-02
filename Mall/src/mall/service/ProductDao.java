package mall.service;


import mall.domain.Product;

/**
 * ��ǰ ���� ������ �׼��� ó���� ����� ��ü�� �԰��� ������ �������̽�.<br/>
 * ������ �׼��� ���� �и������ν� ������ �׼��� �� �̿� ����̳� ������ ����Ǿ ����Ͻ� ���� ���� ������ ���� �ʴ´�.
 */
public interface ProductDao {

	/**
	 * ������ ����ҿ��� �μ��� �־��� productID�� �ش��ϴ� ��ǰ������ �˻��Ѵ�.
	 * 
	 * @param productID
	 *            �˻��ϰ��� �ϴ� ��ǰ�� productID
	 * @return �˻��� ��ǰ������ ��� �ִ� Product ��ü
	 */
	public Product selectProduct(String productID);
	
	/**
	 * ������ ����ҿ��� �μ��� �־��� productName�� �ش��ϴ� ��ǰ���� ������ �˻��Ѵ�.
	 * 
	 * @param productName
	 *            �˻��ϰ��� �ϴ� ��ǰ�� productName
	 * @return �˻��� ��ǰ���� ������ ��� �ִ� Product[] ��ü
	 */
	public Product[] selectNameProduct(String productName);
	
	/**
	 * ������ ����ҿ��� �μ��� �־��� category�� �ش��ϴ� ��ǰ���� ������ �˻��Ѵ�.
	 * 
	 * @param category
	 *            �˻��ϰ��� �ϴ� ��ǰ�� category
	 * @return �˻��� ��ǰ���� ������ ��� �ִ� Product[] ��ü
	 * ī�װ�: top, bottom, outer, accessory
	 */
	public Product[] selectCategoryProduct(String category);
	
//	/**
//	 * ������ ��ǰ���� �μ��� �־��� price�� ������ ������, �������� �����Ͽ� �����Ѵ�.
//	 * 
//	 * @param price, highlow
//	 *            �˻��ϰ��� �ϴ� ��ǰ�� price
//	 * @return �˻��� ��ǰ���� ������ ��� �ִ� Product[] ��ü
//	 * 
//	 */
//	public Product[] sortPriceProduct(Product[] products, String highlow);
		
	/**
	 * ������ ��ǰ���� �μ��� �־��� sellCount�� �������� �����Ͽ� �����Ѵ�.
	 * 
	 * @param sellCount
	 *            �˻��ϰ��� �ϴ� ��ǰ�� sellCount
	 * @return �˻��� ��ǰ���� ������ ��� �ִ� Product[] ��ü
	 * 
	 */
	public Product[] sortSellCountProduct(Product[] Products, int sellCount);
	
	/**
	 * ������ ����ҿ� �μ��� �־��� product�� �ش��ϴ� ��ǰ������ ����Ѵ�.
	 * 
	 * @param product
	 *            ����ϰ��� �ϴ� ��ǰ ������ ��� �ִ� Product ��ü
	 */

	public void insertProduct(Product product);
	
	public void deleteProduct(String productID);
	
	public void updateProduct(Product product);

	public Product[] selectAllProducts();

	/**
	 * ������ ����ҿ� �μ��� �־��� productID�� �ش��ϴ� ���� ��ǰ������ �ִ��� Ȯ���Ѵ�.
	 * 
	 * @return �ش��ϴ� ��ǰ������ �����ϸ� true, �������� ������ false
	 */
	public boolean productIDExists(String productID);

}
