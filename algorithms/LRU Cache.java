// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

public class LRUCache {

	private HashMap<Integer, Node> data;
	private int capacity;
	private Node useful;
	private Node useless;

	class Node {
		int key;
		int value;
		Node left;
		Node right;

		public String toString() {
			return key + ":" + value;
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.data = new HashMap<Integer, Node>(capacity);
	}

	public int get(int key) {
		if (data.containsKey(key)) {
			Node node = data.get(key);

			if (useful != useless && node != useful) {
				if (node == useless) {
					useless = node.left;
				}

				if (node.left != null) {
					node.left.right = node.right;
				}

				if (node.right != null) {
					node.right.left = node.left;
				}

				node.right = useful;
				if (useful != null) {
					useful.left = node;
				}
				node.left = null;
				useful = node;
			}

			return node.value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		Node node;
		if (get(key) != -1) {
			node = data.get(key);
			node.value = value;
		} else {
			if (data.size() >= capacity) {
				Node del = useless;
				useless = del.left;
				if (useless != null) {
					useless.right = null;
				}
				data.remove(del.key);
			}

			node = new Node();
			node.key = key;
			node.value = value;
			data.put(key, node);

			node.right = useful;
			if (useful != null) {
				useful.left = node;
			}
			node.left = null;
			useful = node;
			if (useless == null) {
				useless = node;
			}
		}
	}
}