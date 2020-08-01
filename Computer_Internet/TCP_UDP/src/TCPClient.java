import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        //用户发给服务器的字符
        String sentence;
        //从服务器得到并打算发给用户的标准输出字符
        String modifiedSentence;
        //打字字符进入inFromeUser流
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("hostname",8080);
        //连接在套接字  输出流客户端发送到网路中的字符
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //连接在套接字 inFromServer接受从网络中到来的字符
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromServer.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("From Server: "+modifiedSentence );
        clientSocket.close();
    }
}
