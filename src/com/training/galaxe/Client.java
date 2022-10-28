package com.training.galaxe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.galaxe.dao.ProductDAO;
import com.training.galaxe.dao.ProductDAOImpl;
import com.training.galaxe.model.Product;

public class Client {

	Scanner scanner = new Scanner(System.in);

	int productId,price,quantityOnHand;
	String productName;
	int min,max;
	Product product =new Product();
	List<Product> products=new ArrayList<Product>();
	ProductDAO productDAO = new ProductDAOImpl();
	
	
	public Client() {
	}

	public void productApp() {
		System.out.println("enter choice:");
		int choice = scanner.nextInt();
			switch(choice) {
			case 1: 
						System.out.println("####Welcome to add product section####");
						System.out.println( "Enter product id :"); productId = scanner.nextInt();
						System.out.println( "Enter product name :"); productName = scanner.next();
						System.out.println( "Enter product price :"); price = scanner.nextInt();
//						System.out.println( "Enter product price :"); price = scanner.nextInt();
						Product product1 = new Product(productId, productName,price);
						productDAO.saveProduct(product1);
						System.out.println("Product with product name : "+productName+ "  saved successfully!!");
						break;
			case 2:
						System.out.println("####Welcome to add product section####");
						System.out.println( "Enter product id for updation :"); productId = scanner.nextInt();
						System.out.println( "Enter product name :"); productName = scanner.next();
						System.out.println( "Enter product quantity on hand :"); quantityOnHand = scanner.nextInt();
//						System.out.println( "Enter product price :"); price = scanner.nextInt();
						Product product2 = new Product(productId, productName,price);
						productDAO.updateProduct(product2);
						System.out.println("Product with product name : "+productName+ "  saved successfully!!");
						break;
						
						
			case 3:
				System.out.println("####Welcome to add product section####");
				System.out.println( "Enter product id for deletion :"); productId = scanner.nextInt();
				
//				Product product3 = new Product(productId);
				productDAO.deleteProduct(productId);
				System.out.println("Product with product name : "+productName+ "  saved successfully!!");
				break;
				
			case 4:
				System.out.println("enter product ID:");
				productId=scanner.nextInt();
				product =productDAO.getProduct(productId);
				System.out.println("done by id");
				System.out.println(product);
				break;
			case 5:
				System.out.println("display product detsils:");
				
				products =productDAO.getProduct();
				if(products.size()==0)
				{
					System.out.println("not available products list");
					break;
				}
				else
				{
					for(Product i: products)
					{
						System.out.println(i);
					}
					System.out.println(products);
					System.out.println("done generation");
					break;
				}
			case 6:
				System.out.println("checkin product exists or not");
				System.out.println("enter id");
				productId=scanner.nextInt();
				if(productDAO.isProductExists(productId))
				{
					System.out.println("available");
					break;
				}
				else {
					System.out.println("not available");
					break;
				}
			case 7:
				System.out.println("Search by product name and price");
				System.out.println("product NAmae");
				productName=scanner.next();
				System.out.println("product price");
				price=scanner.nextInt();
				List<Product> products =new ArrayList<Product>();
				products=productDAO.searchProduct(productName, price);
				System.out.println(products);
				System.out.println("done");
				break;
				
			case 8:
				System.out.println("enter price Range:");
				System.out.println("min:");
				min=scanner.nextInt();
				System.out.println("max:");
				max=scanner.nextInt();
//				List<Product> products =new ArrayList<Product>();
				products=productDAO.getProduct(min, max);
				System.out.println(products);
				System.out.println("done");
				break;
			case 9:
				System.out.println("search product by price");
				product=productDAO.getProduct(price);
				
			}
			
				
			
			
		}
	public static void main(String[] args) {
		
			Client c = new Client();
			c.productApp();
		
		
		
	}

}
