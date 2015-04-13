package unique.path;

public class II {

	public static void main(String [] args) {
//		int[][]grid = {{0,0},{0,1}};
		int[][]grid = {{0,1}};
		System.out.println(new II().uniquePathsWithObstacles(grid));
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
        	return 0;
        }
        
        if(obstacleGrid[0][0] == 1) {
        	return 0;
        }
		if (obstacleGrid.length == 1 || obstacleGrid[0].length == 1) {
			for (int i = 0; i < obstacleGrid.length; i++) {
				for (int j = 0; j < obstacleGrid[0].length; j++) {
					if (obstacleGrid[i][j] == 1) {
						return 0;
					}
				}
			}
			return 1;
		}
        
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        //initialize
        paths[0][0] = 1;
        for(int i=1; i<obstacleGrid[0].length; i++){
        	if(obstacleGrid[0][i] == 1 || paths[0][i-1] == 0) {
        		paths[0][i] = 0;
        	} else {
        		paths[0][i] = 1;
        	}
        }
        for(int i=1; i<obstacleGrid.length; i++) {
        	if(obstacleGrid[i][0] == 1 || paths[i-1][0] == 0) {
        		paths[i][0] = 0;
        	} else {
        		paths[i][0] = 1;
        	}
        }
        
        //dp
        for(int i=1; i<obstacleGrid.length; i++) {
        	for(int j=1; j<obstacleGrid[0].length; j++) {
        		if(obstacleGrid[i-1][j]==0) {
        			paths[i][j] += paths[i-1][j];
        		}
        		if(obstacleGrid[i][j-1]==0) {
        			paths[i][j] += paths[i][j-1];
        		}
        		
        		if(obstacleGrid[i][j]==1) {
        			paths[i][j] = 0;
        		}
        	}
        }
        return paths[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
