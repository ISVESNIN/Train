package com.vesnin.train;

public class GoingMan {
    public static void main(String[] args) {
        int step=0;
        Train curTrain = new Train();
        curTrain.newTrain();
        TrainCar curTrainCar = new TrainCar();

        while (step<=100) {
            curTrainCar = curTrain.getCurCar();
            System.out.println("step "
                    + step
                    + " Switch "
                    + curTrainCar.GetCurCarLight()
                    + "->"
                    + curTrainCar.SetOnCarLight()
                    + " Car "
                    + curTrainCar.GetCarNumber());
            curTrainCar = curTrain.getNextCar();
            step++;
        }

    }
}
