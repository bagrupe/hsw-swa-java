package de.hsw.customer;

import io.grpc.stub.StreamObserver;

public class CustomerServiceImpl extends CustomerServiceGrpc.CustomerServiceImplBase {

    @Override
    public void search(Customer request,
            StreamObserver<Customer> responseObserver) {
        // HelloRequest has toString auto-generated.
        System.out.println(request);

        // You must use a builder to construct a new Protobuffer object
        Customer response = Customer.newBuilder().setId(1).setName(request.getName()).setEmail(request.getEmail()).build();

        // Use responseObserver to send a single response back
        responseObserver.onNext(response);

        // When you are done, you must call onCompleted.
        responseObserver.onCompleted();
    }
}