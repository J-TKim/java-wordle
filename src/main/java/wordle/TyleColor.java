package wordle;

public enum TyleColor {
    CORRECT("🟩"),
    WRONG_LOCATION("🟨"),
    NOT_EXIST("⬜");

    private final String symbol;

    TyleColor(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
