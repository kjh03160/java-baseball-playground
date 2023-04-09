package study.stringCalculator;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	@ParameterizedTest
	@CsvSource(value = {
		"2 + 3 * 4 / 2:10",
		"2 + 6 / 4 - 2:0",
		"3:3",
		"0 / 5:0",
		"-5 - 4 * 2 + 5:-13",
		"+3 + 3 + 3 + 3 + 3 + 3:18"
	}, delimiter = ':')
	public void calculateTest(String input, int expected) {
		Calculator calculator = new Calculator();

		int result = calculator.calculate(input);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("입력 값이 올바르지 않으면 예외가 발생한다.")
	@ValueSource(strings = {
		"1 - -",
		"-",
		"1 - 1 ** 2",
		"+ 3 + 3",
		"0 / 0"
	})
	public void calculateTest2(String input) {
		Calculator calculator = new Calculator();

		assertThatThrownBy(() -> calculator.calculate(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
