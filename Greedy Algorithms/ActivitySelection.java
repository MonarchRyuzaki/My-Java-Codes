import java.util.*;

public class ActivitySelection{
    public static void main(String[] args) {

        // //End Sorted
        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};


        // int maxAct=0;
        // ArrayList<Integer> list = new ArrayList<>();
        
        // maxAct=1;
        // list.add(0);
        // int lastEnd = end[0];
        // for (int i =1;i<start.length;i++){
        //     if (start[i]>=lastEnd){
        //         maxAct++;
        //         list.add(i);
        //         lastEnd = end[i];
        //     }
        // }
        // System.out.println("Maximum Activities : "+maxAct);
        
        // for (int i=0;i<list.size();i++){
        //     System.out.print("A"+list.get(i)+" ");
        // }

        //End Unsorted
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        int activities[][] = new int [start.length][3];

        //sorting
        for (int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct=0;
        ArrayList<Integer> list = new ArrayList<>();
        
        maxAct=1;
        list.add(0);
        int lastEnd = activities[0][0];
        for (int i =1;i<start.length;i++){
            if (activities[i][1]>=lastEnd){
                maxAct++;
                list.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Maximum Activities : "+maxAct);
        
        for (int i=0;i<list.size();i++){
            System.out.print("A"+list.get(i)+" ");
        }
    }
}