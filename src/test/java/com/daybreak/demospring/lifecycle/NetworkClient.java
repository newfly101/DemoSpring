package com.daybreak.demospring.lifecycle;

import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Setter
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메세지");
    }

    private void call(String messege) {
        System.out.println("call : " + url + " message = " + messege);
    }

    private void connect() {
        System.out.println("connect: " + url);
    }

    // 서비스 종료시 호출
    public void disConnect() {
        System.out.println("close " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disConnect();
//    }

    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }
    public void close() {
        System.out.println("NetworkClient.close");
        disConnect();
    }
}
