import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.game.pong.network.TestPacket;

import java.io.IOException;

public class ServerLauncher {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
        server.bind(8081, 8082);

        Kryo kryo = server.getKryo();
        kryo.register(TestPacket.class);

        server.addListener(new Listener() {
            public void received (Connection connection, Object object) {
                if (object instanceof TestPacket) {
                    TestPacket request = (TestPacket)object;
                    System.out.println(request.stuff);

                    TestPacket response = new TestPacket();
                    response.stuff = "Thanks";
                    connection.sendTCP(response);
                }
            }
        });
    }
}
