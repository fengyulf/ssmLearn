package sockect;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2019/2/25
 */
public class SocketClientTest {
    private static Logger logger = LoggerFactory.getLogger(SocketClientTest.class);

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        String body = getXmlInfo();
        System.out.println("数据内容：" + body);
//        logger.info("数据内容：" + body);

        //3.发送数据
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedReader br = null;
        try {
            //建立TCP连接
            socket = new Socket("10.23.1.97", 9999);
            logger.info("创建连接成功");
            System.out.println("创建连接成功");
            //写入数据
            outputStream = socket.getOutputStream();
            outputStream.write(body.getBytes("UTF-8"));
//            outputStream.flush();
            logger.info("发送数据结束");
            System.out.println("发送数据结束");

            //获取响应
            inputStream = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            String info=null;
            while((info=br.readLine())!=null){
                logger.info(info);
            }

            br.close();
            inputStream.close();
            outputStream.close();
            socket.close();
            logger.info("断开连接");
            System.out.println("断开连接");
        } catch (UnknownHostException e1) {
            logger.info("创建连接失败");
            System.out.println("创建连接失败");
        } catch (IOException e1) {
            logger.info("发送数据失败");
            System.out.println("发送数据失败");
        }
    }

    //生成xml格式数据
    private static String getXmlInfo() {
        org.dom4j.Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("root");
        Element data = root.addElement("data");
        Element meter = data.addElement("name");
        meter.setText("test");
        return doc.asXML();
    }









//    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {
//        System.out.println("client.........");
//        Socket socket = null;
//        InetAddress inetAddress = InetAddress.getByName("10.23.1.97");
//        int serverPort = 9999;
//        if (inetAddress.isReachable(5000)) {
//            socket = new Socket(inetAddress, serverPort);
//
//            //封装数据写给服务器端
//            OutputStream outputStream = socket.getOutputStream();
//            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//
//            //转换xml
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(getXmlInfo());
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            transformer.transform(source, new StreamResult(bos));
//            String result = bos.toString();
//
//            //写数据
//            dataOutputStream.writeUTF(result);
//            //  socket.shutdownOutput();
//            // 4.获取输入流，并读取服务器端的响应信息
//            // 4.关闭资源
//            //读
//            InputStream is = socket.getInputStream();
//            DataInputStream in = new DataInputStream(is);
//            String data = in.readUTF();
//            DOM(data);
//            in.close();
//            is.close();
//            bos.close();
//            dataOutputStream.flush();
//            dataOutputStream.close();
//            socket.close();
//        }
//    }
//
////    //dom解析
////    public static void DOM(String data) {
////        try {
////            //遍历xml获取内容
////            byte[] b = data.getBytes();
////            InputStream inp = new ByteArrayInputStream(b);
////            DocumentBuilderFactory factory = DocumentBuilderFactory
////                    .newInstance();
////            DocumentBuilder builder = factory.newDocumentBuilder();
////            Document doc = builder.parse(inp);
//////            NodeList nl = doc.getElementsByTagName("packet");
//////			System.out.println(nl.getLength());
//////            for (int i = 0; i < nl.getLength(); i++) {
////            System.out.println("RET_CODE:  "
////                    + doc.getElementsByTagName("RET_CODE").item(0)
////                    .getFirstChild().getNodeValue());
////            System.out.println("RET_RMK:  "
////                    + doc.getElementsByTagName("RET_RMK").item(0)
////                    .getFirstChild().getNodeValue());
//////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//
//    //生成xml格式数据
//    private static Document getXmlInfo() throws ParserConfigurationException {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//        Document document = documentBuilder.newDocument();
//        document.add
//
////        Document doc = DocumentHelper.createDocument();
////
////        org.dom4j.Element root = doc.addElement("root");
////        org.dom4j.Element data = root.addElement("data");
////        org.dom4j.Element meter = data.addElement("name");
////        meter.setText("test");
//        return doc;
//    }
}
