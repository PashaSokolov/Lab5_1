public class Coordinates implements Comparable<Coordinates> {
    private long x; //Максимальное значение поля: 6
    private double y;

    public Coordinates (long x, double y){
        this.x = x;
        this.y = y;
    }
    /**

     * @param coordinates объект класса Coordinates

     * @return координаты (0;0), если coordinates = null, иначе coo

     */

    public static Coordinates valueOf(Coordinates coordinates){
        if(coordinates ==null){
            return new Coordinates(0,0);
        }
        else{
            return coordinates;
        }
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    /**

     * @param coordinates объект класса Coordinates

     * @return результат сравнения

     */

    @Override
    public int compareTo(Coordinates coordinates) {
        if(this.getX() == coordinates.getX() && this.getY() == coordinates.getY()){
            return 0;
        }
        else if(this.getY() - coordinates.getY() >0){
            return 1;
        }
        else {
            return -1;
        }
    }
}