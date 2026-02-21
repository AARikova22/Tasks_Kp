public class Order {
    private String food;
    private int num;

    public Order(String food, int num) {
        this.food = food;
        this.num = num;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
