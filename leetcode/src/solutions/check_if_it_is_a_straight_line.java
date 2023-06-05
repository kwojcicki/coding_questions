package solutions;

public class check_if_it_is_a_straight_line {
    public boolean checkStraightLine(int[][] coordinates) {
        double xDiff = coordinates[1][0]  - coordinates[0][0];
        double yDiff = coordinates[1][1]  - coordinates[0][1];
        double run = xDiff/yDiff;
        for(int i = 2; i < coordinates.length; i++){
            double xRun = (coordinates[i][0] - coordinates[i - 1][0]);
            double yRun = (coordinates[i][1] - coordinates[i - 1][1]);
            if(yRun == 0){
                if(yDiff == 0) continue;
                return false;
            } else {
                if(xRun / yRun != run) return false;
            }
        }

        return true;
    }
}
