package command;

import command.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCommand {

    @Test
    void testAddingProduct(){
        //given
        Client client = new Client();
        StorageInvoker invoker = new StorageInvoker();
        invoker.addCommand(new AddProductItem(client.getStorage(),"forks", 1));

        //when
        invoker.runAll();

        //then
        assertEquals(client.getStorage().getStorage().get("forks"), 501);
    }

    @Test
    void testChangingName(){
        //given
        Client client = new Client();
        StorageInvoker invoker = new StorageInvoker();
        invoker.addCommand(new ChangeProductName(client.getStorage(),"forks", "widelce"));

        //when
        invoker.runAll();

        //then
        assertEquals(client.getStorage().getStorage().get("widelce"), 500);
    }


    @Test
    void testDestroyItems(){
        //given
        Client client = new Client();
        StorageInvoker invoker = new StorageInvoker();
        invoker.addCommand(new DestroyProductItem(client.getStorage(),"forks", 5));

        //when
        invoker.runAll();

        //then
        assertEquals(client.getStorage().getStorage().get("forks"), 495);
    }

    @Test
    void testMultipleCommands(){
        //given
        Client client = new Client();
        StorageInvoker invoker = new StorageInvoker();
        invoker.addCommand(new DestroyProductItem(client.getStorage(),"forks", 5));
        invoker.addCommand(new AddProductItem(client.getStorage(),"forks", 1));
        invoker.addCommand(new ChangeProductName(client.getStorage(),"forks", "widelce"));

        //when
        invoker.runAll();

        //then
        assertEquals(client.getStorage().getStorage().get("widelce"), 496);
    }
}
