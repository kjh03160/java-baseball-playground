package study.stringCalculator;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
	PLUS("+", Integer::sum),
	MINUS("-", (a, b) -> a - b),
	MULTIPLE("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> {
		if (b == 0) {
			throw new IllegalArgumentException("cannot divide by zero");
		}
		return a / b;
	}),
	UNKNOWN("unknown", (a, b) -> 0);

	private final String operator;
	private final BiFunction<Integer, Integer, Integer> function;

	private static final Map<String, Operator> operators =
		Collections.unmodifiableMap(Stream.of(values())
			.collect(Collectors.toMap(Operator::getOperator, Function.identity())));

	public static Operator find(String description) {
		return Optional.ofNullable(operators.get(description)).orElse(UNKNOWN);
	}

	public int execute(int a, int b) {
		return function.apply(a, b);
	}

	Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
		this.operator = operator;
		this.function = function;
	}

	private String getOperator() {
		return this.operator;
	}
}
