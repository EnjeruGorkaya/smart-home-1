package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Enjeru on 11.12.2017.
 */
public class AlarmSystemStateWaitForPasswordTest {
    @Test
    public void getState() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event);
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void turnOn() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event);
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void onEvent() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event);
        SensorEvent event1 = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event1);
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void enterCorrectPassword() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event);
        //assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState()); // True
        alarmSystem.enterPassword("0000");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void enterIncorrectPassword() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event);
        alarmSystem.enterPassword("skjf0");
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }


    @Test
    public void turnOffTest() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event);
        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

}