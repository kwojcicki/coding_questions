
package solutions;

class earliest_finish_time_for_land_and_water_rides_ii {
 public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = 1000000;

        int earliestLand = landStartTime[0] + landDuration[0];
        for(int i = 0; i < landStartTime.length; i++){
            earliestLand = Math.min(earliestLand, landStartTime[i] + landDuration[i]);
        }

        for(int i = 0; i < waterStartTime.length; i++){
            min = Math.min(min, Math.max(earliestLand, waterStartTime[i]) + waterDuration[i]);            
        }

        int earliestWater = waterStartTime[0] + waterDuration[0];
        for(int i = 0; i < waterStartTime.length; i++){
            earliestWater = Math.min(earliestWater, waterStartTime[i] + waterDuration[i]);
        }

        for(int i = 0; i < landStartTime.length; i++){
            min = Math.min(min, Math.max(earliestWater, landStartTime[i]) + landDuration[i]);
        }

        return min;
    }
}
