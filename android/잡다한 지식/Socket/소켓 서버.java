
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService extends Service {
    private ServerSocket serverSocket;

    @Override
    public void onCreate() {
        super.onCreate();
        ServerThread thread = new ServerThread();
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        try {
            serverSocket.close();
        } catch (Exception e) {
            Log.d("ServerSocket", "에러");
        }
        super.onDestroy();
    }

    class ServerThread extends Thread{
        public void run(){
            //서버 실행
            int port = 5001;
            try{
                serverSocket = new ServerSocket(port);
                Log.d("ServerThread", "서버가 실행됨.");

                while (true){
                    // 대기를 하다가 클라이언트가 접속하면 소켓이라고 하는 객체가 return됨
                    Socket socket = serverSocket.accept();

                    // 받은 데이터를 뿌려줌
                    ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
                    Object input = instream.readObject();
                    Log.d("ServerThread", "input: "+input);

                    // 클라이언트로 데이터 전송
                    ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                    outstream.writeObject(input + "from server.");
                    outstream.flush();
                    Log.d("ServerThread","output");

                    // 소켓 종료
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");

    }
}
