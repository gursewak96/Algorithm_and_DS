import java.util.*;
class PerfectSquares{
    public static int [] validRange(int n){
        int [] r = new int[(int)Math.sqrt(n)];
        for(int i = 1; i <= Math.sqrt(n);i++){
            if( i*i <= n){
                r[i-1] = i*i;
            }
        }
        return r;
    }

    public static int BFS(int n){
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> found_nodes = new HashSet<Integer>();
        q.add(n);
        found_nodes.add(n);
        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();
            System.out.println(q);
            dist++;

            for(int s = 0; s<size; s++){
                int node = q.remove();

                for(int i : validRange(node)){
                    int next_node = node - i;
                    if(next_node < 0){
                        continue;
                    }else if(next_node == 0){
                        return dist;
                    }else if(found_nodes.contains(next_node)){
                        continue;
                    }else{
                        q.add(next_node);
                        found_nodes.add(next_node);
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String [] args){
        System.out.println(BFS(13));
    }
}