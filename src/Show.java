/**
 * реализация команды show
 */
public class Show implements Command {
    @Override
    public void execute(MovieList movieList) {
        if(movieList.isEmpty()){
            System.out.println("Collection is empty");
        }else{
            for(Movie m : movieList){
                System.out.println(m.toString());
                System.out.println("----------//----------");
            }
        }
    }
}
