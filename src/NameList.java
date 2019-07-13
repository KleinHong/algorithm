import java.util.ArrayList;
import java.util.List;

//
//public class Solution33 {
//	public int search(int[] nums, int target) {
//		if (nums.length == 0)
//			return -1;
//		int l = 0, r = nums.length - 1;
//		while (l <= r) {
//			int mid = (l + r) / 2;
//			if(nums[mid]==target)
//				return mid;
//			else if(nums[mid]<nums[r]) {
//				if(nums[mid]<target && nums[r]>=target)
//					l=mid;
//				else
//					r=mid-1;
//			}
//			else {
//				if(nums[l]<=target && target<nums[mid])
//					r=mid-1;
//				else
//					l=mid+1;
//			}
//		}
//		return -1;
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution33 s = new Solution33();
//		int[] nums = { 5,1,3};
//		System.out.print(s.search(nums, 5));
//	}
//
//}
public class NameList
{
    private List names = new ArrayList();
   // Arrays.sort(names);
    public synchronized void add(String name)
    {
        names.add(name);
    }
    public synchronized void printAll()     {
        for (int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) + " ");
        }
    }
 
    public static void main(String[]args)
    {
        final NameList sl = new NameList();
        for (int i = 0; i < 2; i++)
        {
            new Thread()
            {
                public void run()
                {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            } .start();
        }
    }
}