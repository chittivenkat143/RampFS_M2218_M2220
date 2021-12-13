package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		logger.info(getClass() +":" +employee.toString() + " : Details are saved");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			logger.info(employee.toString() + " : Employee not saved due to Exception" + ":\t" + e.getLocalizedMessage());
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void saveEmployeeData(Employee employee) {
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Employee> getEmployeesData() {
		logger.info(getClass() +":" +"Getting employees..");
		Session session = null;
		List<Employee> empList = new ArrayList<Employee>();
		try {
			session = sessionFactory.openSession();
			empList = session.createQuery("From Employee").list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("Getting employees.." + e.getMessage());
		} finally {
			session.close();
		}
		
		return empList;
	}
	
	@Override
	public Employee getEmployeeById(Integer employeeId) {
		logger.info(getClass() +":" +"Getting employee for " + employeeId);
		Session session = null;
		Employee employee = new Employee();
		try {
			session = sessionFactory.openSession();
			employee = session.find(Employee.class, employeeId);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("Getting employee for " + employeeId + "\t:" + e.getMessage());
		} finally {
			session.close();
		}
		return employee;
	}

	@Override
	public void updateEmployeeData(Employee employee) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteEmployeeData(Integer employeeId) {
		logger.info(getClass() +":" +"Deleting employee " + employeeId);
		Employee emp = new Employee();
		emp.setEmployeeId(employeeId);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(emp);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
			logger.info("Deleting employee " + employeeId + "\t:" + e.getMessage());
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Employee> findEmployeeLike(String likeStr) {
		logger.info(getClass() +":" +"Fetching employees like " + likeStr);
		List<Employee> employees = new ArrayList<Employee>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
			CriteriaQuery<Employee> likeQuery = builder.createQuery(Employee.class);
			Root<Employee> root = likeQuery.from(Employee.class);
			Predicate predicateLike = builder.and(builder.like(root.get("name"), "%" + likeStr + "%"));		
			likeQuery.select(root).where(predicateLike);
			Query<Employee> query = session.createQuery(likeQuery);
			employees = query.getResultList();			
		} catch (Exception e) {
			logger.info("Fetching employees like " + likeStr + ":\t" + e.getLocalizedMessage());
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return employees;
	}

	@Override
	public List<Employee> searchEmployeeData(String searchText) {
		logger.info(getClass() +":" +"Fetching employees like " + searchText);
		List<Employee> results = new ArrayList<>();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteriaLike = session.createCriteria(Employee.class);
			criteriaLike.add(Restrictions.like("name", "%" + searchText + "%"));
			//criteriaLike.add(Restrictions.like("project", "%" + searchText + "%"));
			//criteriaLike.add(Restrictions.like("mailId", "%" + searchText + "%"));
			//criteriaLike.add(Restrictions.like("phoneNo", "%" + searchText + "%"));
			results = criteriaLike.list();
			results.stream().forEach(System.out::println);
		} catch (Exception e) {
			logger.info("Fetching employees like " + searchText + ":\t" + e.getLocalizedMessage());
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return results;
	}

}
