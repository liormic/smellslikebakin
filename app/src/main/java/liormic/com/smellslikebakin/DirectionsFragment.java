package liormic.com.smellslikebakin;

/**
 * Created by Liorm on 6/29/2016.
 */
public class DirectionsFragment  extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recpies.directions[index].split("");
    }

}
