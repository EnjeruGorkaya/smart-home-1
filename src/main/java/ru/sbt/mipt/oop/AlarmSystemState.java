package ru.sbt.mipt.oop;

public interface AlarmSystemState {
    AlarmSystemStateEnum getState();

    void turnOn();

    void onEvent(SensorEvent sensorEvent);

    void enterPassword(String password);

    void turnOff();


}
