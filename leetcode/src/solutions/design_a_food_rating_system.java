package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class design_a_food_rating_system {
	class FoodRatings {

		Map<String, Food> foodMap = new HashMap<>();
		Map<String, PriorityQueue<Food>> queues = new HashMap<>();

		public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
			for(int i = 0; i < foods.length; i++) {
				Food f = new Food(foods[i], cuisines[i], ratings[i]);
				foodMap.put(foods[i], f);
				queues.putIfAbsent(cuisines[i], new PriorityQueue<Food>((a,b) -> {
					if(a.rating == b.rating) {
						return a.name.compareTo(b.name);
					}

					return b.rating - a.rating;
				}));
				queues.get(cuisines[i]).add(f);
			}
		}

		public void changeRating(String food, int newRating) {
			Food f = foodMap.get(food);
			queues.get(f.cusine).remove(f);
			f.rating = newRating;
			queues.get(f.cusine).add(f);
		}

		public String highestRated(String cuisine) {
			return queues.get(cuisine).peek().name;
		}

		class Food {
			public String name;
			public String cusine;
			public int rating;
			public Food(String name, String cusine, int rating) {
				this.name = name; this.cusine = cusine; this.rating = rating;
			}
		}
	}
}
