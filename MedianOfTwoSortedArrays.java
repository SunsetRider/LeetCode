public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[] C = new int[A.length + B.length];
        
        // 1. merge A and B to C
        if(A.length == 0)
            C = B;
        else if(B.length == 0)
            C = A;
        else{
            int indexA = 0;
            int indexB = 0;
            for(int i = 0; i < A.length + B.length; i++){
                // consider the situation of A or B is run out of elements
                if(indexB == B.length)
                    C[i] = A[indexA++];
                else if(indexA == A.length)
                    C[i] = B[indexB++];
                else if(A[indexA] < B[indexB])
                    C[i] = A[indexA++];
                else
                    C[i] = B[indexB++];
            }
        }
        // 2. find the merged array's median        
        return findMedian(C);
    }

    public double findMedian(int C[]){
        double median;
        if(C.length % 2 == 0)
            median = (double)(C[C.length/2]+C[C.length/2-1])/2;
        else
            median = C[(C.length-1)/2];
        
        return median;
    }
    
}
