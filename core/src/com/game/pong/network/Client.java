package com.game.pong.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {
    private static final String ADDRESS = "127.0.0.1";
    private static final int PORT = 8080;
    private static final int BUFFER_CAPACITY = 48;

    DatagramChannel channel;

    public Client() {

    }

    public boolean connect() throws IOException {
        channel = DatagramChannel.open();
        //noinspection Since15
        //channel.bind(new InetSocketAddress(ADDRESS, PORT));
        channel.connect(new InetSocketAddress(ADDRESS, PORT));
        return isConnected();
    }

    public boolean isConnected() {
        return channel.isConnected();
    }

    public Packet receivePacket() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
        buffer.clear();

        channel.receive(buffer);

//        return new Packet();
        return Packet.parse(buffer);
    }

    public Packet sendPacket(Packet packet) {
        
    }
}
