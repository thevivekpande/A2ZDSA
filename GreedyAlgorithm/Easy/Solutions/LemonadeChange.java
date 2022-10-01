class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0, tens=0;
        for(int i : bills){
            if(i==5)
                fives++;
            else if(i==10){
                tens++;
                if(fives>0) fives--;
                else return false;
            }else if(i==20){
                if(tens>0 && fives>0){
                    tens--;
                    fives--;
                }else if(fives>=3)
                    fives-=3;
                else return false;
            }
        }
        return true;
    }
}