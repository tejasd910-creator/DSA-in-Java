class Solution {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract the maximum element one by one
        for (int i = n - 1; i > 0; i--) {
            swap(0, i, arr);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest, arr);
            heapify(arr, n, largest);
        }
    }

    private void swap(int first, int second, int arr[]) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}