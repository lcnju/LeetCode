// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

// Examples: 
// [2,3,4] , the median is 3

// [2,3], the median is (2 + 3) / 2 = 2.5

// Design a data structure that supports the following two operations:

// void addNum(int num) - Add a integer number from the data stream to the data structure.
// double findMedian() - Return the median of all elements so far.
// For example:

// add(1)
// add(2)
// findMedian() -> 1.5
// add(3) 
// findMedian() -> 2

public class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (minHeap.size() >= maxHeap.size() + 2) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() >= minHeap.size() + 2) {
            minHeap.add(maxHeap.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();