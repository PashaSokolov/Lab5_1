import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * реализация команды execute_script
 */
public class ExecuteScript implements BigCommand {
    private Terminal fileTerminal;
    private ArrayList<String> executeList = new ArrayList<>();

    public ExecuteScript(Terminal fileTerminal){
        this.fileTerminal = fileTerminal;
    }

    @Override
    public void execute(MovieList movieList, String s) {
        String path = System.getenv("jsonEnv");
        while(!path.endsWith("/")){
            path = path.replaceAll(".$","");
        }
        s = path + s;
        System.out.println(s);

        try {
            if(executeList.contains(s)){
                throw new LoopException("LOOP");
            }else{
                executeList.add(s);
                File script = new File(s);

                if(!script.exists()){
                    System.out.println("File doesn't exist");
                    throw new FileNotFoundException();
                }
                if (!script.isFile()) {
                    System.out.println("This is not a file");
                    throw new FileNotFoundException();

                }

                if (!script.canRead()) {
                    System.out.println("File is unreachable");
                    throw new FileNotFoundException();
                }

                Scanner scanner = new Scanner(script);

                while (scanner.hasNext()) {
                    String newLine = scanner.nextLine().trim();
                    String[] arr = newLine.split(" ", 2);
                    if (arr.length == 1) {
                        fileTerminal.startWithParams(arr[0], null);
                    } else {
                        fileTerminal.startWithParams(arr[0], arr[1]);
                    }
            }
                executeList.remove(s);
        }
    }catch (FileNotFoundException e){
            System.out.println("Script was not executed");
        }catch (OutOfMemoryError e){
            System.out.println("File is too big");
        }catch (LoopException e){
            System.out.println("Loop found. Script processing was terminated");
        }
    }
}
