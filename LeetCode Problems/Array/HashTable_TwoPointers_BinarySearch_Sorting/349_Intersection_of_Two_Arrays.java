class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        for(int j=0; j<nums2.length; j++){
            if(map.containsKey(nums2[j])){
                list.add(nums2[j]);
                map.remove(nums2[j]);
            }
        }
        int result[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}