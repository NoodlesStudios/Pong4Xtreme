package com.game.pong.network;

import java.nio.ByteBuffer;

public class Packet {
    private byte[] byteArray;
    public static final int headerSize = 14;
    public static final int identifierBytes = 4;
    public static final int sizeBytes = 2;
    public static final int tokenBytes = 8;

    private Packet(byte[] bytes){
        byteArray = new byte[bytes.length];
        for (int i=0; i < bytes.length; i++){
            byteArray[i] = bytes[i];
        }
    }

    public boolean setID(byte[] identifier){
        if (identifier.length != identifierBytes){
            return false;
        } else {
            for (int i=0; i < identifier.length; i++){
                byteArray[i] = identifier[i];
            }
            return true;
        }
    }

    public boolean setSize(byte[] size){
        if (size.length != sizeBytes){
            return false;
        } else {
            for (int i=0; i < size.length; i++){
                byteArray[identifierBytes + i] = size[i];
            }
            return true;
        }
    }

    public boolean setToken(byte[] tokenValue){
        if (tokenValue.length != tokenBytes){
            return false;
        } else {
            for (int i=0; i < tokenValue.length; i++){
                byteArray[identifierBytes + sizeBytes + i] = tokenValue[i];
            }
            return true;
        }
    }

    public static Packet parse(ByteBuffer byteBuffer){
        if (byteBuffer == null){
            throw new NullPointerException();
        }
        byte[] byteBufferArray = byteBuffer.array();
        if (byteBufferArray.length < headerSize){
            throw new IllegalArgumentException();
        }
        return new Packet(byteBufferArray);
    }
    public short size(){
        byte[] sizeBytes = new byte[2];
        for (int i=identifierBytes; i < identifierBytes + this.sizeBytes; i++){
            sizeBytes[i - identifierBytes] = byteArray[i];
        }
        short size = (short) sizeBytes[0];
        size = (short)((size << 8) | sizeBytes[1]);
        return size; //TODO
    }
}
