public class Info implements Command {
    @Override
    public void execute(MovieList movieList) {
        if(movieList.isEmpty()){
            System.out.println("Collection is empty");
        }else{
            System.out.println("Amount of movies in storage: " + movieList.size() + "\n" +
                    "Date of initialization: " + movieList.getAuthDateTime() + "\n" +
                    "Collection type: " + movieList.getClass().getSimpleName());
        }
    }
}
