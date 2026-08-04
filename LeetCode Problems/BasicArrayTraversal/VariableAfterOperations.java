/*
LeetCode 2011
Final Value of Variable After Performing Operations

This problem says that we start with
the value of x = 0. We need to perform
all the given operations and return
the final value of x.
*/

class VariableAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String nums : operations) {
            if (nums.contains("++")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        VariableAfterOperations v = new VariableAfterOperations();
        String arr[] = { "--X","X++","X++" };
        System.out.println(v.finalValueAfterOperations(arr));
    }
}