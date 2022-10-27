变形的最小栈
实现一个这样的栈，这个栈除了可以进行普通的push、pop操作以外，还可以进行getMin的操作，getMin方法被调用后，会返回当前栈的最小值。栈里面存放的都是 int 整数，并且数值的范围是 [-100000, 100000]。要求所有操作的时间复杂度是 O(1)。
附加：如果空间复杂度也能O(1)的话可加分


算法流程：
初始化： 辅助栈 stackstack ，弹出序列的索引 ii ；
遍历压栈序列： 各元素记为 numnum ；
元素 numnum 入栈；
循环出栈：若 stackstack 的栈顶元素 == 弹出序列元素 popped[i]popped[i] ，则执行出栈与 i++i++ ；
返回值： 若 stackstack 为空，则此弹出序列合法。


致命缺点：由于存储差值，无法解决溢出的可能问题
```
public class MinStack3 {
	private Stack<Integer> diff = new Stack<Integer>();
	private int minValue;

	public void push(int x) {
		if (diff.isEmpty()) {
			minValue = x;
			diff.push(0);
		} else {
			int compare = x - minValue;
			diff.push(compare);
			minValue = compare < 0 ? x : minValue;
		}
	}

	public void pop() {
		int top = diff.peek();
		minValue = top < 0 ? (minValue - top) : minValue;
		diff.pop();
	}

	public int top() {
		int top = diff.peek();
		return top > 0 ? top + minValue : minValue;
	}

	public int getMin() {
		return minValue;
	}
}

```