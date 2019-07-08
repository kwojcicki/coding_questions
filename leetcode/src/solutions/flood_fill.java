package solutions;

public class flood_fill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(newColor != image[sr][sc]) {
			fill(image, sr, sc, newColor, image[sr][sc]);
		}
		return image;
	}

	public static void fill(int[][] image, int sr, int sc, int newColor, int changingColor) {
		if(!inBounds(image, sr, sc)) {
			return;
		}

		if(image[sr][sc] == changingColor) {
			System.out.println(sr + " " + sc + " " + image[sr][sc] + " " + newColor);
			image[sr][sc] = newColor;

			fill(image, sr + 1, sc, newColor, changingColor);
			fill(image, sr, sc + 1, newColor, changingColor);
			fill(image, sr - 1, sc, newColor, changingColor);
			fill(image, sr, sc - 1, newColor, changingColor);
		}
	}

	public static boolean inBounds(int[][] image, int sr, int sc) {
		if(sr < 0 || sr > image.length - 1) {
			return false;
		}

		if(sc < 0 || sc > image[0].length - 1) {
			return false;
		}

		return true;
	}


	public static void main(String[] args) {
		System.out.println("start");
		new flood_fill().floodFill(new int[][] {{0,0,0},{0,1,1}},
				1,
				1,
				1);
	}
}
