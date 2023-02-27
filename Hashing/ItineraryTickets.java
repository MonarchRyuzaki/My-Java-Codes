import java.util.HashMap;

public class ItineraryTickets{
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> revmap = new HashMap<>();
        map.put("Chennai","Bengaluru");
        map.put("Bombay","Delhi");
        map.put("Goa","Chennai");
        map.put("Delhi","Goa");
        for (String s : map.keySet()){
            revmap.put(map.get(s),s);
        }
        String start = "";
        for (String s : map.keySet()){
            if (!revmap.containsKey(s)){
                start = s;
            }
        }
        System.out.print(start+"->");
        for (String s : map.keySet()){
            System.out.print(map.get(start)+"->");
            start = map.get(start);
        }
    }
}