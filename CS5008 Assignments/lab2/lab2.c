#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

void crop_hi(int arr[], int len, int ceiling) {
	int x;
	for (x = 0; x<len; x++)
	{
		if (arr[x] > ceiling)
		{
			arr[x] = ceiling;
		}
	printf("%d",arr[x]);
	}	
	printf("\n");
}


void swap_mid_back(int arr[], int len) {
	int x;
	for (x = 0; x< len; x++)
	{
		int middle = len/2; 
		int element_middle;
		if (x == (middle-1))
		{
			element_middle = arr[x];
			arr[x] = arr[len-1];
			printf("%d",arr[x]);	
		}
		if (x ==(len-1))
		{
			arr[x] = element_middle;
			printf("%d",arr[x]);
		}
		else
		{
			printf("%d",arr[x]);
	
		}
	}
	printf("\n");
}


// This function failed because I couldnt figure out how to convert
// the characters into an array

//void redact(char* str) 
//{
//	char str1[] = str;
//	int len = sizeof(str1) / sizeof(int);
//	int x;
//	for (x=0; x<len;x++)
//	{
//		if (str1[x]>-1)
//		{
//			str1[x] = "*";
//		}
//		printf("%d",str1[x]);
//	}
//	printf("\n");

			
//}

int main()
{
	int arr[] = {1,2,3,4,5,6,7};
	int len = 7;
	int ceiling = 3;
	crop_hi(arr,len,ceiling);
	
	int newarr[] = {1,2,3,4,5,6,7};
	int newlen = 7;
	swap_mid_back(newarr, newlen);

	//char* sentence = "Tom Brady threw 100 touchdowns";
	//redact(sentence); 	



}



