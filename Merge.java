public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length - 1);
  }

  //helper
  public static void mergesort(int[]data, int lo, int hi){
    if (lo > hi){
      return;
    }
    int p = (lo + hi) / 2;
    int[] left = new int[data.length / 2];
    int[] right = new int[data.length - left.length];
    mergesort(left, lo, p);
    mergesort(right, p + 1, hi);
    for (int x = 0; x < left.length; x++){
      left[x] = data[x];
    }
    for (int x = 0; x < right.length; x++){
      left[x] = data[x + p];
    }
  }
}
