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

@RestController
public class Coustomer {

	@Autowired
	SessionFactory sf;

	@GetMapping("showallRecord")
	public List<CoustomerManagement> getall() {
		Session ss = sf.openSession();
		Criteria criteria = ss.createCriteria(CoustomerManagement.class);
		List<CoustomerManagement> coustomer = criteria.list();
		return coustomer;

	}

	@GetMapping("getAsingleRecord") // default method
	public CoustomerManagement getSingleRecord() {
		Session ss = sf.openSession();

		CoustomerManagement s = ss.get(CoustomerManagement.class, 1);
		return s;
	}

	@PostMapping("insertRecord2")
	public String insert(@RequestBody CoustomerManagement coustomer) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(coustomer);
		tx.commit();
		return "Inserted";
	}

	@PutMapping("updateRecord2")
	public String update(@RequestBody CoustomerManagement coustomer) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.update(coustomer);
		tx.commit();
		return "updated Sucessfully";
	}

	@DeleteMapping("deleteRecordB/{id}") 
	public String deleteEmp(@PathVariable int id,CoustomerManagement cous) {
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.load(cous,id);
		session.delete(cous);
		tr.commit();
		return "Data Deleted Sucessfully !!!";
	}
}
