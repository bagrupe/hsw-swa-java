package de.hsw.customer;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    // mvn -DskipTests package exec:java -Dexec.mainClass=de.hsw.customer.Client
    public static void main(String[] args) throws Exception {
        // Channel is the abstraction to connect to a service endpoint
        // Let's use plaintext communication because we don't have certs
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        // It is up to the client to determine whether to block the call
        // Here we create a blocking stub, but an async stub,
        // or an async stub with Future are always possible.
        CustomerServiceGrpc.CustomerServiceBlockingStub stub = CustomerServiceGrpc.newBlockingStub(channel);
        Customer request = Customer.newBuilder()
                .setName("Ray")
                .setEmail("Ray@msft.com")
                .build();

        // Finally, make the call using the stub
        Customer response = stub.search(request);

        System.out.println(response);

        // A Channel should be shutdown before stopping the process.
        channel.shutdownNow();
    }
}
