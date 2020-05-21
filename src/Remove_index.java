import java.time.LocalDateTime;
/**
 * реализация команды remove_by
 */

public class Remove_index implements BigCommand {
    @Override
    public void execute(MovieList movieList, String s) {
        try{
            int indexToRemove = Integer.valueOf(s);
            int prevSize = movieList.size();
            if(!movieList.isEmpty()) {
                if (movieList.get(indexToRemove) == null) {
                    System.out.println("Nothing was removed");
                } else {
                    movieList.remove(indexToRemove);
                    System.out.println("Movie " + s + " was successfully removed");
                }
            }else{
                System.out.println("Collection is empty");
            }
        }catch (NumberFormatException e){
            System.out.println("ID should be a number from 0 to " + Long.MAX_VALUE);
        }
    }
}
