package racingcar;

import java.util.Random;

class RacingGame {
    private final Cars cars = new Cars();
    private int totalRound;

    // TODO: 차후 규칙은 인터페이스로 만들고, 구체적인 규칙은 enum으로 바꾼다.
    private final static int FORWARD_CRITERION = 4;
    private final static int BOUNDARY_ZERO_TO_NINE = 10;
    private final static Random RANDOM = new Random();

    RacingGame(String[] carNames, int totalRound) {
        addCars(carNames);
        this.totalRound = totalRound;
    }

    private void addCars(String[] carNames) {
        for(String carName : carNames){
            cars.addCar(new Car(carName));
        }
    }

    Cars playOneRound() {
        for (Car car : cars) {
            car.randomForward(isMove());
        }
        return cars;
    }

    int getTotalRound() {
        return totalRound;
    }

    private boolean isMove() {
        return (RANDOM.nextInt(BOUNDARY_ZERO_TO_NINE) >= FORWARD_CRITERION);
    }
}
