package design_mode.visitor;

import java.util.ArrayList;

/**
 * Created by backstop-samuel on 5/11/17.
 */
public class ObjectStructure {

    private ArrayList<Season> seasonsList = new ArrayList<>();

    public void attach(Season season){
        seasonsList.add(season);
    }

    public void remove(Season season){
        seasonsList.remove(season);
    }

    public void accept(SeasonVisitor visitor){
        seasonsList.forEach(season -> season.accept(visitor));
    }


}
