class Solution {
public:
	int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (C < E || G < A || D < F || H < B)
			return (C - A) * (D - B) + (G - E) * (H - F);

		int left = max(A, E);
		int right = min(C, G);
		int bottom = max(B, F);
		int top = min(D, H);
		return (C - A) * (D - B) + (G - E) * (H - F)
				- (top - bottom) * (right - left);
	}
};
