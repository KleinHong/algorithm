import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution47 {
    public List<List<Integer>> permute(int[] nums) {
        int[] flag = new int[nums.length];
        List<List<Integer>> allList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        //把每一层的最新的一个元素装起来，到下一个的时候进行判断，如果一样，就跳过。
        int[] level = new int[nums.length];
        for(int i = 0;i<level.length;i++)
            level[i] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        func(0,nums,level,list,flag,allList,nums.length);
        return allList;
    }
    public void func(int num,int[] nums,int[] level,List<Integer> list,int[] flag,List<List<Integer>> allList,int len){
        if(num==len){//当集合到len时就输出
            allList.add(new ArrayList<>(list)); //输出
        }else{
            for(int i = 0;i<len;i++){   
                if(flag[i]==0){ //没用过就添加
                    if(nums[i] == level[num])
                    {
                        continue;
                    }
                    flag[i] = 1;        //设置为已添加
                    list.add(nums[i]);  //添加到集合中
                    level[num] = nums[i];
                    num++;      //到下一层
                    func(num,nums,level,list,flag,allList,len);   //进入下一层
                    num--;  //下一层走完了回到这一层
                    if(num+1!=len)
                        level[num+1] =Integer.MAX_VALUE;
                    flag[i] = 0;    //给他设置成可用
                    list.remove(list.size()-1); //把它给踢走

                }
            }
        }
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution47 s=new Solution47();
		int[]nums= {0,0,0,1,9};
		System.out.print(s.permute(nums));
	}
}
