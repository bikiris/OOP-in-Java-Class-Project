import java.util.*;

public class WordLineList extends TreeMap{
    public String word = null; //stores the word
    public ArrayList<Integer> line = new ArrayList<>(); //stores the line number
    public WordLineList(){
        super(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });//comparator for the treemap
    }//constructor
    public void add(String data, int num) {
        putIfAbsent(data,new ArrayList<Integer>()); //put if the word does not exist, with an empty arraylist
        ArrayList<Integer> a = (ArrayList<Integer>) get(data); //get the arraylist of the word
        a.add(num); //add the num to arraylist
        put(data,a); //replace with new arraylist
    }

    public String toString() {
        String returnString = "";
        Set<Map.Entry<String, ArrayList<Integer>> > entries = entrySet();
        Map.Entry<String, ArrayList<Integer>> entry = null;
        Iterator<Map.Entry<String, ArrayList<Integer>>> iterator = entries.iterator();
        while(iterator.hasNext()){
            entry = iterator.next();
            returnString+=entry.getKey()+ entry.getValue() + "\n";
        }
        return returnString;
    }
}
