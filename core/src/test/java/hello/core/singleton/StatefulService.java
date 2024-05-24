package hello.core.singleton;

public class StatefulService {
    private int price; //状態を維持してる変数

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //更新のコード
    }

    public int getPrice() {
        return price;
    }
}
