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

    int GetCurCarLight() {
        if (curCarNumber == 0) {
            System.out.println("GetCurCarLight car:" + curCarNumber + " light is " + trainArr[curCarNumber].light);
            return trainArr[0].light;
        }
        else {
            System.out.println("car:" + curCarNumber);
            return trainArr[curCarNumber].light;
        }
    }

    int GetNextCarLight() {
        curCarNumber = trainArr[curCarNumber].nextCar;
        System.out.println("next car:" + curCarNumber + " light is " + trainArr[curCarNumber].light);
        return trainArr[curCarNumber].light;

    }

    int GetPrevCarLight() {
        curCarNumber = trainArr[curCarNumber].prevCar;
        System.out.println("GetPrevCarLight car:" + curCarNumber);
        return trainArr[curCarNumber].light;

    }

    int SetOffCarLight() {
        if (curCarNumber == 0) {
            trainArr[0].light = 0;
        } else
            trainArr[curCarNumber].light = 0;
        return trainArr[curCarNumber].light;

    }

    int SetOnCarLight() {
        if (curCarNumber == 0) {
            trainArr[0].light = 1;
            System.out.println("curr car:" + curCarNumber + " SetOnCarLight:" + curCarNumber);
        } else {
            trainArr[curCarNumber].light = 1;
            System.out.println("curr car:" + curCarNumber + " SetOnCarLight:" + curCarNumber);
        }
        return trainArr[curCarNumber].light;

    }




    }
