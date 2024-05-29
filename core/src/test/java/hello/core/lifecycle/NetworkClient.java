package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//架空のネットワーク接続仮定する
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("コンストラクターを呼び出す, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //サービズの始まりに呼ばれる
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //サービスが終了し呼ばれる
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("初期化メッセージ");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
