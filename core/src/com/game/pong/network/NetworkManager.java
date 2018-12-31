package com.game.pong.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

import java.io.IOException;

public class NetworkManager {
    private static final String ADDRESS = "127.0.0.1";
    private static final int TCP_PORT = 8081;
    private static final int UDP_PORT = 8082;

    private Client client;

    public NetworkManager() {

    }

    public boolean connect() throws IOException {
        client = new Client();
        client.start();
        client.connect(5000, ADDRESS, TCP_PORT, UDP_PORT);

        Kryo kryo = client.getKryo();
        kryo.register(TestPacket.class);

        return isConnected();
    }

    public boolean isConnected() {
        return client.isConnected();
    }


    public void sendPacket() {
        TestPacket request = new TestPacket();
        request.stuff = "Here is the request";
        client.sendTCP(request);
    }
}
