package DSA.QucikSort;

public class SortArray {
    public static void  QuickSort(int [] array, int start,int end){
        if(end<=start) return;//Base Case
        int pivot=Partition(array,start,end);
        //All the elements less than pivot are placed to the left side
        //All the elements greater than pivot are placed to the right side
        //For every partioned array Quciksort function is called
        QuickSort(array,start,pivot-1);//Recursive Function for left half of the array
        QuickSort(array,pivot+1,end);//Recursive case for right half of the array


    }
    public  static int   Partition(int []arr, int start, int end){
        int i=start-1;
        int pivot=arr[end];
      for(int j=start;j<=end-1;j++){
          if(arr[j]<pivot){
              i++;
              int temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;
          }
      }
      i++;
      int temp=arr[i];
      arr[i]=arr[end];
      arr[end]=temp;

        return i;
    }
    public static void main(String []args){
        int []arr={4,9,8,2,10,1,1};
        QuickSort(arr,0,arr.length-1);
        for (int i:arr)
        {
            System.out.println(i+ "");
        }
    }
}
