package com.vesnin.train;

import java.util.Date;

public class GoingMan {
    public static void main(String[] args) {
        Integer step = 0;
        int lastCar = 0;
        int curLight;
        int lastLight;
        int isFind = 0;
        int trainCount = 0;
        int countInterval = 10;
        int tmpCountInt;
        long start;
        float stat;

        Date stepDate = new Date();
        stepDate.toString();
        System.out.println(stepDate.toString());
        start = System.currentTimeMillis();
        Train curTrain = new Train();
        curTrain.newTrain();
        System.out.println((System.currentTimeMillis() - start) + " mc");
        TrainCar curTrainCar = new TrainCar();
        curTrainCar = curTrain.getCurCar();
        curLight = curTrainCar.GetCurCarLight(); //Запомним свет в перком вагоне
        tmpCountInt = countInterval;


        do {
            stat = (step.floatValue() / curTrain.trainCarCount.floatValue()) * 100;
            if (stat > tmpCountInt) {
                System.out.println(tmpCountInt + "% ");
                System.out.println((System.currentTimeMillis() - start) + " mc");
                tmpCountInt = tmpCountInt + countInterval;
            }
            curTrainCar = curTrain.getNextCar();
            step++;
            if (curTrainCar.GetCurCarLight() == curLight) //идем по поезду до такого же света
            {
                if (curLight == 0) //
                {
                    curTrainCar.SetOnCarLight();
                } //включаем
                else {
                    curTrainCar.SetOffCarLight();
                } //или выключаем

                lastCar = step; //запоминаем где были
                lastLight = curTrainCar.GetCurCarLight(); //и какой свет стал
                //do {
                //    curTrainCar = curTrain.getPrevCar(); //Идем обратно в первый вагон
                //    step--;
                //} while (step != 0);
                curTrainCar = curTrain.jumpToCar(0); //телепортируемся в первый вагон
                if (lastLight == curTrainCar.GetCurCarLight()) //Если там свет тоже поменялся значит мы прошли круг
                {
                    isFind = 1;
                } else
                    curTrainCar = curTrain.jumpToCar(lastCar); //телепортируемся на последний шаг
                // do {
                //     curTrainCar = curTrain.getNextCar(); //возвращается на последний шаг и ищем следующий свет как был в 1-м вагоне
                //     step++;
                // } while (step != lastCar);
            }

        } while (isFind != 1);

        System.out.println(lastCar); //Кол-во вагонов
        System.out.println((System.currentTimeMillis() - start) + " mc");

    }

}
