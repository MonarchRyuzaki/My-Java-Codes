import java.util.*;

public class JobSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i, int d, int t){
            this.id=i;
            this.deadline = d;
            this.profit= t;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        ArrayList<Job> list = new ArrayList<>();

        for (int i=0;i<jobsInfo.length;i++){
            list.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }

        Collections.sort(list, (obj1,obj2) -> (obj2.profit - obj1.profit)); // descending order
        ArrayList<Integer> seq = new ArrayList<>();

        seq.add(list.get(0).id);
        int time =1;
        for (int i=1;i<list.size();i++){
            if (list.get(i).deadline > time){
                time++;
                seq.add(list.get(i).id);
            }
        }

        for (int i=0;i<seq.size();i++){
            System.out.print("Job "+seq.get(i)+" ");
        }

    }
}
