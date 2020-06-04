import java.time.LocalDate;

import java.time.LocalDateTime;

import java.util.Date;

public class Movie implements Comparable<Movie> {
    private static long previousID = 0;

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long oscarsCount; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating;
    private Person director;

    public void Movie(String name, Coordinates coordinates, long oscarsCount,MovieGenre genre,MpaaRating mpaaRating,Person director){
       this.name = name;
       this.coordinates = coordinates;
       this.oscarsCount = oscarsCount;
       this.genre = genre;
       this.mpaaRating = mpaaRating;
       this.director = director;
    }

    public Movie(){
        this.setId();
        this.setCreationDate();
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public long getOscarcount(){
        return oscarsCount;
    }

    public MovieGenre getMoviegenre(){
        return genre;
    }
    public MpaaRating getMpaaRating(){
        return mpaaRating;
    }
    public Person getDirector(){
        return director;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public void setCreationDate(){
        this.creationDate = LocalDateTime.now();
    }
    public void setOscarsCount(long oscarsCount){
        this.oscarsCount = oscarsCount;
    }
    public void setMpaaRating(MpaaRating mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    public void setMoviegenre(MovieGenre genre){
        this.genre = genre;
    }
    public void setDirector(Person director){
        this.director = director;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setId() {
        long id = System.currentTimeMillis() % 10000000;
        if ( id <= previousID ) {
            id = (previousID + 1) % 10000000;
        }
        previousID=id;
        this.id = id;
    }




    @Override
    public int compareTo(Movie movie) {
        int diff = 0;


        if(this.id - movie.getId() > 0){

            diff++;

        }else if (this.id - movie.getId() < 0){

            diff--;

        }


        diff += String.valueOf(this.getName()).compareTo(String.valueOf(movie.getName()));

        diff += String.valueOf(this.getMoviegenre()).compareTo(String.valueOf(movie.getMoviegenre()));

        diff += String.valueOf(this.getMpaaRating()).compareTo(String.valueOf(movie.getMpaaRating()));

        diff += Long.valueOf(this.getOscarcount()).compareTo(Long.valueOf(movie.getOscarcount()));

        diff += Person.valueOf(this.getDirector()).compareTo(Person.valueOf(movie.getDirector()));

        diff += String.valueOf(this.getCreationDate()).compareTo(String.valueOf(movie.getCreationDate()));

        diff += Coordinates.valueOf(this.getCoordinates()).compareTo(Coordinates.valueOf(movie.getCoordinates()));



       return diff;
    }
/**

 * @return поток вывода об элементе класса Movie

 */
    public String toString(){
        return "Movie ID: " + this.getId() + "\n"
                + "Movie name: " + this.getName() + "\n"
                + "Coordinates: \n" + "\t x: " + this.getCoordinates().getX()
                + "\n \t y: " + this.getCoordinates().getY() + "\n"
                + "Oscars count" + this.getOscarcount() + "\n"
                + "Movie genre: " + this.getMoviegenre() + "\n"
                + "Mpaa Raiting: " + this.mpaaRating + "\n"
                + "Director: " + this.director + "\n"
                + "Creation Date: "  + this.getCreationDate();
    }

}



