import java.util.*;
class TrappingRainwater
{
    // public static boolean asc_Check(int height[])
    // {
    //     int i;
    //     for (i=0;i<height.length-1;i++)
    //     {
    //         if (height[i]>height[i+1])
    //             return true;
    //     }
    //     return false;
    // }
    // public static boolean desc_Check(int height[])
    // {
    //     int i;
    //     for (i=0;i<height.length-1;i++)
    //     {
    //         if (height[i]<height[i+1])
    //             return true;
    //     }
    //     return false;
    // }
    public static int trapped_Water(int height[])
    {
        int i,waterLevel,trappedWater=0,width=1;
        int lmax[]=new int[height.length];
        int rmax[]=new int[height.length];
        //left max array
        lmax[0]=height[0];
        for (i=1;i<height.length;i++)
        {
            lmax[i]=Math.max(lmax[i-1],height[i]);
        }

        //right max array
        rmax[height.length-1]=height[height.length-1];
        for (i=height.length-2;i>=0;i--)
        {
            rmax[i]=Math.max(rmax[i+1],height[i]);
        }
        // calculation water level
        for (i=0;i<height.length;i++)
        {
            waterLevel=Math.min(lmax[i],rmax[i]);
            trappedWater=trappedWater+((waterLevel-height[i])*width);
        }
        return trappedWater;
    }
    public static void main(String args[])
    {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int x=trapped_Water(height);
        // boolean a=asc_Check(height);
        // boolean b = desc_Check(height);
        if ((height.length<3)/*||(a==true)||(b==true)*/)
            System.out.println("No Rain Water Trapped");
        else
            System.out.println("Amount of Rainwater Trapped: "+x);
    }
}