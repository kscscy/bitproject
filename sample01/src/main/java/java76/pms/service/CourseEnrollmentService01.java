package java76.pms.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java76.pms.dao.CourseEnrollmentDao;
import java76.pms.domain.CourseEnrollment;
import java76.pms.domain.Student;

//@Service
public class CourseEnrollmentService01 {

	@Autowired StudentService studentService;
	@Autowired CourseEnrollmentDao enrollDao;
	@Autowired PlatformTransactionManager txManager;
	
	public void enroll(CourseEnrollment enroll) {
		enrollDao.insert(enroll);
	}
	
	public void change(CourseEnrollment enroll) {
		enrollDao.update(enroll);
	}
	
	public void remove(String email) {
		enrollDao.delete(email);
	}
	
	public CourseEnrollment retrieveByEmail (String email) {
		return enrollDao.selectOne(email);
	}
	
	public List<CourseEnrollment> getEnrollmentList() {
		return enrollDao.selectList();
	}

	public void reject(String email) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("status", CourseEnrollment.STATUS_REJECT);
		
		enrollDao.updateForStatus(paramMap);
	}
	
	public void approve(String email) {
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		// => 트랜잭션 이름 설정
		txDef.setName("t1");
		// => 트랜잭션 사용 정책 설정 : 
		//					ex) PROPAGATION_REQUIRED : 필수 사용으로 설정
		txDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		// 트랜잭션 관리자로부터 트랜잭션 상태 정보를 다루는 도구를 얻는다.
		TransactionStatus txStatus = txManager.getTransaction(txDef);
		
		try {
			HashMap<String, Object> paramMap = new HashMap<>();
			paramMap.put("email", email);
			paramMap.put("status", CourseEnrollment.STATUS_APPROVE);
			
			enrollDao.updateForStatus(paramMap);
			
			CourseEnrollment enroll = enrollDao.selectOne(email);
			
			Student student = new Student();
			student.setEmail(enroll.getEmail());
			student.setName(enroll.getName());
			student.setTel(enroll.getTel());
			
			studentService.register(student);
			
		} catch (Exception e) {
			// 트랜잭션에 예외가 발생하면, 트랜잭션에 묶인 작업을 모두 취소한다.
			txManager.rollback(txStatus);
			throw e;
		}
		
	}
}
