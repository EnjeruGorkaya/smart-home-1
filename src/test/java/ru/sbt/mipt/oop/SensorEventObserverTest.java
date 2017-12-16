package ru.sbt.mipt.oop;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Enjeru on 09.12.2017.
 */
public class SensorEventObserverTest {

    @Test
    // проверяем добавление хэндлера
    public  void  TestAddHandler () {
        // Подготовка smartHome
        List<Light> lights_1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors_1 = Arrays.asList(new Door(false, "1"));
        Room kitchen = new Room(lights_1, doors_1, "kitchen");
        List<Light> lights_2 = Arrays.asList(new Light("3", true));
        List<Door> doors_2 = Arrays.asList(new Door(false, "2"));
        Room bathroom = new Room(lights_2, doors_2, "bathroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom));

        LightEventProcessing lightEventHandler = new LightEventProcessing();
        DoorEventProcessing doorEventHandler = new DoorEventProcessing();
        SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_ON, "lightOn");

        SensorEventObserver observer = new SensorEventObserver(smartHome);
        ///////////////////////////////////////////
        //////////////// ВНИМАНИЕ /////////////////
        ///Если это не то, см. предыдущий коммит///
        ///////////////////////////////////////////

        assertTrue(observer.eventHandlers.isEmpty());

        // Тест
        observer.addHandler(lightEventHandler);
        observer.addHandler(doorEventHandler);

        assertFalse(observer.eventHandlers.isEmpty());
        //observer.addHandler(eventsProcessing);
        //observer.runEventCycle();
//        verify(lightEventHandler).handle(smartHome, sensorEvent);
//        verify(doorEventHandler).handle(smartHome, sensorEvent);

    }

}