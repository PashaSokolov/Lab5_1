import java.util.ArrayList;
import java.time.LocalDateTime;

public class MovieList  extends ArrayList<Movie> {
    public LocalDateTime authDateTime;

    public void setAuthDateTime(LocalDateTime authDateTime) {

        this.authDateTime = authDateTime;

    }

    public LocalDateTime getAuthDateTime(){

        return this.authDateTime;

    }
}
