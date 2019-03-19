import java.util.Arrays;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length - 1);
  }

  //helper
  public static void mergesort(int[]data, int lo, int hi){
    //if parameters unacceptable, stop method
    if (lo < hi){

    /*
    //make pivot the middle integer
    int p = (lo + hi) / 2;

    //make make left and right sides of pivot
    int[] left = new int[data.length / 2];
    //if an odd length, right side will be larger
    int[] right = new int[data.length - left.length];
    //fill left and right arrays
    for (int x = 0; x < left.length; x++){
      left[x] = data[x];
    }
    for (int x = 0; x < right.length; x++){
      right[x] = data[x + p];
    }
    */
    
    int p;
    if (data.length % 2 == 0){
        p = (data.length / 2); // so in array of size 4, pivot will be index 2
    }
    else{
        p = (data.length / 2) + 1; // in array of size 5, pivot witll be index 3 (right will be shorter than left by 1)
    }
    int[] left = Arrays.copyOfRange(data, lo, p); //pivot is excluded
    int[] right = Arrays.copyOfRange(data, p, (hi+1)); //pivot included
    //break arrays even further
    mergesort(left, 0, left.length - 1);
    mergesort(right, 0, right.length - 1);
    //keeps track of the left and right indices
    int lidx = 0;
    int ridx = 0;
    //keeps track of data index
    int idx = 0;
    //loops through data to store sorted left and right arrays
    while (idx < data.length){
      try{
        if (left[lidx] < right[ridx]){
          data[idx] = left[lidx];
          lidx++;
          idx++;
          //data[2 * idx + 1] = right[idx];
        }
        else{
          data[idx] = right[ridx];
          ridx++;
          idx++;
          //data[2 * idx + 1] = left[idx];
        }
      }
      catch(ArrayIndexOutOfBoundsException e){
        if (lidx < left.length){
          data[idx] = left[lidx];
          lidx++;
          idx++;
        }
        else if (ridx < right.length){
          data[idx] = right[ridx];
          ridx++;
          idx++;
        }
      }
    }
  }
  }
}
