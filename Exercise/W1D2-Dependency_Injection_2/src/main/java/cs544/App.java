package cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		//IProductService productService = new ProductService();
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		IProductService productService=context.getBean("productService", IProductService.class);
		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}

		System.out.println("we have " + productService.getNumberInStock(423)
				+ " product(s) with productNumber 423 in stock");
		System.out.println("we have " + productService.getNumberInStock(239)
				+ " product(s) with productNumber 239 in stock");
	}
}
