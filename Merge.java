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

      int p;
      //make pivot the middle integer
      if (data.length % 2 == 0){
        p = data.length / 2;
      }
      else{
        //makes left side bigger if odd
        p = data.length / 2 + 1;
      }

      //make make left and right sides of pivot

      int[] left = Arrays.copyOfRange(data, lo, p); //pivot is excluded
      int[] right = Arrays.copyOfRange(data, p, hi + 1); //pivot included


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

  public static void insertionsort(int[] data, int lo, int hi){
    for (int x = lo + 1; x <= hi; x++){
      int xval = data[x];
      int y = x - 1;
      for (; y >= lo && xval < data[y]; y--){
        data[y+1] = data[y];
      }
      data[y+1] = xval;
    }
  }
}
