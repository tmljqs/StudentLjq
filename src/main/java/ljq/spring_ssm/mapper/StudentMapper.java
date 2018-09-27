package ljq.spring_ssm.mapper;

import java.util.List;

import ljq.spring_ssm.modal.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> SelectAllStudent();
}