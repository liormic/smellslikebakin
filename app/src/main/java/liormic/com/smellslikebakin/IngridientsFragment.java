package liormic.com.smellslikebakin;

/**
 * Created by Liorm on 6/29/2016.
 */
public class IngridientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recpies.ingredients[index].split("'");
    }

}
