package ru.sbt.mipt.oop;

public class AlarmSystemStateOn implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private final String correctPassword = "0000";

    public AlarmSystemStateOn(AlarmSystem system) {
        alarmSystem =system;

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
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }

    @Override
    public void enterPassword(String password) {
        // Если введут правильный пароль, отключить сигнализацию
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }

    @Override
    public void turnOff() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }
}

