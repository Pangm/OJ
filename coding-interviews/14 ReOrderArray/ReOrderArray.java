
public class Solution {
    public void reOrderArray(int [] array) {
        int lastIndexEven = -1;
        
        for (int i = 0; i < array.length; ++i) {
            if (isOdd(array[i])) {
                // odd number
                ++lastIndexEven;
                if (lastIndexEven != i) {
                    /*// swap
                    int temp = array[lastIndexEven];
                    array[lastIndexEven] = array[i];
                    array[i] = temp;
                    */
                    int temp = array[i];
                    for (int j = i; j > lastIndexEven; --j) {
                        array[j] = array[j-1];
                    }
                    array[lastIndexEven] = temp;
                }
            }
        }
        
        /*
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            while (left < right && isOdd(array[left])) 
                ++left;
            while (left < right && !isOdd(array[right])) 
                --right;
            
            // swap
            if (left < right) {
            	swap(array, left, right);
            }
        }
        */
        
    }
    
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public boolean isOdd(int n) {
        return (n & 0x01) == 1;
    }
}