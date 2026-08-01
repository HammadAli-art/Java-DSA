//2011
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