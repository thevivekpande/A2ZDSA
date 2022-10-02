class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
        int i=0, j=0, start=0, minLen=Integer.MAX_VALUE, n=s.length(), counter=t.length();
        for(char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);
        for(;j<n;j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)-1);
            if(map.get(s.charAt(j))>=0) counter--;
            while(counter==0){
                if(j-i<minLen) { 
                    minLen=j-i;
                    start=i;
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i++))>0) counter++;
                }
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start, start+minLen+1);
    }
}