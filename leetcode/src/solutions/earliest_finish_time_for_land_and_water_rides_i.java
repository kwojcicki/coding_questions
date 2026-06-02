package solutions;

class earliest_finish_time_for_land_and_water_rides_i {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = 1000000;

        for(int land = 0; land < landStartTime.length; land++){
            for(int water = 0; water < waterStartTime.length; water++){
                int landFinish = landStartTime[land] + landDuration[land];
                int waterStart = Math.max(landFinish, waterStartTime[water]);
                int pos1 = waterStart + waterDuration[water];

                int waterFinish = waterStartTime[water] + waterDuration[water];
                int landStart = Math.max(waterFinish, landStartTime[land]);
                int pos2 = landStart + landDuration[land];

                min = Math.min(min, Math.min(pos1, pos2));
            }
        }

        return min;
    }
}
