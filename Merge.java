import java.util.Arrays;

public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length);
  }

  //helper
  public static void mergesort(int[]data, int lo, int hi){
    //if parameters unacceptable, stop method
    if (lo >= hi){
      return;
    }
    if (data.length < 30){
        insertionsort(data, lo, hi);
    }
    //make pivot the middle integer
    int p = data.length / 2;
    //make make left and right sides of pivot
    int[] left = new int[p];
    int[] right = new int[data.length - p];
    //fill left and right arrays
    for (int x = 0; x < left.length; x++){
      left[x] = data[x];
    }
    for (int x = 0; x < right.length; x++){
      right[x] = data[x + p];
    }

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
  //  }
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
