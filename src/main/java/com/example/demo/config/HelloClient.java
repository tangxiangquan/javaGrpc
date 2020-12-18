package com.example.demo.config;

import go.rpc.srv.hello.HelloGrpc;
import go.rpc.srv.hello.HelloOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xiangquan.tang
 * @date 2020/12/18 9:12
 */
@Component
public class HelloClient {

    private HelloGrpc.HelloBlockingStub helloWorldServiceBlockingStubForGo;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannelForGo = ManagedChannelBuilder
                .forAddress("127.0.0.1", 8081).usePlaintext().build();
        helloWorldServiceBlockingStubForGo =
                HelloGrpc.newBlockingStub(managedChannelForGo);
    }


    public String sayHello(String name) {
        HelloOuterClass.Say say = HelloOuterClass.Say.newBuilder().setName(name).build();
        HelloOuterClass.Say val = helloWorldServiceBlockingStubForGo.sayHello(say);
        return val.getName();
    }
}
