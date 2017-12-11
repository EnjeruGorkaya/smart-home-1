package ru.sbt.mipt.oop;

public class AlarmSystem implements AlarmSystemState {

    private AlarmSystemState alarmSystem;

    public AlarmSystem(){
        alarmSystem = new AlarmSystemStateOff(this);
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return alarmSystem.getState();
    }

    @Override
    public void turnOn() {
        alarmSystem.turnOn();
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystem.onEvent(sensorEvent);
    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public void turnOff() {
        alarmSystem.turnOff();
    }

    public void setAlarmSystemState(AlarmSystemState newSystemState){
        this.alarmSystem = newSystemState;
    }


}
