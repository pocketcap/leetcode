package mergeIntervals;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1)
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end >= curr.start) {
				prev.end = Math.max(curr.end, prev.end);
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);

		return result;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}