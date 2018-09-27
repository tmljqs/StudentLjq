package ljq.spring_ssm.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ljq.spring_ssm.mapper.StudentMapper;
import ljq.spring_ssm.modal.Student;
import ljq.spring_ssm.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	private static final String SUCCESS="SUCCESS";
	private static final String ERROR="ERROR";
	@Autowired
	private StudentMapper sm;
	@Autowired
	private Gson json;
	@Override
	public String inserteStudent(String name, String sex, String age) {
		// TODO Auto-generated method stub
		Student stu = new Student();
		stu.setStudentId(UUID.randomUUID().toString());
		stu.setStudentName(name);
		stu.setStudentSex(sex);
		stu.setStudentAge(age);
		try {
			return sm.insert(stu)>0?SUCCESS:ERROR;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public StudentMapper getSm() {
		return sm;
	}
	public void setSm(StudentMapper sm) {
		this.sm = sm;
	}
	@Override
	public List<Student> selectAllStudent() {
		// TODO Auto-generated method stub
		return sm.SelectAllStudent();
	}
	@Override
	public String doremoveStudent(String studentId) {
		// TODO Auto-generated method stub
		try {
			sm.deleteByPrimaryKey(studentId);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
		} 
		 return ERROR;
	}
	@Override
	public String getStudentJson() {
		// TODO Auto-generated method stub
		
		return json.toJson(selectAllStudent());
	}
	
}
