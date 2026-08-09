class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
            int frequency = map.get(nums1[i]);
            map.put(nums1[i], frequency+1);
            }else{
            map.put(nums1[i], 1);
            }
        }
        for(int j=0; j<nums2.length; j++){
            if(map.containsKey(nums2[j])){
                int frequency = map.get(nums2[j]);
                if(frequency > 0){
                list.add(nums2[j]);
                map.put(nums2[j], frequency-1);
                }
            }
        }
        int result[] = new int[list.size()];
        for(int k=0; k<list.size(); k++){
            result[k] = list.get(k);
        }
        return result;
    }
}