package leetcode.editor.cn;

public class No_33 {
    public static void main(String[] args) {
        No_33 no_33 = new No_33();
        int[] nums = new int[]{4,5,6,7,8,0,1,2};
        int target = 0;
        int search = no_33.search(nums, target);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        if(nums.length == 1) return nums[0] == target ? 0 : -1;

        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[l] == nums[mid] && nums[mid] == nums[r]) {
                while (l != mid && nums[l] == nums[mid]) {
                    l++;
                }

                if(l == mid) {
                    l = mid+1;
                    continue;
                }
            }

            if(nums[l] != nums[mid]) {
                if(nums[l] < nums[mid]) {
                    if(nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }else {
                    if(nums[mid] < target && target<=nums[r]) {
                        l = mid +1;
                    }else {
                        r = mid - 1;
                    }
                }
            }else {
                if(nums[mid] < nums[r]) {
                    if(nums[mid] < target && target <= nums[r]) {
                        l = mid + 1;
                    }else {
                        r = mid - 1;
                    }
                }else {
                    if(nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
            }
        }

        return -1;
    }
}
