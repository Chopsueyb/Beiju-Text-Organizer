import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(in); // Creates input buffer
		String input;

		
	while( (input = bf.readLine()) != null) {
		
		char[] inputArray = input.toCharArray();

		@SuppressWarnings("rawtypes")

		Stack s = new Stack(input.length());
		
		// Pushes only Beiju text  to the Stack
		boolean skip = true;
		for (int i = 0; i < input.length(); i++) { 

			if (inputArray[i] == '[') {
				skip = false;
			}
			if (inputArray[i] == ']') {
				skip = true;
				continue;
			}

			if (!skip) {
				if (inputArray[i] != '[' && inputArray[i] != ']') { 
					s.push(inputArray[i]);
				}
			}

		}
		 // Pushes all text except for Beiju to stack
		skip = true;

		for (int i = 0; i < input.length(); i++) {

			if (inputArray[i] == '[') {
				skip = false;
			}
			if (inputArray[i] == ']') {
				skip = true;
				continue;
			}

			if (skip) {
				if (inputArray[i] != '[' && inputArray[i] != ']') {
					s.push(inputArray[i]);
				}
			}

		}

		StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();
        System.out.println(sb.toString());
	}
	}

}

