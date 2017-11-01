package com.vesnin.train;

public class TrainCar {
    protected int light; //0-off 1-on
    protected int nextCar;
    protected int prevCar;
    protected int carNumber;

    int GetCurCarLight() {
        return light;
    }

    int GetCarNumber() {
        return carNumber;
    }

    int GetNextCar() {
        return nextCar;
    }

    int GetPrevCar() {
        return prevCar;
    }

    int SetOnCarLight() {
        light = 1;
        return light;
    }

    int SetOffCarLight() {
        light = 0;
        return light;
    }
}
