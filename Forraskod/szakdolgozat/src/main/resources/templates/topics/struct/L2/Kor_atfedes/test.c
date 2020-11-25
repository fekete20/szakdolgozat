#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void atfedTeszt()
{
    Kor k1;
    Kor k2;
    Kor k3;

    k1.r = 2;
    k1.x = 4;
    k1.y = 5;

    k2.r = 4;
    k2.x = 4;
    k2.y = 5;

    k3.r = 3;
    k3.x = -7;
    k3.y = -4;

    CU_ASSERT_TRUE(atfed(k1, k2));
    CU_ASSERT_FALSE(atfed(k1, k3));
    CU_ASSERT_FALSE(atfed(k2, k3));

    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("atfed_test", 0, 0);
    CU_add_test(suite, "atfed function", atfedTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
