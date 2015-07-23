package insert;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			} else if (newInterval.end >= interval.start
					|| newInterval.start <= interval.end) {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, newInterval.end);
			}
		}

		result.add(newInterval);

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