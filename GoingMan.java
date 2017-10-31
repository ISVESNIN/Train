package com.vesnin.train;

public class GoingMan {
    public static void main(String[] args) {
        int step=0;
        Train curTrain = new Train();
        curTrain.newTrain();

        while (step<=100) {
            curTrain.SetOnCarLight();
            curTrain.GetNextCarLight();
            step++;
        }

    }
}
