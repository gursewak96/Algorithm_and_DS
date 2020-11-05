import java.awt.Point;

class NumberOfIslands{

    private static void printResult(String[][]grid, int count){
        printGrid(grid);
        System.out.println("Number of Islands found: "+count);
    }
    private static void printGrid(String[][] grid){
        System.out.println(" --------------------");
        for(int i = 0; i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(Integer.parseInt(grid[i][j]) < 0)
                    System.out.print(" |"+grid[i][j]);
                else
                    System.out.print( " | "+grid[i][j]);
            }
            System.out.print("| ");
            System.out.println("");
        }
        System.out.println(" --------------------");
    }
    public static void main(String[] args){
        String[][] grid = {
            {"1","1","1","1","0"},
            {"1","1","0","1","0"},
            {"1","1","0","0","0"},
            {"0","0","0","0","1"},
        };

        int count_of_islands = 0;
        printGrid(grid);
        for(int y = 0; y<grid.length; y++)
            for(int x = 0; x<grid[y].length; x++)
                if (Integer.parseInt(grid[y][x]) > 0) {
                    count_of_islands++;
                    BFS.bfs(new Point(x,y), grid);
                }

        printResult(grid,count_of_islands);
    }
}