package solutions;

public class largest_triangle_area {
    public double largestTriangleArea(int[][] points) {
        double ret = 0;

        for(int i = 0; i < points.length; i++){
            double x1 = points[i][0];
            double y1 = points[i][1];
            for(int j = i + 1; j < points.length; j++){
                double x2 = points[j][0];
                double y2 = points[j][1];
                for(int k = j + 1; k < points.length; k++){
                    double x3 = points[k][0];
                    double y3 = points[k][1];

                  // https://en.wikipedia.org/wiki/Shoelace_formula
                                        // x1 * y2 - x2 * y1 + x2 * y3 - x3 * y2 + x3 * y1 - x1 * y3
                    double area = (0.5) * Math.abs(x1 * y2 - x2 * y1 + x2 * y3 - x3 * y2 + x3 * y1 - x1 * y3);
                    ret = Math.max(area, ret);
                }
            }
        }

        return ret;
    }
}
