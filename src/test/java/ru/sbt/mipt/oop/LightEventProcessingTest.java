package ru.sbt.mipt.oop;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.LightEventProcessing.isLight;
import static ru.sbt.mipt.oop.LightEventProcessing.switchLight;
import static ru.sbt.mipt.oop.SensorEventType.*;

public class LightEventProcessingTest {
    @Test
    public void handle(){
        LightEventProcessing lightEventProcessing = new LightEventProcessing();
        SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(), "room"));
        SensorEvent event = new SensorEvent(LIGHT_ON, lightId);
        lightEventProcessing.handle(home, event);
        assertTrue(light.isOn());
    }

    @Test
    public void checkIfLightAndDoor() {
        SensorEvent event1 = new SensorEvent(LIGHT_ON, "Light1");
        SensorEvent event2 = new SensorEvent(LIGHT_OFF, "Light2");
        SensorEvent event3 = new SensorEvent(DOOR_OPEN, "Door1");
        SensorEvent event4= new SensorEvent(DOOR_CLOSED, "Door2");
        assertTrue(isLight(event1));
        assertTrue(isLight(event2));
        assertFalse(isLight(event3));
        assertFalse(isLight(event4));
    }

    @Test
    public void switchLightTest() {

        List<Light> lights_1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors_1 = Arrays.asList(new Door(false, "1"));
        Room kitchen = new Room(lights_1, doors_1, "kitchen");

        List<Light> lights_2 = Arrays.asList(new Light("3", true));
        List<Door> doors_2 = Arrays.asList(new Door(false, "2"));

        Light light = new Light("Light", true);
        SensorEvent event = new SensorEvent(LIGHT_ON, "OnLight");
        Room room = new Room(lights_2, doors_2, "justRoom");

        switchLight(event, room, light);

        assertTrue(light.isOn());
    }

}
