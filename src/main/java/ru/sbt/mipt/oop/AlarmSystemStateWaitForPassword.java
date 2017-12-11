package ru.sbt.mipt.oop;

public class AlarmSystemStateWaitForPassword implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private final String correctPassword = "0000";

    public AlarmSystemStateWaitForPassword(AlarmSystem system) {
        alarmSystem =system;
        // тайймер, который через заданное время переведет систему в состояние тревоги
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
    }

    @Override
    public void turnOn() {
        return;
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        return;
    }

    @Override
    public void enterPassword(String password) {
        if (password == correctPassword) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
        } else {
            // отправить смс владельцу
            return;
        }
    }

    @Override
    public void turnOff() {return;}
}
