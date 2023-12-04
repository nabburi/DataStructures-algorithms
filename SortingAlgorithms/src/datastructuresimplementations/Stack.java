package datastructuresimplementations;

public class Stack<T> {

	public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	public static final int INITIAL_ARRAY_SIZE = 16;

	private T[] data;
	private int top = 0;
	private int capacity = INITIAL_ARRAY_SIZE;

	public Stack() {
		this(INITIAL_ARRAY_SIZE);
	}

	@SuppressWarnings("unchecked")
	public Stack(int capacity) throws IllegalArgumentException {
		if (capacity < 1) {
			throw new IllegalArgumentException("Stack capacity must be 1 or greater");
		}

		if (capacity > MAX_ARRAY_SIZE) {
			throw new IllegalArgumentException("Stack capacity greater than maximum array size");
		}

		data = (T[]) new Object[capacity];

	}

	public void push(T element) {
		if (top + 1 > data.length) {
			expandSize();
		}
		data[top++] = element;
	}

	public T pop() {
		if (top == 0) {
			throw new IllegalArgumentException("Stack is empty");
		}
		if (top - 1 == data.length / 4) {
			resize();
		}
		T topItem = data[top - 1];
		data[--top] = null;
		return topItem;
	}

	public T peek() {
		if (top == 0) {
			throw new IllegalArgumentException("Stack is empty");
		}
		return data[top-1];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public int size() {
		return capacity;
	}

	private void expandSize() {
		int curr_size = top + 1;
		if (curr_size < MAX_ARRAY_SIZE) {
			@SuppressWarnings("unchecked")
			T[] new_array = (T[]) new Object[curr_size * 2];
			for (int i = 0; i < curr_size; i++) {
				new_array[i] = data[i];
			}
			data = new_array;
			capacity = data.length;
		}else {
			throw new IllegalArgumentException("Stack capacity greater than maximum array size");
		}
	}

	private void resize() {
		@SuppressWarnings("unchecked")
		T[] new_array = (T[]) new Object[capacity/2+1];
		System.arraycopy(data, 0, new_array, 0, new_array.length);
		data = new_array;
		capacity = data.length;
	}

}
