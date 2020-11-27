package common;

public class balance {
    public String[] getMoney() {
        return money;
    }

    public void setMoney(String[] money) {
        common.balance.money = money;
    }

    public int[] getBalance() {
        return balance;
    }

    public void setBalance(int[] balance) {
        common.balance.balance = balance;
    }

    private static String[] money = {"50元", "20元", "10元", "5元", "1元", "1元硬币", "5角硬币", "1角硬币"};
    private static int[] balance = {100, 100, 100, 100, 100, 500, 500, 500};

}
