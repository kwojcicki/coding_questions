package project_euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class q46 {

	/**
	 *
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
	 */
	public static void main(String[] args) {
		boolean[] seen = new boolean[1_000_000];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		Set<Long> primesSet = new HashSet<Long>();
		for(int i = 2; i < seen.length; i++) {
			if(!seen[i - 2]) {
				primes.add(i);
				primesSet.add((long)i);
			}
			
			for(int j = i - 2; j < seen.length; j += i) {
				seen[j] = true;
			}
		}
		
		
		outerloop:
		for(long i = 5; true; i+=2) {
			if(primesSet.contains(i)) {
				continue;
			}
			
			for(int j = 0; j < primes.size() && primes.get(j) < i; j++) {
				double result = Math.sqrt((i - primes.get(j))/2.0);
				if(result == (int)result) {
					continue outerloop;
				}
			}
			System.out.println("found");
			System.out.println(i);
			break;
		}
	}
	
//	public static void main(String[] args) {
//
//		// TODO:
//		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
//		ArrayList<Integer> x = new ArrayList<Integer>();
//		
//		list.add(new TreeNode());
//		
//		try {
//			xxx(list);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void yyy(Collection<?> x) {
//
//	}
//	
//	public static <T extends Iterable<? extends Serializable>> void xxx(T x) throws IOException {
//		
//		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	        ObjectOutputStream oos = new ObjectOutputStream( baos );
//	        //oos.writeObject( o );
//
//
//		x.forEach(i -> {
//			try {
//				oos.writeObject(i);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//        oos.close();		
//		System.out.println(Base64.getEncoder().encodeToString(baos.toByteArray()));
//	}
}

//class TreeNode implements Serializable {
//	
//}
