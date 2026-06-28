class Solution {
    public int missingNumber(int[] arr) {
         int n=arr.length;
         int xor1=0;
         for(int i=0;i<n;i++){
            xor1=(xor1^i) ^ arr[i];
         }
         xor1=xor1^n;

         return xor1;
    }
}
