class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highestAltitude = 0;
        for(int i:gain){
            currentAltitude += i;
            if(currentAltitude > highestAltitude){
                highestAltitude = currentAltitude;
            }
        }
        return highestAltitude;
    }
}