import java.util.*;

class OpenTheLock{
    static int BFS(String init_seq, String target_seq, String[] dead_ends){

        Queue<String> q = new LinkedList<String>();
        Set<String> dead_ends_list = new HashSet<String>(Arrays.asList(dead_ends));
        Set<String> visited_seq = new HashSet<String>();
        q.add(init_seq);
        int turns = 0;

        while(!q.isEmpty()){
            int size = q.size();
            turns++;
            for(int s=0; s<size; s++){

                String current_seq = q.remove();
                visited_seq.add(current_seq);

                for(int k = 0; k<4; k++){

                    for(int i = -1; i<=1 ; i += 2){
                        String next_seq = incrementBy(current_seq, i, k);

                        if (dead_ends_list.contains(next_seq) || visited_seq.contains(next_seq)){
                            continue;
                        }else if (next_seq.equals(target_seq)){
                            return turns;
                        }else{
                            q.add(next_seq);
                            visited_seq.add(next_seq);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static String incrementBy(String s, int inc, int pos){
        char[] c = s.toCharArray();

        if(c[pos] == '0' && inc < 0) c[pos] = '9';
        else if ( c[pos] == '9' && inc > 0) c[pos] = '0';
        else c[pos] += inc;

        return new String(c);
    }

    public static void main(String[] args){
        String seq = "0000";
        String [] dead_ends = {"0201","0101","0102","1212","2002"};
        String target_seq = "0202";
         System.out.println(BFS(seq, target_seq, dead_ends));
    }
}