class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int frequency = map.get(arr[i]);
                map.put(arr[i], frequency+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        HashSet<Integer> frequencies = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int frequency = entry.getValue();
            if(frequencies.contains(frequency)){
                return false;
            }
            frequencies.add(frequency);
        }
        return true;
    }
}