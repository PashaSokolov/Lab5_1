public class FilterContains implements BigCommand
{
    @Override
    public void execute(MovieList movieList, String s) {
        boolean b = false;
        if(!movieList.isEmpty()){
            for(Movie m : movieList){
                if(m.getName().contains(s)){
                    b = true;
                    System.out.println(m.toString());
                }
            }
            if(!b){
                System.out.println("Nothing was found");
            }
        }else{
            System.out.println("Collection is empty");
        }
    }
}
