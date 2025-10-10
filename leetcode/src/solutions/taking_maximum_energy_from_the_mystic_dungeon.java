package solutions;

public class taking_maximum_energy_from_the_mystic_dungeon {
    public int maximumEnergy(int[] energy, int k) {
        int ret = energy[energy.length - 1];

        for(int i = energy.length - 1; i >= 0; i--){
            energy[i] = i + k < energy.length ? energy[i + k] + energy[i] : energy[i];

            ret = Math.max(
                ret,
                energy[i]
            );
        }

        return ret;
    }
}
