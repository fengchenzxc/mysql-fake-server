package me.n1ar4.fake.rpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import me.n1ar4.fake.rpc.RPCNull;
import me.n1ar4.fake.rpc.RPCPort;
import me.n1ar4.fake.rpc.RPCResp;
import me.n1ar4.fake.rpc.RPCStartGrpc;

public class GRPCStartClient {
    private static final String host = "192.168.197.138";
    private static final int serverPort = 9999;

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();
        try {
            RPCStartGrpc.RPCStartBlockingStub startStub = RPCStartGrpc.newBlockingStub(managedChannel);
            RPCResp resp = startStub.start(RPCNull.newBuilder().build());
            System.out.println(resp.getStatus());
            System.out.println(resp.getPort());
        } finally {
            managedChannel.shutdown();
        }
    }
}
