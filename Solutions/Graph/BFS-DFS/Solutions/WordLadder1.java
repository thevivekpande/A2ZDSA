class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> set=new HashSet<>();
        for(String str:wordList)
            set.add(str);
        if(!set.contains(targetWord)) return 0;
        
        int res=1;
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        
        visited.add(startWord);
        q.offer(startWord);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur=q.poll();
                if(cur.equals(targetWord)) return res;
                for(int c=0;c<cur.length();c++){
                    for(char ch='a';ch<='z';ch++){
                        char[] charArr=cur.toCharArray();
                        charArr[c]=ch;
                        String str=new String(charArr);
                        if(set.contains(str) && !visited.contains(str)){
                            visited.add(str);
                            q.offer(str);
                        }
                    }
                }
            }
            res++;
        }
        
        return 0;
    }
}