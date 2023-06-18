package Stan_2;

public class Opening implements Stan{
    @Override
    public void open(DoorSimulator ds) {
        ds.client.buttonPressed(ds);
    }

    @Override
    public void stop(DoorSimulator ds) {

    }

    @Override
    public void close(DoorSimulator ds) {

    }

    @Override
    public void start(DoorSimulator ds) {

    }
}
