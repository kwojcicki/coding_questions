package solutions;

public class can_place_flowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		if(flowerbed == null || flowerbed.length == 0) {
			return n == 0;
		} else if(flowerbed.length == 1) {
			if(n == 1)
				return flowerbed[0] == 0;
			else if(n > 1) {
				return false;
			}
			return true;
		}

		int ret = 0;

		for(int i = 0; i < flowerbed.length; i++) {
			if(i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
				ret++;
				flowerbed[i] = 1;
			} else if(i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
				ret++;
				flowerbed[i] = 1;
			} else if(i > 0 && i < flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
				ret++;
				flowerbed[i] = 1;
			}
		}

		return ret >= n;
	}
}
