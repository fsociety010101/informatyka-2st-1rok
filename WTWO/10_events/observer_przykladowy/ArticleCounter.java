package observer;

public class ArticleCounter implements Observer {
    private Integer counter = 0;

    @Override
    public void update(Article article) {
        counter++;
    }

    public Integer getCounter() {
        return counter;
    }
}
