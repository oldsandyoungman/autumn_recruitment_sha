package MeiTuan;

/**
 * @author ShaLuwei
 * @create 2022-08-25 20:19
 */
public class sha1 {

    public static void main(String[] args) {


        int[] nums = {1,1,2,2,3,2,2,1};
        System.out.println(binarygetMax(nums));

    }

    public static int binarygetMax2(int[] A) {
        if (A == null){
            return -1;
        }
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if      (A[mid] > A[mid + 1]) right = mid;
            else if (A[mid] < A[mid + 1]) left = mid + 1;
            else {
                if (A[left] > A[right]) right--;
                else           left++;
            }
        }
        return A[left];
    }

    public static int binarygetMax(int[] A) {
        if (A == null){
            return -1;
        }
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(A[mid] > A[mid + 1]){
                right = mid - 1;
            }
            else if (A[mid] < A[mid + 1]){
                left = mid + 1;
            }else {
                if (A[left] > A[right]) {
                    right--;
                }else{
                    left++;
                }
            }
        }
        return A[left];
    }


}
