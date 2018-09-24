package 二分查找;

public class BinarySearch {
    //二分查找（折半查找），
    public int BinarySearch1(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low+high) >>> 1;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    //二分查找，递归版本
    public int BinarySearch2(int[] arr, int target, int low, int high) {
        int mid = (low+high) >>> 1;
        if (low <= high){
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                return BinarySearch2(arr, target, low, mid-1);
            }else if(arr[mid] < target){
                return BinarySearch2(arr, target, mid+1, high);
            }
        }
        return -1;
    }

    // 查找第一个相等的元素
    public static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }
        return -1;
    }

    // 查找最后一个相等的元素
    public static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }
        return -1;
    }

    // 查找最后一个等于或者小于key的元素
    public static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 查找最后一个小于key的元素
    public static int findLastSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 查找第一个等于或者大于key的元素
    public static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 查找第一个大于key的元素
    public static int findFirstLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
