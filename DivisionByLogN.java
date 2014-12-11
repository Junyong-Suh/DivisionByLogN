class DivisionByLogN {

	public static void main(String[] args) {
		System.out.println("90 / 4 = " + getQuotient(90, 4));
	}

	private static int getQuotient(int large, int small) {
		if (large == 0) return 0;
		if (large < small) {
			throw new IllegalArgumentException();
		}

		int q = 1;
		while(q * small < large) {
			q *= 2;
		}
		int halfQ = q >> 1;

		return getMatchedQ(halfQ, q, small, large);
	}

	private static int getMatchedQ(int halfQ, int q, int a, int b) {
		System.out.println("halfQ: "+ halfQ + ", q: "+ q +", a: "+ a +", b: "+ b);
		int mid = (halfQ + q) >> 1;
		if ((mid * a) == b) {
			return mid;
		} else if (((mid * a) < b) && (mid + 1) * a > b ) {
			return mid;
		}
		return mid * a > b ? getMatchedQ(halfQ, mid-1, a, b) : getMatchedQ(mid+1, q, a, b);
	}

}
