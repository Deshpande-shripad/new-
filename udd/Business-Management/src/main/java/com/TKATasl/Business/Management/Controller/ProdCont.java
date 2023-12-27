package com.TKATasl.Business.Management.Controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TKATasl.Business.Management.Entity.ProductMang;

@RestController
public class ProdCont {

	
	@Autowired
	SessionFactory sf;
	
	@GetMapping("showAll")
	public List<ProductMang> getall(){
		Session ss=sf.openSession();
		Criteria criteria=ss.createCriteria(ProductMang.class);
		List<ProductMang> product=criteria.list();
		return product;
	}
	
	@PostMapping("insertRec20")
	public String insert(@RequestBody ProductMang product) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(product);
		tx.commit();
		return "Inserted";
	}
	@PutMapping("updateRec")
	public String update(@RequestBody ProductMang product) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(product);
		tx.commit();
		return "updated Sucessfully";
	}
	@DeleteMapping("deleteRecP/{id}")
	public String deletePro(@PathVariable int id,ProductMang product) {
		
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		
		ss.load(product, id);
		ss.delete(product);
		tx.commit();
		return "Deleted";
		}
}