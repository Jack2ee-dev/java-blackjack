package domain.card;

import java.util.Arrays;

public enum Symbol {
	ACE("A", 1, 10),
	TWO("2", 2),
	THREE("3", 3),
	FOUR("4", 4),
	FIVE("5", 5),
	SIX("6", 6),
	SEVEN("7", 7),
	EIGHT("8", 8),
	NINE("9", 9),
	TEN("10", 10),
	JACK("J", 10),
	QUEEN("Q", 10),
	KING("K", 10);

	private static final String ILLEGAL_SCORE_VALUE_EXCEPTION_MESSAGE = "올바른 인자가 아닙니다.";
	private static final int DEFAULT_BONUS_SCORE = 0;

	private final String name;
	private final int defaultScore;
	private final int bonusScore;

	Symbol(String name, int defaultScore) {
		this(name, defaultScore, DEFAULT_BONUS_SCORE);
	}

	Symbol(String name, int defaultScore, int bonusScore) {
		this.name = name;
		this.defaultScore = defaultScore;
		this.bonusScore = bonusScore;
	}

	public static Symbol of(Integer num) {
		return Arrays.stream(values())
			.filter(val -> val.defaultScore == num)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ILLEGAL_SCORE_VALUE_EXCEPTION_MESSAGE));
	}

	public String getName() {
		return name;
	}

	public int getDefaultScore() {
		return defaultScore;
	}

	public int getBonusScore() {
		return bonusScore;
	}

	public boolean hasBonusScore() {
		return bonusScore > DEFAULT_BONUS_SCORE;
	}

	public int calculateBonusScore(int score, int comparingScore) {
		if (score + bonusScore <= comparingScore) {
			return bonusScore;
		}
		return DEFAULT_BONUS_SCORE;
	}
}
