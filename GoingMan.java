package com.vesnin.train;

public class GoingMan {
    public static void main(String[] args) {
        int step=0;
        int lastCar = 0;
        int curLight;
        int lastLight;
        int isFind = 0;
        Train curTrain = new Train();
        curTrain.newTrain();
        TrainCar curTrainCar = new TrainCar();

        curTrainCar = curTrain.getCurCar();
        curLight = curTrainCar.GetCurCarLight(); //Запомним свет в перком вагоне

        do {
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
                do {
                    curTrainCar = curTrain.getPrevCar(); //Идем обратно в первый вагон
                    step--;
                } while (step != 0);
                if (lastLight == curTrainCar.GetCurCarLight()) //Если там свет тоже поменялся значит мы прошли круг
                {
                    isFind = 1;
                } else
                    do {
                        curTrainCar = curTrain.getNextCar(); //возвращается на последний шаг и ищем следующий свет как был в 1-м вагоне
                        step++;
                    } while (step != lastCar);
            }

        } while (isFind != 1);

        System.out.println(lastCar); //Кол-во вагонов

    }

}
