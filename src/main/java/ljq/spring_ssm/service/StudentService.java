package ljq.spring_ssm.service;

import java.util.List;

import ljq.spring_ssm.modal.Student;

public interface StudentService {
	/**
	 * �������
	 * */
	String inserteStudent(String name,String sex,String age);
	/*
	 * ��ѯ���ݲ�����ʾ��JSP��
	 * */
	List<Student> selectAllStudent();
	/*
	 * ɾ��ĳ������
	 * */
	String doremoveStudent(String studentId);
	
	/*
	 * ��Ajax�����������
	 * */
	//void inserteAjaxStudent(HttpServletRequest request,String name,String sex,String age);
	/*
	 * ��Ajax��ѯ��ö���
	 * */
	String getStudentJson();
}
