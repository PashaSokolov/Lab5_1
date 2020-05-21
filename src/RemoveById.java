import java.time.LocalDateTime;
import java.util.ConcurrentModificationException;

/**
 * реализация команды remove_by_id
 */

public class RemoveById implements BigCommand {
    @Override
    public void execute(MovieList movieList, String s) {
        try{
            long idToRemove = Long.valueOf(s);
            int prevSize = movieList.size();

            if(!movieList.isEmpty()){
                for (Movie m : movieList){
                    if(m.getId() == idToRemove){
                        movieList.remove(m);
                    }
                }

                if(movieList.size() != prevSize){
                    System.out.println("Movie " + s +" was successfully removed");
                }else{
                    System.out.println("Nothing was removed");
                }
            }else{
                System.out.println("Collection is empty");
            }
        }catch (NumberFormatException e){
            System.out.println("ID should be a number from 0 to " + Long.MAX_VALUE);
        }catch (ConcurrentModificationException e){
            System.out.println();
        }
    }
}
