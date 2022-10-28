 package com.training.galaxe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.training.galaxe.config.HibernateUtil;
import com.training.galaxe.model.Contract_Employee;
import com.training.galaxe.model.Employee;
import com.training.galaxe.model.Regular_Employee;

public class EmployeeClient {

	public EmployeeClient() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setName("Pawan");
		employee.setMobile("12712127126");
		
		Regular_Employee regular_Employee = new Regular_Employee();
		regular_Employee.setName("Levin");
		regular_Employee.setMobile("12187212");
		regular_Employee.setSalary(31000);
		regular_Employee.setBonus(9000);
		
		Contract_Employee contract_Employee = new Contract_Employee();
		contract_Employee.setName("Tufail");
		contract_Employee.setMobile("128127612612");
		contract_Employee.setPay_per_hour(3000);
		contract_Employee.setContract_duration("148");
		
		session.save(employee);
		session.save(regular_Employee);
		session.save(contract_Employee);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Done");
	}
}

  