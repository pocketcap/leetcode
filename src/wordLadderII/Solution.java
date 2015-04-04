package wordLadderII;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * reference: http://blog.csdn.net/whuwangyi/article/details/21611433
 */

public class Solution {
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		dict.add(end);

		Map<String, Node> map = new HashMap<String, Node>();
		LinkedList<String> queue = new LinkedList<String>();

		Node startNode = new Node(1, start);
		queue.offer(start);
		map.put(start, startNode);
		List<List<String>> ret = new LinkedList<List<String>>();

		while (!queue.isEmpty()) {
			String str = queue.poll();

			if (str.equals(end)) {
				getPaths(map.get(end), new LinkedList<String>(), ret);
				return ret;
			}
			for (int i = 0; i < str.length(); i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					String newStr = replace(str, i, c);

					// if a new word is explored
					if (dict.contains(newStr)) {
						if (!map.containsKey(newStr)) {
							Node node = map.get(str);
							Node newNode = new Node(node.dist + 1, newStr);
							newNode.prev.add(node);
							map.put(newStr, newNode);
							queue.offer(newStr);
						} else {
							Node node = map.get(newStr);
							Node prevNode = map.get(str);
							if (node.dist == prevNode.dist + 1) {
								node.prev.add(prevNode);
							}
						}
					}
				}
			}
		}
		return ret;
	}

	private String replace(String str, int index, char c) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(index, c);
		return sb.toString();
	}

	// get all the paths by using DFS
	private void getPaths(Node end, List<String> curPath,
			List<List<String>> paths) {

		if (end == null) {
			paths.add(curPath);
			return;
		}
		curPath.add(0, end.str);
		if (!end.prev.isEmpty()) {
			for (Node preNode : end.prev) {
				getPaths(preNode, new LinkedList<String>(curPath), paths);
			}
		} else {
			getPaths(null, curPath, paths);
		}
	}
}

class Node {
	public int dist;
	public String str;
	public LinkedList<Node> prev;

	public Node(int dist, String str) {
		this.dist = dist;
		this.str = str;
		this.prev = new LinkedList<Node>();
	}
}
