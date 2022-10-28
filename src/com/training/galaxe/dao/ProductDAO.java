package com.training.galaxe.dao;

import java.util.List;

import com.training.galaxe.model.Product;

public interface ProductDAO {
	
		public void saveProduct(Product product);
		public void updateProduct(Product product);
		public void deleteProduct(int productId);
		public Product getProduct(int productId);
		public List<Product> getProduct();
		public boolean isProductExists(int productId);
		public List<Product> searchProduct(String productName,int price);
		public List<Product> getProduct(String productName);
		public List<Product> getProduct(int min,int max);
		
		public String checkProductInventory(int productId,int quantityRequired);		//In Stock , or Out of Stock
		public List<Product> getProductByPrice(int price);
}
