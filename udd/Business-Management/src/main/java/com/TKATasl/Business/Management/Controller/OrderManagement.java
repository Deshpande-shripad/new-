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

import com.TKATasl.Business.Management.Entity.CoustomerManagement;
import com.TKATasl.Business.Management.Entity.OrderMan;

@RestController
public class OrderManagement {
	
	@Autowired
	SessionFactory sf;
	
	
	@GetMapping("showallRecord44")
	public List<OrderMan> getall(){
		Session ss=sf.openSession();
		Criteria criteria=ss.createCriteria(OrderMan.class);
		List<OrderMan> order=criteria.list();
		return order;
		
	}
	
	@PostMapping("insertRecord41")
	public String insert(@RequestBody OrderMan order) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(order);
		tx.commit();
		return "Inserted";
	}
	@PutMapping("updateRecord42")
	public String update(@RequestBody OrderMan order) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(order);
		tx.commit();
		return "updated Sucessfully";
	}

	@DeleteMapping("deleteRecordC/{id}") 
	public String deleteEmp(@PathVariable int id,OrderMan order) {
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.load(order,id);
		session.delete(order);
		tr.commit();
		return "Data Deleted Sucessfully !!!";
	}



	
	
	
}
