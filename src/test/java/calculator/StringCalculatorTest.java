package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();
    int result;

    int strCalc(String formula) {
        String[] arr = formula.split(" ");
        return stringCalculator.calculate(arr);
    }

    @Test
    void 더하기() {
        result = strCalc("1 + 1");
        assertThat(result).isEqualTo(2);

        result = strCalc("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 빼기() {
        result = strCalc("1 - 1");
        assertThat(result).isEqualTo(0);

        result = strCalc("70 - 53");
        assertThat(result).isEqualTo(17);
    }

    @Test
    void 곱하기() {
        result = strCalc("1 * 1");
        assertThat(result).isEqualTo(1);

        result = strCalc("12 * 12");
        assertThat(result).isEqualTo(144);
    }

    @Test
    void 나누기() {
        result = strCalc("10 / 5");
        assertThat(result).isEqualTo(2);

        result = strCalc("12 / 4");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 복합계산() {
        result = strCalc("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);

        result = strCalc("3 + 7 / 2 * 5");
        assertThat(result).isEqualTo(25);

        result = strCalc("100 / 4 * 3 + 3");
        assertThat(result).isEqualTo(78);

        result = strCalc("9 - 7 * 1 - 2");
        assertThat(result).isEqualTo(0);
    }

}
