package letcode.array;

public class MiddleSearch {
    public int search(int[] array,int target){
        int left =0;
        int right = array.length;
        while (left < right){
            int middle = left + (right - left)/2;
            if (array[middle] == target){
                return middle;
            }else if (array[middle] < target){
                left = middle+1;
            }else {
                right = middle;
            }
        }
        return  -1;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println(new MiddleSearch().search(array,4));
        System.out.println(new MiddleSearch().search(array,9));
    }
}
