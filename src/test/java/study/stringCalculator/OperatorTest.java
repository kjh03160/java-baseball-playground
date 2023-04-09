package study.stringCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class OperatorTest {
	@ParameterizedTest
	@CsvSource(value = {
		"1:2:3",
		"0:0:0",
	}, delimiter = ':')
	@DisplayName("더하기 테스트")
	public void plusTest(int a, int b, int expected) {
		Operator plus = Operator.PLUS;
		int result = plus.execute(a, b);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1:2:-1",
		"0:0:0",
	}, delimiter = ':')
	@DisplayName("빼기 테스트")
	public void minusTest(int a, int b, int expected) {
		Operator minus = Operator.MINUS;
		int result = minus.execute(a, b);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1:2:2",
		"1:0:0",
	}, delimiter = ':')
	@DisplayName("곱하기 테스트")
	public void multipleTest(int a, int b, int expected) {
		Operator multiple = Operator.MULTIPLE;
		int result = multiple.execute(a, b);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"2:2:1",
		"1:2:0",
	}, delimiter = ':')
	@DisplayName("나누기 테스트")
	public void divideTest(int a, int b, int expected) {
		Operator divide = Operator.DIVIDE;
		int result = divide.execute(a, b);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"2:0",
		"0:0"
	}, delimiter = ':')
	@DisplayName("0으로 나누면 에러를 내뱉는다.")
	public void divideZeroTest(int a, int b) {
		Operator divide = Operator.DIVIDE;
		assertThatThrownBy(() -> divide.execute(a, b))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("cannot divide by zero");
	}
}
