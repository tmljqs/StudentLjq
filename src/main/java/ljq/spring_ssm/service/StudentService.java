package ljq.spring_ssm.service;

import java.util.List;

import ljq.spring_ssm.modal.Student;

public interface StudentService {
	/**
	 * 添加数据
	 * */
	String inserteStudent(String name,String sex,String age);
	/*
	 * 查询数据并且显示到JSP上
	 * */
	List<Student> selectAllStudent();
	/*
	 * 删除某条数据
	 * */
	String doremoveStudent(String studentId);
	
	/*
	 * 用Ajax请求添加数据
	 * */
	//void inserteAjaxStudent(HttpServletRequest request,String name,String sex,String age);
	/*
	 * 用Ajax查询获得对象
	 * */
	String getStudentJson();
}
