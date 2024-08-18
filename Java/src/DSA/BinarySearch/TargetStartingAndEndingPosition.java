package DSA.BinarySearch;

public class TargetStartingAndEndingPosition {
    public int [] targetelement(int arr[],int target){
        //searching left half of array
        int low=0;
        int high=arr.length;
        int [] result={-1,-1};
        while(low<high){
            int mid=low+(high-low)/2;
            System.out.print(arr[mid]);
            if(arr[mid]<target){

                low=mid+1;
              //  System.out.println(low);

            }
            else{
                high=mid;
             //   System.out.println(high);
            }

        }

        if (low ==arr.length || arr[low]!=target) {

            return result;

        }
        //searching right half of array
        result[0]=low;
        low=0;

        high=arr.length;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=target){
                low=mid +1;
                System.out.println(low);
            }
            else{
                high=mid;
              //  System.out.println(high);
            }
        }
        result[1]=low-1;
        System.out.println(result[0]);
        System.out.println(result[1]);


        return result;
    }

    public static void main(String []args){
        TargetStartingAndEndingPosition obj=new TargetStartingAndEndingPosition();
       int []nums={1,2,3,3,3,5,7,9,11};
        obj.targetelement(nums,12);

    }
}






