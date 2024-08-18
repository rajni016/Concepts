package DSA.BinarySearch;

public class SearchInsertPosition {

    public int findInsertPosition(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        System.out.println(low);
        return low;

}

    public static void main(String[]args ){
        SearchInsertPosition obj=new SearchInsertPosition();
        int arr []={1,5,6,7,8};
        obj.findInsertPosition(arr,6);

    }
}