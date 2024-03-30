import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(in); // Creates input buffer
		String input;

		while ((input = bf.readLine()) != null) {

			char[] inputArray = input.toCharArray();

			@SuppressWarnings("rawtypes")

			Stack s = new Stack(input.length());
			Queue<Character> qn = new Queue<>(input.length());
			Queue<Character> qc = new Queue<>(input.length());

			boolean skip = true;
			for (int i = 0; i < input.length(); i++) {
				

				if (inputArray[i] == '[') {
					skip = false;
					StringBuilder qcstring = new StringBuilder(); 
		            while (!qc.isEmpty()) {
		                qcstring.append(qc.deQueue());
		            }
		            s.push(qcstring.toString());
				}
				
				if (inputArray[i] == ']') {
					skip = true;
					
					StringBuilder qcstring = new StringBuilder(); 
		            while (!qc.isEmpty()) {
		                qcstring.append(qc.deQueue());
		            }
		            s.push(qcstring.toString());
		            continue;
				}
				
				if (inputArray[i] != '[' && inputArray[i] != ']') { //Biju storing char
					if (!skip) {
						qc.enQueue(inputArray[i]);
			
					} else {//Normal Text and biju string Store
						
						qn.enQueue(inputArray[i]);
					}
				}
			}
			StringBuilder qcstring = new StringBuilder();
            while (!qc.isEmpty()) {
                qcstring.append(qc.deQueue());
            }
            s.push(qcstring.toString());
			
			
			StringBuilder sb = new StringBuilder();
			while (!s.isEmpty()) {
                sb.append(s.pop());
            }
            while (!qn.isEmpty()) {
                sb.append(qn.deQueue());
            }
            System.out.println(sb.toString());
		}
	}

}
class Queue<T> { //Queue class implemented using a Circular array 

	T[] queue;//Queue values constructor
	int size;
	int head;
	int tail;
	int length;

	public Queue(int size) {//Queue initializer
		if (size > 0) {
			this.size = size;

			queue = (T[]) new Object[size]; // creating array of generic type
		} else
			System.out.println("Error: Invalid Size");//Must be bigger than 0
	}

	public void enQueue(T data) {
		if (!isFull()) {
			queue[tail] = data;
			tail = (tail + 1) % size;
			length++;
		} else
			System.out.println("enQueue(" + data + ")-Error: Queue is Full");
	}

	public T deQueue() {

		T data = queue[head];

		if (!isEmpty()) {
			head = (head + 1) % size;
			length--;
		} else {
			System.out.println("deQueue-Error: Queue is Empty");
		}
		return data;

	}

	public T peek() {
		if (!isEmpty()) {

			T data = queue[head];
			return data;
		} else
			return null;
	}

	public int getLength() {//Queue current length
		return length;
	}

	public boolean isEmpty() {
		return getLength() == 0;
	}

	public boolean isFull() {
		return getLength() == size;
	}

	public void print() {
		for (int i = 0; i < length; i++) {
			System.out.print(queue[(head + i) % size] + " ");
		}
		System.out.println();
	}
}
class Stack<T> { // Stack Class

	T[] stack;
	int size;
	int top = 0;

	@SuppressWarnings("unchecked")
	public Stack(int data) {

		this.size = data;

		if (size > 0) {
			stack = (T[]) new Object[this.size]; // creating array of generic type
		} else
			System.out.println("Error: Invalid Size");// Must be bigger than 0
	}

	public void push(T data) {
		if (top != size) {
			stack[top] = data;
			top++;
		} else
			System.out.println("Stack is Full");
	}

	public T pop() {
		T data = null;

		if (isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			top--;
			data = stack[top];
			stack[top] = null;
		}
		return data;
	}

	public T peek() {
		T data;
		data = stack[top - 1];
		return data;
	}

	public int gethight() {
		return top;
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	public void print() {

		for (int i = 0; i < size; i++) {
			if (stack[i] != null) {
				System.out.print(stack[i]);
			} else
				continue;
		}
	 System.out.println();
	}
}