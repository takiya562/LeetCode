package include;

import java.util.Arrays;

public class Sort {
    private static int getIndex(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp)    --high;
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp)     ++low;
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
    private static void QuickSort0(int[] nums, int low, int high) {
        if (low < high) {
            int index = getIndex(nums, low, high);
            QuickSort0(nums, low, index - 1);
            QuickSort0(nums, index + 1, high);
        }
    }
    public static void QuickSort(int[] nums) {
        QuickSort0(nums, 0, nums.length - 1);
    }

    private static void Swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    private static int[] get2Index(int[] nums, int low, int high) {
        int temp = nums[low];
        int i = low;
        while (i <= high) {
            if (nums[i] > temp) {
                Swap(nums, i, high);
                --high;
            }
            else if (nums[i] < temp) {
                Swap(nums, i, low);
                ++low;
                ++i;
            }
            else
                ++i;
        }
        int[] ret = new int[] {low, high};
        return ret;
    }
    private static void QuickSort3Way0(int[] nums, int low, int high) {
        if (low < high) {
            int[] indexes = get2Index(nums, low, high);
            QuickSort3Way0(nums, low, indexes[0] - 1);
            QuickSort3Way0(nums, indexes[1] + 1, high);
        }
    }
    public static void QuickSort3Way(int[] nums) {
        QuickSort3Way0(nums, 0, nums.length - 1);
    }

    private static void DualPivotQuickSort0(int[] nums, int left, int right) {
        if (left < right) {
            int pivot1 = Math.min(nums[left], nums[right]);
            int pivot2 = Math.max(nums[left], nums[right]);
            int low = left + 1;
            int great = right - 1;
            int k = low;
            while (k <= great) {
                if (nums[k] < pivot1) {
                    Swap(nums, k, low);
                    low = low + 1;
                }
                else if (nums[k] > pivot2) {
                    while (nums[great] > pivot2 && k < great)
                        great = great - 1;
                    Swap(nums, k, great);
                    great = great - 1;
                    if (nums[k] < pivot1) {
                        Swap(nums, k, low);
                        low = low + 1;
                    }
                }
                k = k + 1;
            }
            low = low - 1;
            great = great + 1;
            nums[left] = nums[low]; nums[low] = pivot1;
            nums[right] = nums[great]; nums[great] = pivot2;
            DualPivotQuickSort0(nums, left, low - 1);
            DualPivotQuickSort0(nums, low + 1, great - 1);
            DualPivotQuickSort0(nums, great + 1, right);
        }
    }
    public static void DualPivotQuickSort(int[] nums) {
        DualPivotQuickSort0(nums, 0, nums.length - 1);
    }

    private static void adjustBigHeap(int[] arr, int parent, int end) {
        int tmp = arr[parent];
        for (int child = 2 * parent + 1; child < end; child = parent * 2 + 1) {
            if (child < end - 1 && arr[child] < arr[child + 1])
                child++;
            if (arr[child] > tmp) {
                arr[parent] = arr[child];
                parent = child;
            }
            else
                break;
        }
        arr[parent] = tmp;
    }

    public static void bigHeapSort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; --i) {
            adjustBigHeap(arr, i, len);
        }
        for (int i = len - 1; i > 0; --i) {
            Swap(arr, 0, i);
            adjustBigHeap(arr, 0, i);
        }

    }

    private static void adjustSmallHeap(int[] arr, int parent, int end) {
        int tmp = arr[parent];
        for (int child = parent * 2 + 1; child < end; child = parent * 2 + 1) {
            if (child < end - 1 && arr[child] > arr[child + 1])
                child++;
            if (arr[child] < tmp) {
                arr[parent] = arr[child];
                parent = child;
            }
            else
                break;
        }
        arr[parent] = tmp;
    }

    public static void smallHeapSort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; --i) {
            adjustSmallHeap(arr, i, len);
        }
        for (int i = len - 1; i > 0; --i) {
            Swap(arr, 0, i);
            adjustSmallHeap(arr, 0, i);
        }
    }

    public static void main(String args[]) {
        int[] nums = {5,2,3,2,2,4,6,8};
        bigHeapSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("====================");
        smallHeapSort(nums);
        System.out.print(Arrays.toString(nums));
    }

}
