package com.vesnin.train;

import java.util.Random;

class Train {
    private static TrainCar[] trainArr;
    private static int curCarNumber = 0;

    void newTrain()
    {
        int trainMinLenght = 4;
        int trainMaxLenght = 50;

        Random rn = new Random();
        Random rnLight = new Random();
        int trainCarCount;
        trainCarCount = trainMinLenght + rn.nextInt(trainMaxLenght);
        int i=0;

        trainArr = new TrainCar[trainCarCount];
        while (i < trainCarCount) {
            trainArr[i] = new TrainCar();
            trainArr[i].carNumber = i;

            trainArr[i].light = rnLight.nextInt(2); // 1-on 0-off

            if (i != trainCarCount - 1) {
                trainArr[i].nextCar = i + 1;
            } else {
                trainArr[i].nextCar=trainArr[0].carNumber;
            }
            if (i==0)
            {
                trainArr[i].prevCar = trainCarCount - 1;
            }
            else
            {
                trainArr[i].prevCar=trainArr[i-1].carNumber;
            }
            i++;
        }
        System.out.println("Train created of " + trainCarCount + " Cars");

    }

    TrainCar getCurCar() {
        if (curCarNumber == 0) {
            curCarNumber = 0;
        }
        curCarNumber = trainArr[curCarNumber].GetCarNumber();
        return trainArr[curCarNumber];
    }

    TrainCar getNextCar() {
        if (curCarNumber == 0) {
            curCarNumber = trainArr[0].GetNextCar();
            return trainArr[curCarNumber];
        } else {
            curCarNumber = trainArr[curCarNumber].GetNextCar();
            return trainArr[curCarNumber];
        }


    }

    TrainCar getPrevCar() {
        if (curCarNumber == 0) {
            curCarNumber = trainArr[0].GetPrevCar();
            return trainArr[curCarNumber];
        } else {
            curCarNumber = trainArr[curCarNumber].GetPrevCar();
            return trainArr[curCarNumber];
        }


    }
    }
