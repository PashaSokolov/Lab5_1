import java.sql.Date;

import java.time.LocalDate;

public class NullPointerChecker implements Checker {
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
           System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");

           movie.setOscarsCount(1);
       }
       if (movie.getMoviegenre() == null){
           System.out.println("Looks like some of the fields contain null-values. They will be replaced automatically");

           movie.setMoviegenre(MovieGenre.ACTION);
       }

    }
}
