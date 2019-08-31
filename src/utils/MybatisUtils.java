package utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.InputStream;

public class MybatisUtils {

    private static final SqlSessionFactory sessionFactory;

    static {
        //1.SqlSessionFactoryBuilder 加载配置文件，创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //String resource = "SqlMappingConfig.xml";
        //2.加载SqlMappingConfig.xml配置文件
        InputStream inputStream = Resources.class.getResourceAsStream("/SqlMappingConfig.xml");
        //3.获取session工厂，创建SqlSessionFactory对象
        sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }
    public static SqlSession openSession(){
        return sessionFactory.openSession();
    }

}
