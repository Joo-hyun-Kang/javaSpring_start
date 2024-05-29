package hello.core.lifecycle;

//架空のネットワーク接続仮定する
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("コンストラクターを呼び出す, url = " + url);
        connect();
        call("初期化接続メッセージ");
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
}
