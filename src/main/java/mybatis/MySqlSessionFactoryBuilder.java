package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import proxyTest.HelloWorldImpl;

import java.io.IOException;
import java.io.InputStream;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2018/11/8
 */
public class MySqlSessionFactoryBuilder {

    public static void main(String[] args) {
//        SqlSessionFactoryBuilder sessionFactoryBuilder= Resources.getResourceAsStream("mybatis-config");
        SqlSessionFactory SqlSessionFactory  =  null ;
        String  resource  ="mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream  =  Resources.getResourceAsStream ( resource) ;
            SqlSessionFactory  = new  SqlSessionFactoryBuilder().build(inputStream) ;
            SqlSession sqlSession = SqlSessionFactory.openSession();
            sqlSession.getMapper(HelloWorldImpl.class);
            System.out.println(SqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
