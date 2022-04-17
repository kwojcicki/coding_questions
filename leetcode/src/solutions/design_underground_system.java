package solutions;

import java.util.HashMap;
import java.util.Map;

public class design_underground_system {
	class UndergroundSystem {
		
		class StartingPoint {
			public String station;
			public int t;
			public StartingPoint(String station, int t) {
				this.station = station;
				this.t = t;
			}
		}
		
		class Average {
			public double t;
			public int count;
			public Average(int t, int count) {
				this.t = t;
				this.count = count;
			}
			
			public void add(int time) {
				t += time;
				count++;
			}
			
			public double getAverage() {
				return t / count;
			}
		}
		
		private Map<String, Map<String, Average>> times = new HashMap<>();
		private Map<Integer, StartingPoint> customers = new HashMap<>();
		
		public UndergroundSystem() {

		}

		public void checkIn(int id, String stationName, int t) {
			customers.put(id, new StartingPoint(stationName, t));
		}

		public void checkOut(int id, String stationName, int t) {
			StartingPoint start = customers.remove(id);
			times.putIfAbsent(start.station, new HashMap<>());
			times.get(start.station).putIfAbsent(stationName, new Average(0, 0));
			times.get(start.station).get(stationName).add(t - start.t);
		}

		public double getAverageTime(String startStation, String endStation) {
			return times.get(startStation).get(endStation).getAverage();
		}
	}
}
