

public class WrongFieldChecker implements Checker {
    @Override
    public void checkEverything(Movie movie)  {
        if(movie.getName() ==""){
            movie.setName("Movie " + movie.getId());
        }
        if(movie.getOscarcount() <= 0){
            movie.setOscarsCount((int)(Math.random()*10));
        }
        if(movie.getCoordinates().getX() <-210){
            movie.getCoordinates().setX((long)Math.random()*100 );
        }

    }
}
