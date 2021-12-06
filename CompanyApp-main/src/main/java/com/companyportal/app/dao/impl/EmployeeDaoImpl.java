package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.impl.EmployeeServiceImpl;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

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
		Session session = null;
		List<Employee> empList = new ArrayList<Employee>();
		try {
			session = sessionFactory.openSession();
			empList = session.createQuery("From Employee").list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		
		return empList;
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
		// employeeList.removeIf(e -> e.getEmployeeId() == employeeId);
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
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Employee> findEmployeeLike(String likeStr) {
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
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return employees;
	}

	@Override
	public List<Employee> searchEmployeeData(String searchText) {
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
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return results;
	}

}
