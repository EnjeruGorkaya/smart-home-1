package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Enjeru on 11.12.2017.
 */
public class AlarmSystemStateOnTest {
    @Test
    public void getState() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getState());
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
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        alarmSystem.onEvent(event);
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void enterCorrectPassword() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.enterPassword("0000");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void enterIncorrectPassword() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
        alarmSystem.enterPassword("skjf0");
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

    @Test
    public void turnOffTest() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

}