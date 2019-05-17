package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Cars implements Iterable<Car> {
    private List<Car> carList = new ArrayList<>();

    Cars() {
    }

    Cars(Car... car) {
        for (Car i : car) {
            addCar(i);
        }
    }

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Iterator<Car> iterator() {
        return carList.iterator();
    }

    public int size() {
        return carList.size();
    }

    void addCar(Car car) {
        carList.add(car);
    }

    Cars getWinners() {
        Car maxCar = Collections.max(carList);
        return new Cars(
                carList.stream()
                        .filter(car -> car.compareTo(maxCar) == 0)
                        .collect(Collectors.toList())
        );
    }
}
