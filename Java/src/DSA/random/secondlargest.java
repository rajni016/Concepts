package DSA.random;

public class secondlargest {

        public static void findlargest(int arr[]){

            if(arr.length<=2){
                System.out.println("Array length is small");
               return ;
            }
            int first=Integer.MIN_VALUE;
            int second=0;

            int n= arr.length;
            for(int i=1;i<n;i++ ){
                if(arr[i]>first){
                    second=first;
                    first=arr[i];

                }

            }
            System.out.println("second largest element"+ second);

        }
        public static void main(String[] args) {
            int arr[] ={1,4,5};
            findlargest(arr);
        }
    }

