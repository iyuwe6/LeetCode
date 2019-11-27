import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

    //暴力法
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + i; j <= n; j++){
                if(allUnique(s, i, j)){
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }
    boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            if(set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    //滑动窗口hashset
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //滑动窗口hashmap
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }
}