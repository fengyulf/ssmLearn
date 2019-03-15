//package sockect;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈测试1〉
// *
// * @author fy
// * @create 2019/2/25
// */
//public class SocketTest {
//
//    private static Logger logger = LoggerFactory.getLogger(SocketTest.class);
//
//    public void test(){
//        String body = getXmlInfo();
//        logger.info("数据内容：" + body);
//
//        //3.发送数据
//        Socket socket = null;
//        OutputStream outputStream = null;
//        InputStream inputStream = null;
//        BufferedReader br = null;
//        try {
//            //建立TCP连接
//            socket = new Socket("localhost", 8080);
//            logger.info("创建连接成功");
//            //写入数据
//            outputStream = socket.getOutputStream();
//            outputStream.write(body.getBytes("UTF-8"));
//            logger.info("发送数据结束");
//
//            //获取响应
//            inputStream = socket.getInputStream();
//            br = new BufferedReader(new InputStreamReader(inputStream));
//            String info=null;
//            while((info=br.readLine())!=null){
//                logger.info(info);
//            }
//
//            br.close();
//            inputStream.close();
//            outputStream.close();
//            socket.close();
//            logger.info("断开连接");
//        } catch (UnknownHostException e1) {
//            logger.info("创建连接失败");
//        } catch (IOException e1) {
//            logger.info("发送数据失败");
//        }
//    }
//
//    //生成xml格式数据
//    private String getXmlInfo() {
//        Document doc = DocumentHelper.createDocument();
//        Element root = doc.addElement("root");
//        Element data = root.addElement("data");
//        Element meter = data.addElement("name");
//        meter.setText("test");
//        return doc.asXML();
//    }
//
//    public static void main(String[] args) {
//        new SocketTest().test();
//    }
//
//
//}
