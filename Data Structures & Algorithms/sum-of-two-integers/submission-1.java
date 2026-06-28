class Solution {
    public int getSum(int a, int b) {
        int xor;
        while(true){
            xor = a ^ b;
            int and = (a & b) << 1;
            if(and == 0){
                break;
            }
            a = xor;
            b = and;

        }
    
        return xor;
    }
}