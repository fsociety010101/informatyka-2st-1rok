package Chain;

public class ImportantCheck extends Handler {

    public ImportantCheck(Handler handler) {
        super(handler);
    }

    @Override
    public void handle(Napis napis) {
        if(napis.getStan().equals(Stan.IMPORTANT)){
            napis.setNapis((napis.getNapis() + " UWAGA TO JEST WAZNA WIADOMOŚĆ"));
        }else{
            napis.setNapis(napis.getNapis() +  " TO jest nie ważna wiadomość");
            super.handle(napis);

        }



    }

}

