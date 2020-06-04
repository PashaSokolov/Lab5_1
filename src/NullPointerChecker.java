import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import java.time.LocalDate;

public class NullPointerChecker implements Checker {
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private String newLine = new String();

    @Override
    public void checkEverything(Movie movie){
       if(movie.getName() == null){
           System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");

           movie.setName("ID" + movie.getId());
       }

       if(movie.getCoordinates() == null){
           System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");

           movie.setCoordinates(new Coordinates(6L,100d));
       }

       if(Long.valueOf(movie.getCoordinates().getX()) == null){
           System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");
           movie.getCoordinates().setX(6L);
       }
       if (Double.valueOf(movie.getCoordinates().getY() ) == null){
           System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");

           movie.getCoordinates().setY(100d);
       }

       if(Long.valueOf(movie.getOscarcount() ) == null){
           while(true){
               System.out.println("\n" + "Переменная moviegenre - Null" + "\n"
               + "Введите число от 0 до" + Integer.MAX_VALUE);
               try {
                   newLine = in.readLine();
                   if(newLine == null) return;
                   int newint = Integer.parseInt(newLine);
                   if(newint >=0 && newint <= Integer.MAX_VALUE) movie.setOscarsCount(newint);

               } catch (Exception e) {
                   e.printStackTrace();
               }

           }


       }
           if(movie.getMoviegenre() == null ) {
                while (true){
                    System.out.println("\n" + "Переменная moviegenre - Null, либо не содержится в ENUM");
                    System.out.println("Введите одну из переменных:" + "\n"
                            + "ACTION" + "\n"
                            + "DRAMA" + "\n"
                            + "MUSICAL" + "\n"
                            + "THRILLER" + "\n"
                            + "FANTASY" + "\n");
                    try {
                        newLine = in.readLine();
                        if(newLine == null) return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (newLine.contains("ACTION") || newLine.contains("DRAMA") || newLine.contains("MUSICAL")
                    || newLine.contains("THRILLER") || newLine.contains("FANTASY")){
                        movie.setMoviegenre(MovieGenre.valueOf(newLine));
                        break;
                    }
                }
           }

    }
}
