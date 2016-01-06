package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.StudentDao;
import java76.pms.domain.Student;
import java76.pms.service.StudentService;

@Service
public class DefaultStudentService implements StudentService{

	@Autowired StudentDao studentDao;
	
	// business layer 에서는 파라미터를 정확히 표기한다.(map이 아닌)
	public List<Student> getStudentList(
			int pageNo,
			int pageSize, 
			String keyword, 
			String align) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("length", pageSize);
		paramMap.put("keyword", keyword);
		paramMap.put("align", align);
		
		return studentDao.selectList(paramMap);
	}

	/*{
		// 지정하지 않으면 default는 REQUIRED
		//Propagation.REQUIRED	// 현재 트랜잭션이 있으면 그 트랜잭션에 종속, 없으면 새로 생성
		//Propagation.REQUIRES_NEW	// 무조건 트랜잭션 새로 생성
		//Propagation.MANDATORY	// 현재 트랜잭션이 있으면 그 트랜잭션에 종속, 없으면 에러
		//Propagation.SUPPORTS	// 현재 트랜잭션이 있으면 그 트랜잭션에 종속, 없으면 없이 실행
		//Propagation.NOT_SUPPORTED	// 이 메서드는 트랜잭션을 지원하지 않음, 없으면 없이 실행
		//Propagation.NEVER	// 현재 트랜잭션이 있으면 에러, 없으면 없이 실행
	}*/
	
	public void register(Student student) {
		studentDao.insert(student);
	}

	public void remove(String email) {
		studentDao.delete(email);
	}

	public void change(Student student) {
		studentDao.update(student);
	}

	public Student retrieve(String email) {
		return studentDao.selectOne(email);
	}

	public Student retrieve(String email, String password) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		
		return studentDao.selectOneByEmailPassword(paramMap);
	}
}
