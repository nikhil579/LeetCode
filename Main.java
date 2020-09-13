class Main {
public static int trap(int[] height) {
   int max=0;
    for(int i=0;i<height.length;i++)
    {
        int leftmax=0;
        int rightmax=0;
            //left side maximum height
            for(int j=0;j<i;j++)
            {
                if(height[j]>leftmax)
                {
                    leftmax=height[j];
                }
                
            }
            //right side maximum value
            for(int j=height.length-1;j>i;j--)
            {
                if(height[j]>rightmax)
                {
                    rightmax=height[j];
                }
            }
        //System.out.println(Math.min(leftmax,rightmax)-height[i]);
        if(Math.min(leftmax,rightmax)-height[i]>0)
        {
         max+=Math.min(leftmax,rightmax)-height[i];   
        }
    }
    return max;
}
public static int fastTrap(int[] height)
    {
        int res=0;
        int level=0;
        int l=0;
        int r=height.length-1;
        while(l<r)
        {
            int lower=height[ height[l] < height[r] ? l++ : r--];
            level = Math.max(level,lower);
            res += level - lower;
        }
    return res;
    }
    public static void main(String[] args)
    {  
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1}; //{6,4,2,0,4,6,4,8};
        System.out.println(fastTrap(arr));
        System.out.println(trap(arr));
    }
}
