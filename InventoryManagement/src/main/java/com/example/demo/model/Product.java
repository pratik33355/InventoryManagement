package com.example.demo.model;



public class Product {
	 
    private int id;
    private String name;
    private String brand;
    private double price;
 
    public Product() {
 
    }
 
//    public Employee(EmployeeForm empForm) {
//        this.id = empForm.getId();
//        this.name = empForm.getName();
//        this.brand = empForm.getDepartment();
//        this.salary = empForm.getSalary();
//    }
// 
    public Product(int id, String name, String brand, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
   
}
