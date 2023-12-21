void PointerTest () {
        // Allocate three integers and two pointers
        int a = 1;
        int b = 2;
        int c = 3;
        int* p;
        int* q;

        // Here is the state of memory at this point
        // T1 -- Notice that the pointers start out bad...

        p = &a; // set p to refer to a
        q = &b; // set q to refer to b

        // T2 -- The pointers now have pointees
        // Now we mix things up a bit...
        c = *p; // retrieve p's pointee value (1) and put it in c
        p = q; // change p to share with q (p's pointee is now b)
        *p = 13; // dereference p to set its pointee (b) to 13 (*q is now 13)
        // T3 -- Dereferences and assignments mix things up
}



