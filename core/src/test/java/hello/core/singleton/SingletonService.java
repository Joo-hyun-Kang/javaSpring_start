package hello.core.singleton;

public class SingletonService {

    //static（スタティック）の領域にインスタンスを一つだけ生成しておく
    private static final SingletonService instance = new SingletonService();

    //インスタスが必要な場合、getInstanceを利用してインスタンスが返る
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}

    public void logic() {
        System.out.println("シングルトンオブジェクトロージックの呼び出す");
    }
}
