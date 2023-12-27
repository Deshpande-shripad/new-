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
import com.TKATasl.Business.Management.Entity.EmployeeManagement;

@RestController
public class EmpManagement {

	
	@Autowired
	SessionFactory sf;
	
	
	@GetMapping("showallRecord1")
	public List<EmployeeManagement> getall(){
		Session ss=sf.openSession();
		Criteria criteria=ss.createCriteria(EmployeeManagement.class);
		List<EmployeeManagement> emp=criteria.list();
		return emp;
		
	}
	
	@PostMapping("insertRecord31")
	public String insert(@RequestBody EmployeeManagement emp) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(emp);
		tx.commit();
		return "InsertedSucc";
	}
	
	@PutMapping("updateRecord32")
	public String update(@RequestBody EmployeeManagement emp) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(emp);
		tx.commit();
		return "updatedSucess";
	}
	@DeleteMapping("deleteRecord33/{id}") 
	public String deleteEmp(@PathVariable int id,EmployeeManagement emp) {
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.load(emp,id);
		session.delete(emp);
		tr.commit();
		return "Data Deleted Sucessfully !!!";
	}
}