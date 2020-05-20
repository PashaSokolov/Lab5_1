import java.util.ArrayList;
import java.util.Comparator;

public class PrintAscending  implements  Command{
    @Override
    public void execute(MovieList movieList) {
        if(!movieList.isEmpty()){
            ArrayList<Movie> list = new ArrayList<>();
            for(Movie m : movieList){
                list.add(m);
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.G)
                    System.out.println(m.toString());
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.PG)
                    System.out.println(m.toString());
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.PG_13)
                    System.out.println(m.toString());
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.R)
                    System.out.println(m.toString());
            }
            for(Movie m : list){
                if(m.getMpaaRating() == MpaaRating.NC_17)
                    System.out.println(m.toString());
            }
        }else{
            System.out.println("Collection is empty");
        }

    }
}
