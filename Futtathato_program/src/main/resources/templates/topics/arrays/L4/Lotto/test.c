#define main main1
#include "main.c"
#undef main

#define MERET 5

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void feltoltTeszt()
{
    int lotto[MERET];
    int i;
    feltolt(lotto);
    for(i=0; i<MERET; i++) {
        CU_ASSERT_TRUE(lotto[i]<=90 && lotto[i] >0)
    }


    return ;
}


int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("feltolt_test", 0, 0);
    CU_add_test(suite, "feltolt function", feltoltTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
