package ru.sbt.mipt.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

/**
 * Created by Enjeru on 11.12.2017.
 */
public class AlarmSystemStateAlarmTest {
    @Test
    public void getState() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getState());
    }

    @Test
    public void turnOn() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getState());
    }

    @Test
    public void onEvent() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        SensorEvent event = new SensorEvent(DOOR_OPEN, "what should I write here?");
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getState());
    }

    @Test
    public void enterCorrectPassword() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.enterPassword("0000");
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getState());
    }

    @Test
    public void enterIncorrectPassword() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        alarmSystem.enterPassword("0478");
        assertEquals(AlarmSystemStateEnum.ALARM, alarmSystem.getState());
    }

    @Test
    public void turnOffTest() throws Exception {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        alarmSystem.turnOff();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getState());
    }

}