package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;
    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setup() {
        cars = new Cars();
        car1 = new Car("a");
        car2 = new Car("b");
        car3 = new Car("c");
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
    }

    @Test
    void 자동차추가() {
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 승리자판명() {
        car1.moveForward();

        car2.moveForward();
        car2.moveForward();

        car3.moveForward();
        car3.moveForward();
        car3.moveForward();

        assertThat(cars.getWinners()).containsOnly(car3);

        car2.moveForward();
        assertThat(cars.getWinners()).containsOnly(car2, car3);
    }
}
