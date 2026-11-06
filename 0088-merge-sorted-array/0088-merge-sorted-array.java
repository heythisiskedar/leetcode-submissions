class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();

        int idx1 = 0, idx2 = 0;
        while (idx1 < m && idx2 < n) {
            int curr1 = nums1[idx1];
            int  curr2 = nums2[idx2];
            if (curr1 < curr2) {
                list.add(curr1);
                idx1++;
            } else if (curr2 < curr1) {
                list.add(curr2);
                idx2++;
            } else {
                list.add(curr1);
                list.add(curr2);
                idx1++;
                idx2++;
            }
        }

        while (idx1 < m) {
            list.add(nums1[idx1++]);
        }

        while (idx2 < n) {
            list.add(nums2[idx2++]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = list.get(i);
        }
    }
}