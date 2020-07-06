package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.MyService;




@RestController
public class MyController {
	@Autowired
	MyService service;
	
	  @RequestMapping(value= "/products", method= RequestMethod.GET, 
	  produces = { MediaType.APPLICATION_JSON_VALUE, 
	  MediaType.APPLICATION_XML_VALUE })  @ResponseBody  public
	  List<Product> getEmployees() {
	  
	  return service.getProducts(); 
	  }
	 

    @RequestMapping(value= "/product", method= RequestMethod.POST,
    		produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Product> createProduct(@RequestBody Product newprod) {
        return service.addNewProduct(newprod);
    }
    @RequestMapping(value= "/product", method= RequestMethod.PUT,
    		produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ArrayList<Product> updateProduct(@RequestBody Product updemp) throws Exception {
		
		
        return service.updateProduct(updemp);
    }
    @RequestMapping(value= "/product/{id}", method= RequestMethod.DELETE,
    		produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ArrayList<Product> deleteProductById(@PathVariable int id) throws Exception {
       
 
        return service.deleteProduct(id);
    }
// 
//    @RequestMapping(value= "/employee/deleteall", method= RequestMethod.DELETE,
//    		produces = { MediaType.APPLICATION_JSON_VALUE, //
//                    MediaType.APPLICATION_XML_VALUE })
//    @ResponseBody
//    public void deleteAll() {
//        System.out.println(this.getClass().getSimpleName() + " - Delete all employees.");
//        service.deleteAllEmployees();
//    }
}
