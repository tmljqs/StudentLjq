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
	
	@RequestMapping("/inserte.do")//新增学生
	public String inserteStudent(HttpServletRequest request,String name,String sex,String age) {
		request.setAttribute("result", ss.inserteStudent(name, sex, age));
		return "/select.do";
	}
	@RequestMapping("/select.do")//查询学生
	public String selectALL(HttpServletRequest request) {
		 request.setAttribute("result", ss.selectAllStudent());
		 return"/index.jsp";
	}
	@RequestMapping("/removeStudent.do")//删除学生
	public String removeStudent(HttpServletRequest request,String studentId) {
		request.setAttribute("result",ss.doremoveStudent(studentId));
		return "select.do";
	}
	@RequestMapping(value="/ajaxinsert.do",produces=AJAXCHERT)//ajax请求添加学生
	public @ResponseBody String AjaxInsertStudent(String name,String sex,String age) {
		return ss.inserteStudent(name, sex, age);
	}
	@RequestMapping(value="/ajaxselect.do",produces=AJAXCHERT)//ajax请求查询学生信息
	public @ResponseBody String AjaxSelectStudent() {
		return ss.getStudentJson();
	}
	@RequestMapping(value="/ajaxdelete.do",produces=AJAXCHERT)//ajax删除学生
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
