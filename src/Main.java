import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Convertator c = new Convertator();
        try{
            if (System.getenv("jsonEnv")!=null) {
                Terminal t = new Terminal(c.toCollection(System.getenv("jsonEnv")));
                t.start();
            }else {
                System.out.println("Path was not found");
                System.exit(0);
            }
        }catch (OutOfMemoryError e){
            System.out.println(
                    "ЗАПУСКАЕМ░░\n" +
                            "░ГУСЯ░▄▀▀▀▄░ГИДРУ░░\n" +
                            "▄███▀░◐░▄▀▀▀▄░░░░░░\n" +
                            "░░▄███▀░◐░░░░▌░░░\n" +
                            "░░░▐░▄▀▀▀▄░░░▌░░░░\n" +
                            "▄███▀░◐░░░▌░░▌░░░░\n" +
                            "░░░░▌░░░░░▐▄▄▌░░░░░\n" +
                            "░░░░▌░░░░▄▀▒▒▀▀▀▀▄\n" +
                            "░░░▐░░░░▐▒▒▒▒▒▒▒▒▀▀▄\n" +
                            "░░░▐░░░░▐▄▒▒▒▒▒▒▒▒▒▒▀▄\n" +
                            "░░░░▀▄░░░░▀▄▒▒▒▒▒▒▒▒▒▒▀▄\n" +
                            "░░░░░░▀▄▄▄▄▄█▄▄▄▄▄▄▄▄▄▄▄▀▄\n" +
                            "░░░░░░░░░░░▌▌░▌▌░░░░░\n" +
                            "░░░░░░░░░░░▌▌░▌▌░░░░░\n" +
                            "░░░░░░░░░▄▄▌▌▄▌▌░░░░░\n" +
                            "File is to big");
            System.exit(0);
        }
    }
}