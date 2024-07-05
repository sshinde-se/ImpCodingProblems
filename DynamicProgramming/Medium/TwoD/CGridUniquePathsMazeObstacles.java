package DynamicProgramming.Medium.TwoD;

public class CGridUniquePathsMazeObstacles {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(uniquePathsWithObstaclesSpaceOptimization(maze));
        System.out.println(mazeObstaclesMemoization(n, m, maze));
    }

    private static int mazeObstaclesMemoization(int n, int m, int[][] maze) {
        return 0;
    }

    public static int uniquePathsWithObstaclesSpaceOptimization(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] prev = new int[n];
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1)
                {
                    temp[j] = 0;
                    continue;
                }
                if(i==0&&j==0){
                    temp[j]=1;
                    continue;
                }
                int up=0,left=0;
                if(i>0)
                    up=prev[j];
                if(j>0)
                    left=temp[j-1];
                temp[j] = up+left;
            }
            prev=temp;
        }
        return prev[n-1];
    }
}
