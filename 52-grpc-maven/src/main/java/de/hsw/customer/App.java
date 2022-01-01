package de.hsw.customer;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {
    // mvn -DskipTests package exec:java -Dexec.mainClass=de.hsw.customer.App
    public static void main(String[] args) throws Exception {
        // Create a new server to listen on port 8080
        Server server = ServerBuilder.forPort(8080)
                .addService(new CustomerServiceImpl())
                .build();

        // Start the server
        server.start();

        // Server threads are running in the background.
        System.out.println("Server started");
        // Don't exit the main thread. Wait until server is terminated.
        server.awaitTermination();
    }
}
