package algorithm;

public class Sort {

    /**
     * 冒泡排序
     * @param data
     */
    public static void maopaoSort(int [] data){
        int len = data.length;
        for(int i = 0; i < len - 2; i++){
            for(int j = 0; j < len - i -1; j++){
                if (data[j] < data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * @param data
     */
    public static void quickSort(int[] data){
        quickSort2(data, 0, data.length - 1);
    }

    /**
     * 插入排序
     * @param data
     */
    public static void insertSort(int[] data){
        int len = data.length;
        for(int i = 0; i < len; i++){
            int currVal = data[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && data[preIndex] > currVal){
                data[preIndex + 1] = data[preIndex];
                preIndex--;
            }
            data[preIndex + 1] = currVal;
        }
    }

    /**
     * 选择排序
     * @param data
     */
    public static void selectSort(int[] data){
        int len = data.length;
        for(int i = 0; i < len; i++){
            int index = i;
            int maxValue = data[index];
            for(int j = index; j < len; j++){
                if(data[j] > maxValue){
                    index = j;
                    maxValue = data[j];
                }
            }
            int temp = data[i];
            data[i] = data[index];
            data[index] = temp;
        }
    }

    /**
     * 快速排序
     * 两端扫描的方式
     * @param data
     * @param left
     * @param right
     */
    public static void quickSort(int[] data, int left, int right){
        /**
         * 不满足条件，如果left > right压根就没有排序的必要
         */
        if(left > right){
            return ;
        }
        /**
         * 选定基准数，一般选定待排序区域最左边或者最右边的数
         * 但是这里有一个问题就是
         * 如果这个基准数刚好就是这个待排序数组里面最大或者最小的数，那么就很浪费效率
         * 所以这里有两种优化方法：三元取中，直接插入
         */
        int base = data[left];
        int i = left;
        int j = right;
        while(i != j){
            /**
             * 如果选定了的基准数是最左边的数，就从右边开始动
             * 这里还要判断i是否小于j,如果这个条件得不到满足，就白搭了..
             */
            while(data[j] >= base && i < j){
                j--;
            }
            while(data[i] <= base && i < j){
                i++;
            }
            /**
             * 程序运行到这里，代表j已经停下来，i也停了下来，这时候需要交换data[i]和data[j]这两个数
             */
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
        /**
         * 程序运行到这里 i 和 j已经相遇，这时候需要交换基准数和data[j]
         */
        data[left] = data[i];
        data[i] = base;
        quickSort(data, left, i - 1);
        quickSort(data, i + 1, right);
    }

    /**
     * 快速排序
     * 填坑法
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSort2(int[] arr, int l, int r){
        /**
         * 递归的边界条件，当l==r的时候元素个数为1
         */
        if (l < r){
            int pivot = arr[l];
            int i = l + 1, j = r;
            while(i < j){
                    while(i < j && arr[j] > pivot){
                        j--;
                    }
                    arr[i] = arr[j];
                    while(i < j && arr[i] <= pivot){
                        i++;
                    }
                    arr[j] = arr[i];
                }
                arr[i] = pivot;
                quickSort2(arr, l, i - 1);
                quickSort2(arr, i + 1, r);
            }
    }
}
