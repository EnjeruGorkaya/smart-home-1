package ru.sbt.mipt.oop;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
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
        // Подготовка
        SmartHome smartHome = mock(SmartHome.class);
        LightEventProcessing lightEventHandler = mock(LightEventProcessing.class);
        DoorEventProcessing doorEventHandler = mock(DoorEventProcessing.class);
        SensorEvent sensorEvent = mock(SensorEvent.class);
        AutoEventsProcessing eventsProcessing= mock(AutoEventsProcessing.class);
        SensorEventObserver observer = new SensorEventObserver(smartHome);

        // Тест
        observer.addHandler(lightEventHandler);
        observer.addHandler(doorEventHandler);
        observer.addHandler(eventsProcessing);
        //observer.runEventCycle();
        verify(lightEventHandler).handle(smartHome, sensorEvent);
        verify(doorEventHandler).handle(smartHome, sensorEvent);
    }

}