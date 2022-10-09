class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> set=new HashSet<>();
        for(String str:wordList)
            set.add(str);
        
        ArrayList<ArrayList<String>> res=new ArrayList<>();

        if(!set.contains(targetWord)) return res;
        Set<String> visited=new HashSet<>();
        Queue<ArrayList<String>> q=new LinkedList<>();
        
        visited.add(startWord);
        ArrayList<String> temp=new ArrayList<>();
        temp.add(startWord);
        q.offer(new ArrayList<>(temp));
        
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<String> temp1=new ArrayList<>();
            for(int i=0;i<size;i++){
                
                ArrayList<String> words=q.poll();
                String cur=words.get(words.size()-1);
                
                if(cur.equals(targetWord)){
                    res.add(new ArrayList<>(words));
                }
                
                for(int c=0;c<cur.length();c++){
                    for(char ch='a';ch<='z';ch++){
                        char[] charArr=cur.toCharArray();
                        charArr[c]=ch;
                        String str=new String(charArr);
                        if(set.contains(str) && !visited.contains(str)){
                            words.add(str);
                            temp1.add(str);
                            q.offer(new ArrayList<>(words));
                            words.remove(words.size()-1);
                        }
                    }
                }
            }
            
            for(String s : temp1)
                visited.add(s);
        }
        
        return res;
    }
}