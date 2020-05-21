import java.util.ArrayList;
import java.util.Comparator;
/**
 * реализация команды ascending
 */

public class PrintAscending  implements  Command{
    int c = 0;
    @Override
    public void execute(MovieList movieList) {
        if(!movieList.isEmpty()){
            ArrayList<Movie> list = new ArrayList<>();
            for(Movie m : movieList){
                list.add(m);
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.G)
                {
                    System.out.println(m.toString());
                    c++;
                }

            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.PG)
                {
                    System.out.println(m.toString());
                    c++;
                }
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.PG_13)
                {
                    System.out.println(m.toString());
                    c++;
                }
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.R)
                {
                    System.out.println(m.toString());
                    c++;
                }
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.NC_17)
                {
                    System.out.println(m.toString());
                    c++;
                }
            }
            if(c == 0){
                System.out.println("Mpaa rating is null");
            }

        }else{
            System.out.println("Collection is empty");
        }

    }
}
