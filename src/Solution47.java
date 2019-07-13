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
        //��ÿһ������µ�һ��Ԫ��װ����������һ����ʱ������жϣ����һ������������
        int[] level = new int[nums.length];
        for(int i = 0;i<level.length;i++)
            level[i] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        func(0,nums,level,list,flag,allList,nums.length);
        return allList;
    }
    public void func(int num,int[] nums,int[] level,List<Integer> list,int[] flag,List<List<Integer>> allList,int len){
        if(num==len){//�����ϵ�lenʱ�����
            allList.add(new ArrayList<>(list)); //���
        }else{
            for(int i = 0;i<len;i++){   
                if(flag[i]==0){ //û�ù������
                    if(nums[i] == level[num])
                    {
                        continue;
                    }
                    flag[i] = 1;        //����Ϊ�����
                    list.add(nums[i]);  //��ӵ�������
                    level[num] = nums[i];
                    num++;      //����һ��
                    func(num,nums,level,list,flag,allList,len);   //������һ��
                    num--;  //��һ�������˻ص���һ��
                    if(num+1!=len)
                        level[num+1] =Integer.MAX_VALUE;
                    flag[i] = 0;    //�������óɿ���
                    list.remove(list.size()-1); //����������

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
