package DynamicProgramming.Medium.TwoD;

import java.util.Arrays;

public class ANinjaTraining {
    public static void main(String[] args) {
        // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        int[][] dp = new int[n][4];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        System.out.println(ninjaTrainingMemoization(n-1, 3, points, dp)); // Calculate and print the maximum points
        System.out.println(ninjaTrainingTabulation(points));
        System.out.println(ninjaTrainingSpaceOptimization(points));
    }

    private static int ninjaTrainingMemoization(int day,int last, int[][] points, int[][]dp) {
        if(dp[day][last]!=-1)
            return dp[day][last];
        if(day == 0){
            int maxi = 0;
            for (int i=0;i<=2;i++){
                if(i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi;
        }
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int activity = points[day][i] + ninjaTrainingMemoization(day-1, i, points, dp);
                maxi = Math.max(activity, maxi);
            }
        }
        return dp[day][last]=maxi;

    }
    private static int ninjaTrainingTabulation(int[][] points) {
        int n=points.length;
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1;day<n;day++){
            for(int last=0; last<4; last++){
                dp[day][last] = 0;
                for(int task=0;task<=2;task++){
                    if(last!=task){
                        int activity = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    private static int ninjaTrainingSpaceOptimization(int[][] points){
        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1;day<points.length;day++){
            int[] temp = new int[4];
            for(int last=0;last<4;last++){
                temp[last] = 0;
                for(int task=0;task<=2;task++){
                    if(task!=last){
                        temp[last] = Math.max(temp[last],points[day][task]+prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}
