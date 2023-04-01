package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void replace() {
		String actual = "abc".replace("b", "d");
		assertThat(actual).isEqualTo("adc");
	}

	@Test
	void split() {
		String[] splitedStrings = "1,2".split(",");
		assertThat(splitedStrings.length).isEqualTo(2);
		assertThat(splitedStrings).containsExactly("1", "2");

		String[] split = "1".split(",");
		assertThat(split.length).isEqualTo(1);
		assertThat(split).contains("1");
	}

	@Test
	void subString() {
		String input = "(1,2)";
		String substring = input.substring(1, input.length() - 1);
		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt을 활용해 특정 위치 문자를 가져온다.")
	void charAt() {
		String str = "abc";
		char c = str.charAt(0);
		assertThat(c).isEqualTo('a');
		c = str.charAt(1);
		assertThat(c).isEqualTo('b');
		c = str.charAt(2);
		assertThat(c).isEqualTo('c');
	}

	@Test
	@DisplayName("charAt을 활용해 특정 위치 문자를 가져올 때, 위치 값을 벗어나면 exception을 던진다.")
	void charAt2() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				String str = "abc";
				char c = str.charAt(4);
			}).withMessageMatching("String index out of range: \\d+");
	}
}
