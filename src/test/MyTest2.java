package test;

import domain.Student;
import domain.Teacher;
import mapper.StudentMapper;
import mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.List;

public class MyTest2 {

    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeachers = teacherMapper.getAllTeacher();
        for (Teacher teacher : allTeachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherWithId(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.openSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Teacher teacher = new Teacher();
        teacher.setTeacher_name("周老师");

        Student student1 = new Student();
        student1.setStu_name("周董1号");

        Student student2 = new Student();
        student2.setStu_name("周董2号");
        teacher.getStudents().add(student1);
        teacher.getStudents().add(student2);

        /*保存老师*/
        teacherMapper.insertTeacher(teacher);
        /*保存学生*/
        studentMapper.insertStudent(student1);
        studentMapper.insertStudent(student2);

        /*插入关系表*/
        /*遍历老师的所有学生，有几个学生就insert几次*/
        for (Student student : teacher.getStudents() ) {
            teacherMapper.insertRelation(student.getStu_id(),teacher.getTeacher_id());
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
