package ljq.spring_ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ljq.spring_ssm.service.StudentService;

@Controller
public class StudentController {
	private static final String AJAXCHERT="text/html; charset=UTF-8";
	@Autowired
	private StudentService ss;
	
	@RequestMapping("/inserte.do")//����ѧ��
	public String inserteStudent(HttpServletRequest request,String name,String sex,String age) {
		request.setAttribute("result", ss.inserteStudent(name, sex, age));
		return "/select.do";
	}
	@RequestMapping("/select.do")//��ѯѧ��
	public String selectALL(HttpServletRequest request) {
		 request.setAttribute("result", ss.selectAllStudent());
		 return"/index.jsp";
	}
	@RequestMapping("/removeStudent.do")//ɾ��ѧ��
	public String removeStudent(HttpServletRequest request,String studentId) {
		request.setAttribute("result",ss.doremoveStudent(studentId));
		return "select.do";
	}
	@RequestMapping(value="/ajaxinsert.do",produces=AJAXCHERT)//ajax�������ѧ��
	public @ResponseBody String AjaxInsertStudent(String name,String sex,String age) {
		return ss.inserteStudent(name, sex, age);
	}
	@RequestMapping(value="/ajaxselect.do",produces=AJAXCHERT)//ajax�����ѯѧ����Ϣ
	public @ResponseBody String AjaxSelectStudent() {
		return ss.getStudentJson();
	}
	@RequestMapping(value="/ajaxdelete.do",produces=AJAXCHERT)//ajaxɾ��ѧ��
	public @ResponseBody String AjaxDeleteStudent(String studentId) {
		return ss.doremoveStudent(studentId);
	}
	public StudentService getSs() {
		return ss;
	}

	public void setSs(StudentService ss) {
		this.ss = ss;
	}
}
