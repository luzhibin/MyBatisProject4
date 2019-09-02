package mapper;

import domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    //查询老师，并将对应的学生也查出来
    public List<Teacher> getAllTeacher();

    //查询指定的老师
    public Teacher getTeacherWithId(Integer id);

    //保存老师
    public void insertTeacher(Teacher teacher);

    /*插入关系表*/
    public void insertRelation(@Param("stuId") Integer stuId, @Param("teacherId") Integer teacherId);
}
