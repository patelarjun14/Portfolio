#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"
#include <time.h>


// Here we need to define the structure for list array
// Functions will be below
typedef struct AList{
         int* list;
         int length;
}AList, *AListPtr;



// This is the SwapFunction, it will swap the current node 
// and the selected node
void SwapFunction(LinkedListPtr list,LinkedListNode *current_node, LinkedListNode *selected_node)
{
	// Take data from current node and store it into x
	int x;
	x = current_node->data;
	
	// Swap selected_node->data and current_node->data
	current_node->data = selected_node->data;
	selected_node->data = x;
}


// This is Selection Sort. We have 4 different nodes:
// index_node = iterates through entire list (mainly used for first while loop)
// current_node = iterates through entire list but will be switch with selected_node
// selected_node = selects the node that needs to be switched with the current_node
// position_node = helps select the selected_node 
void Sort(LinkedListPtr list)
{  
	// Check base cases
	if(list == NULL){
		printf("List is NULL");
		return;
	}
	else if(list->head == NULL){
		printf("List is NULL or head is NULL");
		return;
	}
	else
	{
		// Here we are setting the index, current, selected, and position
		LinkedListNodePtr index_node = list->head;
		LinkedListNodePtr current_node = list->head;
		LinkedListNodePtr selected_node = list->head;
		LinkedListNodePtr position_node = list->head->next;

		// While loop to iterate through the entire list for index node
		// as long as next node is not NULL
		while (index_node->next != NULL)
		{ 
			// While loop to iterate through list for position node	as long
			// as next node is not NULL
			while(position_node->next != NULL)
			{
				// If the selected node is less than or equal to position node,
				// let the position node continue to iterate through
				if((selected_node->data) <= (position_node->data))
				{
					position_node = position_node->next;
				}
				// If the selected node is greater than position node,
				// make the selected node equal to the position node,
				// push the position node to the next node
				else if((selected_node->data) > (position_node->data))
				{
					selected_node = position_node;
					position_node = position_node->next;
				}
		
			}
			// After the position node has gone through the remaining list
			// and helped select the smallest value, use the SwapFunction
			// to swap the current_node and selected_node
			SwapFunction(list,current_node, selected_node);
		
			// Repostion all the nodes to start the next iteration
			current_node = current_node->next;	
			index_node = index_node->next;
			selected_node = current_node;
			position_node = current_node->next;
		} 
		// SPECIAL CASE: Once iteration reaches to the last node,
		// take the current node and the selected node and let both
		// iterate through the list. Once it reaches the end, it will
		// swap the last 2 integers correctly. If current_node > selected_node
		// use the SwapFunction
		current_node = list->head;
		while(current_node->next != NULL){
			if(current_node->data > selected_node->data) {
				SwapFunction(list,current_node, selected_node);
			}
			current_node = current_node->next;
		}	
	}
	return;

}

// Below was my PrintReport Function to print the time it took
// to sort based on the length. I have kept my work here to get 
// some credit. As mentioned during the lab on 3/7/2022, I was
// experiencing a unusual segmentation error that could not be solved

// This will print a report for the Sort() function
// Select the max length you would like to test

//void PrintReportLength(int length) {
		
	// Create Lists
//	LinkedListPtr lengthlist = CreateLinkedList(); //prints length of the lists
//	LinkedListPtr listdata = CreateLinkedList(); // generate a list
//	LinkedListPtr listtime = CreateLinkedList(); // stores the amount per list:

//	int i=0;
//	int y=0;
//	int x =0;
//	while(i<=length){
//		AppendLinkedList(lengthlist,i);
//		i = i+5;
//		while(y<=i){
//			int r = random() % 50 +1;
//			AppendLinkedList(listdata,r);
//			y++;
//		}
//		PrintLinkedList(listdata);
//		clock_t t;
//		t=clock();
//		Sort(listdata);
//		t=clock()-t;
//		int datatime = ((int)t)/CLOCKS_PER_SEC;
//		//AppendLinkedList(listtime,datatime);
//	}
//	printf("THIS IS THE LIST");
//	PrintLinkedList(lengthlist);
//	LinkedListNodePtr z= lengthlist->head;
//	while(x<=length){
//		printf("%d  ",z->data);
//		z = z->next;
//		x = x+5;
//	}
//	printf("\n");
//}





// Below was my first attempt to create a Report

// Void PrintReport(int a, int length)
//{
	// Set timer
//	clock_t t;

	//Create Lists
//	LinkedListPtr list = CreateLinkedList(); //real list
//	LinkedListPtr time = CreateLinkedList(); //time list
//	LinkedListPtr lengthlist = CreateLinkedList(); // length list
	
	// If 1, test algorithm 1 (sort function)
//	if(a == 1){
		// Store the length data into list
//		int i =5;
//		while(i <length) {
//			AppendLinkedList(lengthlist,i);
			// Store random numbers into list
//			int num =0;
//			while(num <i){
//				int rannumber = random() % 50 +1;
//				AppendLinkedList(list,rannumber);
//				num++;
//			}
//			// Test how long it takes to sort
//			t =clock();
//			Sort(list);
//			t = clock()-t;
//			double time_taken = ((double)t)/CLOCKS_PER_SEC;
			// Store data into time list
//			AppendLinkedList(time,t);
			// Add 5 more to next list
//			i=i+5;
//		}
		// After data is gathered, we need to print it based on format
  //              printf("      ");
//		LinkedListNodePtr lengthdata = lengthlist->head;
//		LinkedListPtr a = list->num_elements;
//		int lengthoflengthlist = a;
//		i=0;
		// We need to iterate through the lenght of the list
//		while(i<lengthoflengthlist){
			// If length data is less than 10, add a space
//			if(lengthdata->data <10){
//				printf("%d  ",lengthdata->data);
//				lengthdata = lengthdata->next;
//				i++;
//			}
			// If length data is more than 10, take away a space
//			else if(lengthdata->data >= 10) {
//				printf("%d ",lengthdata->data);
//				lengthdata = lengthdata->next;
//				i++;
//			}
//		}
		// Print the split in the report based on length
  //              printf("\n      ");
   //             for(i =0; i<length;i++)
  //              {
 //                       printf("---");
//		}
		// Print the bottom half of the report
//		LinkedListNodePtr timedata = time->head;
//		LinkedListPtr y = list->num_elements;
//		int lengthlist = y;
//		printf("Alg A:  ");
//		for(i=0;i<y;i++){
//			printf("%d  ", timedata->data);
//			timedata = timedata->next;
//		}			
//	}

//	else if(a == 2){
//		int i =0;
//		while(i <length) {
//                        AppendLinkedList(lengthlist,i);
//                        int num = 0;
//			AList* alist = create(0);
//                        while(num <i){
//                                int rannumber = random() % 50 +1;
//                                add(alist,rannumber);
//				num++;
//			}
//                        t =clock();
//			quicksort(alist);			
//                        t = clock()-t;
//                        double time_taken = ((double)t)/CLOCKS_PER_SEC;
//                        AppendLinkedList(time,t);
//                        i=i+5;
//                }
//                printf("      ");
//                LinkedListNodePtr lengthdata = lengthlist->head;
//                LinkedListPtr lengthlengthlist= list->num_elements;
//                while(i<lengthlengthlist->num_elements){
//                        if(lengthdata->data <10){
//                                printf("%d  ",lengthdata->data);
//                                lengthdata = lengthdata->next;
//                                i++;
//                        }
//                        else if(lengthdata->data >= 10) {
//                                printf("%d ",lengthdata->data);
//                                lengthdata = lengthdata->next;
//                                i++;
//                        }
//                }
//                printf("\n      ");
//                for(i =0; i<length;i+5)
//                {
//                        printf("---");
//                }
//		LinkedListNodePtr timedata = time->head;
//                printf("Alg A:  ");
//                for(i=0;i<lengthlist;i+5){
//                        printf("%d  ", timedata->data);
//                        timedata = timedata->next;
//                }
//        }



//}


// Below is the quicksort function that was used in class
void printAll(AList* alist) 
{
	int i;
	// Iterate through length of list
	// Print the integer
	for(i=0; i<alist->length; i++) {
		printf("%d, ",alist->list[i]);
	}
	printf("\n");
}

void swap(AList* alist,int left, int right)
{
	// Swap the left and right integers
	int temp = alist->list[left];
	alist->list[left] = alist->list[right];
	alist->list[right] = temp;
}


void quicksort(AList* alist, int start, int end)
{
	// This checks for base case and will return nothing
	if(start >= end) {
		return;
	}

	// If else, use partition and quicksort functions
	// to sort data
	int pivot = partition(alist, start, end);
	quicksort(alist, start, pivot - 1);
	quicksort(alist, pivot +1, end);
}

int partition(AList* alist, int pivot, int end)
{
	// Check for base cases
	if(pivot == end || (end - pivot == 1 && alist->list[pivot] < alist->list[end])) {
		return pivot;
	}
	// If value to right is larger, then swap with the end
	if(alist->list[pivot] < alist->list[pivot+1]) {
		swap(alist, pivot+1, end);
		return partition(alist, pivot, end-1);
	// If value to right is smaller, swap with the pivot
	} else {
		swap(alist, pivot, pivot +1);
		return partition(alist, pivot+1, end);
	}
}

void add(AList* alist, int val) 
{
	// Allocate memory
	int* arr = (int*)malloc(sizeof(int)*(alist->length+1));
	int* temp = alist->list;

	// Iterate through length
	int i;
	for(i=0; i<alist->length;i++) {
		arr[i] = alist->list[i];
	}
	
	// Add element at the end
	arr[alist->length] = val;
	
	// Update attributes 
	alist->list = arr;
	alist->length = alist->length+1;
	
	//Free temp
	free(temp);
}

AList* create(int val) 
{
	// Allocate memeory for first value
	int* l = (int*)malloc(sizeof(int));
	l[0]= val;
	
	// Allocate memory for the list
	AList* alist = (AList*)malloc(sizeof(AList));
	
	// Update attributes
	alist->list = l;
	alist->length = 1;
	
	return alist;
}













