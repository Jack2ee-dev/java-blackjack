package domain.card;

import java.util.Objects;

public class Card {
	private final Type type;
	private final Symbol symbol;

	public Card(Type type, Symbol symbol) {
		this.type = Objects.requireNonNull(type);
		this.symbol = Objects.requireNonNull(symbol);
	}

	public static Card of(Type type, Symbol symbol) {
		return new Card(type, symbol);
	}

	public String getSymbolName() {
		return symbol.getName();
	}

	public String getType() {
		return type.getName();
	}

	public int getScore() {
		return symbol.getDefaultScore();
	}

	public Symbol getSymbol() {
		return symbol;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Card that = (Card)object;
		return this.type == that.type &&
			this.symbol == that.symbol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, symbol);
	}

	@Override
	public String toString() {
		return "Card{" +
			"type=" + type +
			", symbol=" + symbol +
			'}';
	}
}
