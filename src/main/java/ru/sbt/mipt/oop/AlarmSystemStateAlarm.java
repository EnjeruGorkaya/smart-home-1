package ru.sbt.mipt.oop;

/**
 * Created by 11007122 on 09.12.2017.
 */
public class AlarmSystemStateAlarm implements AlarmSystemState {
    private final AlarmSystem alarmSystem;
    private final String correctPassword = "0000";

    public AlarmSystemStateAlarm(AlarmSystem system) {
        alarmSystem =system;
        // неплохо бы отправить смс владельцу, что включилась тревога
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ALARM;
    }

    @Override
    public void turnOn() {alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem)); }

    @Override
    public void onEvent(SensorEvent sensorEvent) {return;}

    public void enterPassword (String password) {
        // Если введут правильный пароль, отключить сигнализацию
        if (password == correctPassword) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
        } else {
            // отправить смс владельцу
            alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        }
    }

    @Override
    public void turnOff() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }

}
