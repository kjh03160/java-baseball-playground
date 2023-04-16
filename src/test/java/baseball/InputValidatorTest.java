package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
	@ParameterizedTest
	@CsvSource(value = {
		"123:3",
		"333:3",
		"928:3",
		"98:2",
	}, delimiter = ':')
	@DisplayName("입력한 문자가 정상이면 그대로 종료한다")
	public void checkInputTest(String input, int digit) {
		InputValidator.checkInput(input, digit);
	}

	@ParameterizedTest
	@CsvSource(value = {
		"1233:3",
		"33:1",
		"9:4",
		"\"\" :1",
	}, delimiter = ':')
	@DisplayName("입력한 문자가 n자리가 아닌경우 예외를 던진다.")
	public void checkInputLength(String input, int digit) {
		assertThatThrownBy(() -> InputValidator.checkInput(input, digit))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("you should write 3 digits number!");
	}

	@ParameterizedTest
	@CsvSource(value = {
		"102:3",
		"abc:3",
		"ㄱㄴㄷ:3",
		"1-3:3",
	},delimiter = ':')
	@DisplayName("입력한 문자가 숫자가 아니거나 범위를 벗어난 경우 예외를 던진다.")
	public void checkIsNumber(String input, int digit) {
		assertThatThrownBy(() -> InputValidator.checkInput(input, digit))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("you should write number!");
	}
}
