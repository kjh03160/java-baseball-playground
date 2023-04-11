package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
	@ParameterizedTest
	@ValueSource(strings = {
		"123",
		"333",
		"928",
	})
	@DisplayName("입력한 문자가 정상이면 그대로 종료한다")
	public void checkInputTest(String input) {
		InputValidator.checkInput(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {
		"1233",
		"33",
		"9",
		"",
	})
	@DisplayName("입력한 문자가 3자리가 아닌경우 예외를 던진다.")
	public void checkInputLength(String input) {
		assertThatThrownBy(() -> InputValidator.checkInput(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("you should write 3 digits number!");
	}

	@ParameterizedTest
	@ValueSource(strings = {
		"102",
		"abc",
		"ㄱㄴㄷ",
		"1-3",
	})
	@DisplayName("입력한 문자가 숫자가 아니거나 범위를 벗어난 경우 예외를 던진다.")
	public void checkIsNumber(String input) {
		assertThatThrownBy(() -> InputValidator.checkInput(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("you should write number!");
	}
}
