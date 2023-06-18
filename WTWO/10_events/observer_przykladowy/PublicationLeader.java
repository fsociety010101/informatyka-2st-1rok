package observer;

import visitor.SalaryRaiser;

import java.util.HashMap;

public class PublicationLeader implements Observer {
    HashMap<String, Integer> publicationCounter = new HashMap<>();

    @Override
    public void update(Article article) {
        if (publicationCounter.containsKey(article.getNewspaper())) {
            publicationCounter.put(article.getNewspaper(), publicationCounter.get(article.getNewspaper()) + 1);
        } else {
            publicationCounter.put(article.getNewspaper(), 1);
        }
    }

    public String whoIsTheLeader(){
        Integer leaderCounter = 0;
        String leader = "";
        for(String newspaper: publicationCounter.keySet()){
            if (publicationCounter.get(newspaper) > leaderCounter){
                leader = newspaper;
                leaderCounter = publicationCounter.get(newspaper);
            }
        }
        return leader;
    }
}
