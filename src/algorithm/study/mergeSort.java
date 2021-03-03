package algorithm.study;

public class mergeSort {

	public void mergeSort1(int[] arr, int n) {
		int n1 = n/2; 
		int n2 = n - n1;
		int split1[] = new int[n1];
		int split2[] = new int[n2];
		
		if(n > 1) {
			for(int i=0;i<n1;i++) 
				split1[i] = arr[i];
			
			for(int i=0;i<n2;i++)
				split2[i] = arr[i+n1];
			
			mergeSort1(split1,n1);
			mergeSort1(split2,n2);
			merge1(arr,split1,split2,n1,n2);
		}
	}
	
	public void merge1(int[] arr,int[] split1, int[] split2, int n1, int n2) {
		int i=0, j=0, k=0;
		while(i < n1 && j < n2) {
			if(split1[i] < split2[j]) 
				arr[k++] = split1[i++];
			else
				arr[k++] = split2[j++];
		}
		if(i>=n1) 
			for(int l=j;l<n2;l++)
				arr[k++] = split2[l];
		else
			for(int l=i;l<n1;l++)
				arr[k++] = split1[l];
		
	}
	
	public void mergeSort2(int[] arr, int low, int high) {
		
		if(low < high) {
			int mid = (low + high)/2;
			mergeSort2(arr,low,mid);
			mergeSort2(arr,mid+1,high);
			merge2(arr,low,mid,high);
		}
	}
	
	public void merge2(int[] arr, int low, int mid, int high) {
		int i=low, j=mid+1, k=0;
		
		int[] temp = new int[(high-low)+1];
		
		while(i <= mid && j <= high) {
			if(arr[i] <= arr[j]) 
				temp[k++] = arr[i++];
			else
				temp[k++] = arr[j++];
		}

		if(i>mid) 
			for(int l=j;l<=high;l++)
				temp[k++] = arr[l];
		else
			for(int l=i;l<=mid;l++)
				temp[k++] = arr[l];
		
		
		for(int l=low;l<=high;l++)
			arr[l] = temp[l-low];
	}

}
