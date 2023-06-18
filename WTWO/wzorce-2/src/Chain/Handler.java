package Chain;

public abstract class Handler {
    Handler handler;

    public Handler(Handler handler) {
        this.handler = handler;
    }
    public void handle(Napis napis){
        handler.handle(napis);

    }

}
