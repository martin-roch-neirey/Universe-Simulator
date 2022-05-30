package ch.hefr.iscrsid.gl1.strmauroc;

import ch.hefr.iscrsid.gl1.strmauroc.controllers.IUniverseController;
import ch.hefr.iscrsid.gl1.strmauroc.models.*;
import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;

import java.util.concurrent.TimeUnit;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief One demo of the app
 */

public abstract class App {
    public static void main(String[] args) throws InterruptedException {
        Board myBoard = new Board(10,10);
        System.out.println("----------------INIT-----------------");
        System.out.println(myBoard);
        System.out.println();
        System.out.println("-----------------ADD-----------------");
        MobileAntenna antenna1 = new MobileAntenna(myBoard, 4);
        MobilePhone phone = new MobilePhone(myBoard, 10);
        myBoard.addElement(phone, 8, 0);
        myBoard.addElement(antenna1, 8, 8);

        System.out.println(myBoard);

        System.out.println("-----------------START-----------------");


        for (int i = 0; i < 100; i++) {
            System.out.println("time unit = " + i);
            IUniverseController.actionAll(myBoard);
            System.out.println(myBoard);
            if (i == 2) myBoard.moveElement(antenna1, 1,5);
            System.out.println(phone.getState());
            TimeUnit.SECONDS.sleep(10);
        }

    }
}
