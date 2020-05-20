import javax.swing.*;

public class Clear implements Command{
    @Override
    public void execute(MovieList movieList) {
        if(!movieList.isEmpty()){
            movieList.clear();
            System.out.println("Collection was cleared succesfully");
        }else{
            System.out.println("Collection is empty");
        }
    }
}
