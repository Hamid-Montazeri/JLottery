package ir.mapsa.jlottery.jlottery.enums;

public enum EPrizeLevel {

    /**
     * each level has its own coefficient
     */
    A(20),
    B(15),
    C(10),
    D(5);

    private Integer value;

    EPrizeLevel(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
