class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l =0 ; 
        Set<Character> set = new HashSet<>();
         int maxlength = 0;
         for(int r=0; r<s.length(); r++){
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }

                set.add(s.charAt(r));

             maxlength = Math.max(maxlength,r-l +1);
         }

         return maxlength;
    }
}
