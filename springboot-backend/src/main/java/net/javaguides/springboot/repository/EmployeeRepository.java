package net.javaguides.springboot.repository;

 
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.client.result.UpdateResult;

import net.javaguides.springboot.model.Employee;


public interface EmployeeRepository extends MongoRepository<Employee, Long>{
	 
	public static final MongoTemplate mongoTemplate = null;
	
	
	public default   void update(Long id,Employee e) {
		Query q= new Query().addCriteria(Criteria.where("id").is(e.getId()));
		
		Update u=new Update().set("emailId",e.getFirstName());
	 
		UpdateResult ur= mongoTemplate.upsert(q, u, Employee.class);
	  
	}

}
