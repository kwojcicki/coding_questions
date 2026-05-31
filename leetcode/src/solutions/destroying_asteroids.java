package solutions;

class destroying_asteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long totalMass = mass;

        for(int i: asteroids){
            if(totalMass <  (long) i) return false;
            totalMass += i;
        }

        return true;
    }
}
