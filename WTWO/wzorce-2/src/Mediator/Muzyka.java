package Mediator;

public class Muzyka implements Compnent{
    Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;

    }


    public void odtworz(String typmuzyki){
        if (typmuzyki.equals("wesoła")){
            mediator.call_all("wesoła muzyka");
        }

    }
    public void utworz_playliste(String playlista){
        System.out.println("Utworzono playlistę " + playlista);
    }

}
