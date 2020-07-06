package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class MyService {
	public static ArrayList<Product> al=new ArrayList<Product>();

	

	public List<Product> getProducts(){
		al.add(new Product(1,"Pen", "Reynolds", 10));
		al.add(new Product(2,"Pencil", "Apsara", 5));
		al.add(new Product(3,"Copy", "ClassMate", 50));
		al.add(new Product(4,"Eraser", "Camel", 3));
		al.add(new Product(5,"Sharpener", "Camel", 5));
		return al;
		};
		public List<Product> addNewProduct(Product prod) {
			int id=prod.getId();
			
				al.add(prod);
			
			
			return al;
		};
		public ArrayList<Product> updateProduct(Product prod) {
			System.out.println(prod.toString());
			int id=(prod.getId())-1;
			al.get(id);
			System.out.println(al.get(id));
			al.set(id, prod);
			return al;
		}
		public ArrayList<Product> deleteProduct(int id) {
			al.remove((id-1));
			return al;
		}
}
