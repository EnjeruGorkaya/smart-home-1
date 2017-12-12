package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.sbt.mipt.oop.DoorEventProcessing.isDoor;
import static ru.sbt.mipt.oop.DoorEventProcessing.switchDoor;
import static ru.sbt.mipt.oop.LightEventProcessing.isLight;
import static ru.sbt.mipt.oop.LightEventProcessing.switchLight;
import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventProcessingTest {
    @Test
    public void handle() {
        DoorEventProcessing doorEventProcessing = new DoorEventProcessing();
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(false, doorId);

        String lightId = "1";
        Light light = new Light(lightId, false);

        home.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door), "room"));
        SensorEvent event = new SensorEvent(DOOR_OPEN, doorId);
        doorEventProcessing.handle(home, event);
        assertTrue(door.getIsOpen());
    }

    @Test
    public void checkIfDoorAndLight() {
        SensorEvent event1 = new SensorEvent(LIGHT_ON, "Light1");
        SensorEvent event2 = new SensorEvent(LIGHT_OFF, "Light2");
        SensorEvent event3 = new SensorEvent(DOOR_OPEN, "Door1");
        SensorEvent event4= new SensorEvent(DOOR_CLOSED, "Door2");
        assertFalse(isDoor(event1));
        assertFalse(isDoor(event2));
        assertTrue(isDoor(event3));
        assertTrue(isDoor(event4));
    }

    @Test
    public void switchDoorTest() {
        Door door = new Door(false, "door1");
        List<Light> lights_1 = Arrays.asList(new Light("1", false), new Light("2", true));
        List<Door> doors_1 = Arrays.asList(new Door(false, "1"), door);

        Light light = new Light("Light", true);
        SensorEvent event = new SensorEvent(DOOR_OPEN, "OpenDoor");
        Room room = new Room(lights_1, doors_1, "justRoom");

        List<Room> rooms = Arrays.asList(room);

        SmartHome smartHome = new SmartHome(rooms);

        switchDoor(smartHome, event, room, door);

        assertTrue(door.getIsOpen());
    }


}
