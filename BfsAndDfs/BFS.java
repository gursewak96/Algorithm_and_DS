import java.util.*;
import java.awt.Point;


public class BFS{
    public static void bfs(Point p, String[][]grid){
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(p);

        while(!queue.isEmpty()){
            // get the first element out of the queue
            
            Point c = queue.remove();
            int x = (int)c.getX();
            int y = (int)c.getY();
            // System.out.println(x+"  "+y);
            // mark the point visited in the grid => -1
            grid[y][x] = "-1";
            // visit all the valid neighboring points in the grid 
            // and takes the edge case into the account
            for(int k = 0;k<4;k++){
                int dx = (k%2)*((int)Math.pow(-1,(int)k/2));
                int dy = (k+1)%2*((int)Math.pow(-1,(int)k/2));
                
                if(x+dx >= grid[0].length || y+dy >= grid.length || x+dx < 0 || y+dy < 0){
                    continue;
                }else if(Integer.parseInt(grid[y+dy][x+dx]) <= 0){
                    continue;
                }else{
                    queue.add(new Point(x+dx,y+dy));
                }
                
            }
        }

    }
}