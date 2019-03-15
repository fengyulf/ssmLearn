package sockect;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author fy
 * @create 2019/2/25
 */
public class SocketServerTest {
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        System.out.println("server.......");
        ServerSocket serverSocket = null;
        Socket sk = null;
        serverSocket = new ServerSocket(9999);
        while (true) {
            //阻塞获取请求
            sk = serverSocket.accept();

            InputStream inputStream = sk.getInputStream();
            byte[] by=new byte[1024];
            while (inputStream.read(by)!=0){
                System.out.println(new String(by));
            }


            OutputStream outputStream = sk.getOutputStream();

            String s="419<Cartoon><Message id=\"dbc4954194e0365b9c32b5f9363f7994\"><CSReq id=\"CSVReq\"><date>20130313 10:17:06</date><instId>CIBCC</instId><mobilePhone>15526672850</mobilePhone><bankCardNo>6229010310147104</bankCardNo><accountName>赵芳</accountName><bankCardType>C</bankCardType><version>1.1.0</version><certificateNo>W0101</certificateNo><certificateType>6</certificateType></CSReq><Signature>AAB9041</Signature></Message></Cartoon>\n";
            outputStream.write(s.getBytes("UTF-8"));

//            InputStream inputStream = sk.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//            String info;
//
//            StringBuffer resp = new StringBuffer();
//            while((info=br.readLine())!=null){
//                resp.append(info);
//            }
//            System.out.println(resp);



            /*InputStream inputStream = sk.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info=null;

            StringBuffer resp = new StringBuffer();
            while((info=bufferedReader.readLine())!=null){
                resp.append(info);
            }
            System.out.println(resp);*/


//            //读客户端传来的数据
//            DataInputStream in = new DataInputStream(inputStream);
//            String data = in.readUTF();
//			System.out.println("接收到的数据:" + data);
            //对客户端信息的校验，或者做其他的过滤
//            if (data.length() < 5) {
//                //数据长度小于5，则不需要解析客户端的数据，直接回传报文，RET_CODE为1111
//                OutputStream outputStream = sk.getOutputStream();
//                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//
//                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//                DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//                Document document = documentBuilder.newDocument();
//                Element parent = document.createElement("packet");
//                document.appendChild(parent);
//
//                Element SYS_ID = document.createElement("SYS_ID");
//                SYS_ID.setTextContent("ZFB2C");
////          SYS_ID.appendChild(document.createTextNode("ZFB2C"));
//                Element TRANS_CODE = document.createElement("TRANS_CODE");
//                TRANS_CODE.setTextContent("TOKEN");
////          TRANS_CODE.appendChild(document.createTextNode("TOKEN"));
//                Element ACCESS_TOKEN = document.createElement("ACCESS_TOKEN");
////          ACCESS_TOKEN.appendChild(document.createTextNode("skdlajtfoiewjflkdsajflkdsajlkfdsajfljdsalkf"));
//                ACCESS_TOKEN.setTextContent("skdlajtfoiewjflkdsajflkdsajlkfdsajfljdsalkf");
//                Element RET_CODE = document.createElement("RET_CODE");
////          RET_CODE.appendChild(document.createTextNode("1111"));
//                RET_CODE.setTextContent("1111");
//                Element RET_RMK = document.createElement("RET_RMK");
////          RET_RMK.appendChild(document.createTextNode("交易成功"));
//                RET_RMK.setTextContent("交易成功");
//                parent.appendChild(SYS_ID);
//                parent.appendChild(TRANS_CODE);
//                parent.appendChild(ACCESS_TOKEN);
//                parent.appendChild(RET_CODE);
//                parent.appendChild(RET_RMK);
//
//                //xml转换，转为字符串
//                TransformerFactory transformerFactory = TransformerFactory.newInstance();
//                Transformer transformer = transformerFactory.newTransformer();
//
//                DOMSource source = new DOMSource(document);
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                transformer.transform(source, new StreamResult(bos));
//                String result = bos.toString();
//
//                //写到客户端
//                dataOutputStream.writeUTF(result);
//                //把dataOutputStream数据flush掉，全部传到客户端
//                dataOutputStream.flush();
//                //关闭流
//                dataOutputStream.close();
//                outputStream.close();
//            } else {
//                //解析客户端的数据，回传报文，RET_CODE为0000
//                DOM(data);
//                OutputStream outputStream = sk.getOutputStream();
//                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//
//                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//                DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//                Document document = documentBuilder.newDocument();
//                document.setXmlStandalone(true);
//                Element parent = document.createElement("packet");
//                document.appendChild(parent);
//
//                Element SYS_ID = document.createElement("SYS_ID");
//                SYS_ID.setTextContent("ZFB2C");
////          SYS_ID.appendChild(document.createTextNode("ZFB2C"));
//                Element TRANS_CODE = document.createElement("TRANS_CODE");
//                TRANS_CODE.setTextContent("TOKEN");
////          TRANS_CODE.appendChild(document.createTextNode("TOKEN"));
//                Element ACCESS_TOKEN = document.createElement("ACCESS_TOKEN");
////          ACCESS_TOKEN.appendChild(document.createTextNode("skdlajtfoiewjflkdsajflkdsajlkfdsajfljdsalkf"));
//                ACCESS_TOKEN.setTextContent("skdlajtfoiewjflkdsajflkdsajlkfdsajfljdsalkf");
//                Element RET_CODE = document.createElement("RET_CODE");
////          RET_CODE.appendChild(document.createTextNode("0000"));
//                RET_CODE.setTextContent("0000");
//                Element RET_RMK = document.createElement("RET_RMK");
////          RET_RMK.appendChild(document.createTextNode("交易成功"));
//                RET_RMK.setTextContent("交易成功");
//                parent.appendChild(SYS_ID);
//                parent.appendChild(TRANS_CODE);
//                parent.appendChild(ACCESS_TOKEN);
//                parent.appendChild(RET_CODE);
//                parent.appendChild(RET_RMK);
//
//                //xml转换，转为字符串
//                TransformerFactory transformerFactory = TransformerFactory.newInstance();
//                Transformer transformer = transformerFactory.newTransformer();
//
//                DOMSource source = new DOMSource(document);
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                transformer.transform(source, new StreamResult(bos));
//                String result = bos.toString();
//
//                //写到客户端
//                dataOutputStream.writeUTF(result);
//                //把dataOutputStream数据flush掉，全部传到客户端
//                dataOutputStream.flush();
//                //关闭流
//                dataOutputStream.close();
//                outputStream.close();
//            }
//            in.close();
            inputStream.close();
            sk.close();
        }
    }

    //DOM解析
    public static void DOM(String data) {
        try {
            //遍历xml获取内容
            byte[] b = data.getBytes();
            InputStream inp = new ByteArrayInputStream(b);
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inp);
            NodeList nl = doc.getElementsByTagName("persons");
            //用最外层节点数来遍历
            for (int i = 0; i < nl.getLength(); i++) {
                System.out.println("person:  "
                        + doc.getElementsByTagName("person").item(i)
                        .getFirstChild().getNodeValue());
                System.out.println("name:  "
                        + doc.getElementsByTagName("name").item(i)
                        .getFirstChild().getNodeValue());
                System.out.println("sex:  "
                        + doc.getElementsByTagName("sex").item(i)
                        .getFirstChild().getNodeValue());
                System.out.println("age:  "
                        + doc.getElementsByTagName("age").item(i)
                        .getFirstChild().getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
