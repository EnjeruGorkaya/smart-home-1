package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Enjeru on 11.12.2017.
 */
public class AlarmSystemStateOffTest {
    @Test
    public void getState() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void turnOn() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
    }

    @Test
    public void onEvent() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void enterPassword() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.enterPassword("5783");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void turnOffTest() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

}