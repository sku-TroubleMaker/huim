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
	public void registerProduct(Product Product) throws DataNotFoundException;
	
	/**
	 *  ��ǰID�� �ϳ��� ��ǰ�� �˻��ϱ� ���� �޼ҵ�
	 *  �˻��� ��ǰ��ü�� ����
	 *  (�ַ� ��ǰ ���Ž� ���)
	 *  @return Product[]
	 */
	public Product findProduct(String ProductID) throws DataNotFoundException;
	
	/**
	 *  ��ǰ�̸����� ��ǰ���� �˻��ϱ� ���� �޼ҵ�
	 *  ��ǰ�� �̸��� �̿��Ͽ� ��ǰ �˻� ��
	 *  �˻��� ��ǰ���� �迭�� ��� ����
	 *  (�˻�â ���� �Ǵ� ī�װ� Ŭ���� ���)
	 *  (�˻��� ��ǰ�� �ϳ����� �̰ž��ϴ�.)
	 *  @return Product[]
	 */
	public Product[] getSearchedProducts(String ProductName) throws DataNotFoundException;
	
	/**
	 *  ��� ��ǰ���� �˻��ϱ� ���� �޼ҵ�
	 *  �˻��� ��ǰ���� �迭�� ��� ����
	 *  ���������� �ۼ���
	 *  (����,����, �ƿ���, �׼������� if�� �����Ͽ� ��ǰ ã�� �̾��ݴϴ�.)//��� ������ ���ΰ�
	 *  @return Product[]
	 */
	public Product[] getAllProducts() throws DataNotFoundException;
	
	/**
	 *  ��ǰ������ �����ϱ� ���� �޼ҵ�
	 *  
	 */
	public void updateProduct(Product Product) throws DataNotFoundException;
	
	/**
	 *  ��ǰ�� �����ϱ� ���� �޼ҵ�
	 */
	public void removeProduct(Product Product) throws DataNotFoundException;
	
	
}
