package mall.service;

import mall.domain.Product;

/**
 * @author �ȱٿ�
 * ��ǰ�� ���� ���񽺸� �����ϱ� ���� �������̽�
 */
public interface ProductService {

	/**
	 *  ProductDB�� ��ǰ�� ����ϱ� ���� �޼ҵ� 
	 */
	public void registerProduct(Product product) throws DataNotFoundException;
	
	/**
	 *  ��ǰID�� �ϳ��� ��ǰ�� �˻��ϱ� ���� �޼ҵ�
	 *  �˻��� ��ǰ��ü�� ����
	 *  (�ַ� ��ǰ ���Ž� ���)
	 *  @return Product[]
	 */
	public Product findProduct(String productID) throws DataNotFoundException;
	
	/**
	 *  ��ǰ�̸����� ��ǰ���� �˻��ϱ� ���� �޼ҵ�
	 *  ��ǰ�� �̸��� �̿��Ͽ� ��ǰ �˻� ��
	 *  �˻��� ��ǰ���� �迭�� ��� ����
	 *  (�˻�â ����)
	 *  (�˻��� ��ǰ�� �ϳ����� �̰ž��ϴ�.)
	 *  @return Product[]
	 */
	public Product[] getSearchedNameProducts(String productName) throws DataNotFoundException;

	/**
	 *  ��ǰī�װ��� ��ǰ���� �˻��ϱ� ���� �޼ҵ�
	 *  ��ǰ�� ī�װ��� �̿��Ͽ� ��ǰ �˻� ��
	 *  �˻��� ��ǰ���� �迭�� ��� ����
	 *  ( ī�װ� Ŭ���� ���)
	 *  (����,����,�ƿ���,�׼����� ���п� ���� ��ǰ �迭 ����)
	 *  @return Product[]
	 */
	public Product[] getSearchedCategoryProducts(String productCategory) throws DataNotFoundException;
	
	/**
	 *  ��� ��ǰ���� �˻��ϱ� ���� �޼ҵ�
	 *  �˻��� ��ǰ���� �迭�� ��� ����
	 *  ���������� �ۼ���
	 *  @return Product[]
	 */
	public Product[] getAllProducts() throws DataNotFoundException;
	
	/**
	 *  ��ǰ������ �����ϱ� ���� �޼ҵ�
	 *  
	 */
	public void updateProduct(Product product) throws DataNotFoundException;
	
	/**
	 *  ��ǰ�� �����ϱ� ���� �޼ҵ�
	 */
	public void removeProduct(String ProductID) throws DataNotFoundException;
	
	
}
