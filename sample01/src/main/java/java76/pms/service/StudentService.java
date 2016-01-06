package java76.pms.service;

import java.util.List;

import java76.pms.domain.Student;

public interface StudentService {
	
	 List<Student> getStudentList(
			int pageNo,
			int pageSize, 
			String keyword, 
			String align);

	void register(Student student);
	public void remove(String email);
	public void change(Student student);
	public Student retrieve(String email);
	public Student retrieve(String email, String password);
}
