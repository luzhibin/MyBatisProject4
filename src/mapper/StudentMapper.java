package mapper;

import domain.Student;

import java.util.List;

public interface StudentMapper {
    //根据老师ID查询学生
    public List<Student> getStuByTeach(Integer id);

    //保存学生
    public void insertStudent(Student student);
}
