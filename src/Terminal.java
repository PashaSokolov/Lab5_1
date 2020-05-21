import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Terminal {
    private MovieList col;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private String newLine = new String();
    private Info info = new Info();
    private Show show = new Show();
    private Add add = new Add();
    private UpdateByID updateByID = new UpdateByID();
    private RemoveById removeById = new RemoveById();
    private Clear clear = new Clear();
    private Save save = new Save();
    private RemoveFirst removeFirst = new RemoveFirst();
    private AddIfMax addIfMax = new AddIfMax();
    private ExecuteScript executeScript = new ExecuteScript(this);
    private FilterContains filterContains = new FilterContains();
    private PrintAscending printAscending = new PrintAscending();
    private PrintDiscending printDiscending = new PrintDiscending();
    private Remove_index remove_index = new Remove_index();

    public Terminal(MovieList col){
        this.col = col;
    }
    /**
     *осуществляет запуск интерактивного режима
     * @throws IOException ;
     */
    public void start() throws IOException {
        System.out.println("Now you can start working. Type 'help' for a list of commands.");

        while (true){
            try{
                newLine = in.readLine().trim();
                String[] arr = newLine.split(" ",2);
                if(arr.length == 1){
                    commandManager(arr[0], null);
                }else{
                    commandManager(arr[0],arr[1]);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    /**
     * осуществляет запуск режима выполнения комманд с параметрами
     * @param arr1 первый параметр (название команды)
     * @param arr2 второй параметр (аргументы команды)
     */
    public void startWithParams(String arr1, String arr2){
        if(arr2 == null){
            commandManager(arr1, null);
        }else{
            commandManager(arr1,arr2);
        }
    }

    private void commandManager(String arr1, String arr2){
        if(arr2 == null){
            switch (arr1){
                case "exit":
                    System.out.println("See you soon");
                    System.exit(0);
                    break;
                case "help":
                    System.out.println("help : вывести справку по доступным командам\n" +
                            "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                            "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                            "add {element} : добавить новый элемент в коллекцию\n" +
                            "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                            "remove_by_id id : удалить элемент из коллекции по его id\n" +
                            "clear : очистить коллекцию\n" +
                            "save : сохранить коллекцию в файл\n" +
                            "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                            "exit : завершить программу (без сохранения в файл)\n" +
                            "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)\n" +
                            "remove_first : удалить первый элемент из коллекции\n" +
                            "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                            "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку\n" +
                            "print_ascending : вывести значения поля mpaaRating всех элементов в порядке возрастания\n" +
                            "print_discescending : вывести значения поля mpaaRating всех элементов в порядке убывания");
                    break;
                case "info":
                    info.execute(col);
                    break;
                case "show":
                    show.execute(col);
                    break;
                case "clear":
                    clear.execute(col);
                    break;
                case "save":
                    save.execute(col);
                    break;
                case "add":
                case "add_if_max":
                case "remove_first":
                    removeFirst.execute(col);
                    break;
                case "execute_script":
                    System.out.println("Null script name value. Try another argument");
                    break;
                case "remove_by_id":
                    System.out.println("ID should be a number from 0 to " + Long.MAX_VALUE);
                    break;
                case "filter_contains_name":
                    System.out.println("Null name. Try another argument");
                    break;
                case "print_ascending":
                    printAscending.execute(col);
                    break;
                case "print_descending":
                    printDiscending.execute(col);
                    break;
                default:
                    System.out.println("Unknown command, type 'help' for a list of commands");
                    break;

            }
        }else{
            switch (arr1){
                case "add":
                    add.execute(col, arr2.trim());
                    break;
                case "update":
                    updateByID.execute(col, arr2.trim());
                    break;
                case "remove_by_id":
                    removeById.execute(col, arr2.trim());
                    break;
                case "remove_at":
                    remove_index.execute(col,arr2);
                    break;
                case "filter_contains_name":
                    filterContains.execute(col, arr2.trim());
                    break;
                case "add_if_max":
                    addIfMax.execute(col, arr2.trim());
                    break;
                case "execute_script":
                    executeScript.execute(col, arr2.trim());
                    break;
                default:
                    System.out.println("Unknown command, type 'help' for a list of commands");
                    break;
            }
        }
    }
}
