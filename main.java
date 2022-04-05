import java.io.*;
import java.util.*;

public class Main {
	
	private static FastReader in;
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	static class Solver {
		
		private static int cnt;
		
		Solver() {
			
			// input
			long a = in.nextLong(), b = in.nextLong();
			
			// if they both do not divide each other, then the answer does not exist
			if(a % b != 0 && b % a != 0) {
				System.out.println(-1);
				return;
			}
			
			// find their quotient (value that needs to removed to make them equal)
			long quotient = 0;
			if(a > b) {
				quotient = a / b;
			} else {
				quotient = b / a;
			}
			
			// divide their quotient starting from 8, then 4, then 2 (minimum no. of operations)
			cnt = 0;
			quotient = divideNum(quotient, 8);
			quotient = divideNum(quotient, 4);
			quotient = divideNum(quotient, 2);
			
			// output
			System.out.println(quotient == 1 ? cnt : -1);
		}
		
		/**
		 * Divides x by the specified divisor (if it's divisible)
		 * @param x
		 * @param divisor
		 * @return
		 */
		static long divideNum(long x, int divisor) {
			while(x % divisor == 0) {
				x /= divisor;
				cnt++;
			}
			return x;
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
