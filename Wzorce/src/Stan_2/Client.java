package Stan_2;

public interface Client {
    void buttonPressed(DoorSimulator door);

    void sensor1Reached(DoorSimulator door);

    void sensor2Reached(DoorSimulator door);

    void doorline(DoorSimulator door);

    void timeout(DoorSimulator door);


}
