#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void primTeszt()
{

CU_ASSERT_FALSE(prim(4));
CU_ASSERT_FALSE(prim(100));
CU_ASSERT_TRUE(prim(101));
CU_ASSERT_TRUE(prim(11));

    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("prim_test", 0, 0);
    CU_add_test(suite, "prim function", primTeszt);

    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}

