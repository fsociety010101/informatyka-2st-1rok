package Obserwator;

public class Wind extends Publisher{
    @Override
    public void create_event() {
        WindChange windChange = new WindChange();
        for (Observer subscriber: lista_obserwujacych){
            subscriber.update(windChange);
        }
    }
}
