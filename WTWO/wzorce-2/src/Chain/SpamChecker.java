package Chain;

public class SpamChecker extends Handler {
    public SpamChecker(Handler handler) {
        super(handler);
    }

    @Override
    public void handle(Napis napis) {
        if (napis.getStan().equals(Stan.SPAM)) {
            napis.setNapis((napis.getNapis() + " UWAGA TO JEST SPAM"));
            super.handle(napis);
        } else {
            napis.setNapis(napis.getNapis() +  " TO nie jest spam ");

            super.handle(napis);
        }
    }
}
