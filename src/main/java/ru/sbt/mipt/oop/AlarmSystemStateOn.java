package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventProcessing.isDoor;

public class AlarmSystemStateOn implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private final String correctPassword = "0000";

    public AlarmSystemStateOn(AlarmSystem system) {
        alarmSystem =system;
        //system.turnOn();
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ON;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        if (isDoor(sensorEvent)) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
        } else {
            return;
        }
    }

    @Override
    public void enterPassword(String password) {
        // Если введут правильный пароль, отключить сигнализацию
        if (password == correctPassword) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
        } else {
            // отправить смс владельцу
            alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
        }
    }

    @Override
    public void turnOff() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }
}

