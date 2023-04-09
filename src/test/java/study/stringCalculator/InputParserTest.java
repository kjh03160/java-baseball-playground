package study.stringCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {
	@ParameterizedTest
	@CsvSource(value = {
		"2 + 3 * 4 / 2:4:3",
		"2 + 6 / 4 - 2:4:3",
		"3:1:0",
		"0 / 5:2:1",
		"-5 - 4 * 2 + 5:4:3",
		"+3 + 3 + 3 + 3 + 3 + 3:6:5"
	}, delimiter = ':')
	@DisplayName("입력값 파싱 테스트")
	public void inputParseTest(String input, int numberCount, int operatorCount) {
		InputParser parser = new InputParser(input);
		for (int i = 0; i < numberCount; i++) {
			assertThat(parser.getNextNumber()).isNotNull();
		}
		for (int i = 0; i < operatorCount; i++) {
			assertThat(parser.getNextOperator()).isNotNull();
		}
	}


	@ParameterizedTest
	@ValueSource(strings = {
		"-",
		"+",
		"/ *",
		""
	})
	@DisplayName("숫자가 없으면 IllegalArgumentException를 던진다.")
	public void noNumbers(String input) {
		assertThatThrownBy(()->new InputParser(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("there is no number");
	}

	@ParameterizedTest
	@ValueSource(strings = {
		"1 ** 3",
		"1 ds 3",
		"1 ++"
	})
	@DisplayName("기호가 올바르지 않으면 IllegalArgumentException를 던진다.")
	public void invalidOperators(String input) {
		assertThatThrownBy(()->new InputParser(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("invalid operator");
	}
}
