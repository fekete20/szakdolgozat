#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void tokeletesTeszt()
{

CU_ASSERT_TRUE(tokeletes(6));
CU_ASSERT_TRUE(tokeletes(8128));
CU_ASSERT_FALSE(tokeletes(100));
CU_ASSERT_FALSE(tokeletes(46));

    return ;
}

void kisebboszto_osszegTeszt()
{

CU_ASSERT_EQUAL(kisebboszto_osszeg(176), 196);
CU_ASSERT_EQUAL(kisebboszto_osszeg(8128), 8128);

    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("kisebboszto_osszeg_test", 0, 0);
    CU_add_test(suite, "kisebboszto_osszeg function", kisebboszto_osszegTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite1 = CU_add_suite("tokeletes_test", 0, 0);
    CU_add_test(suite1, "tokeletes function", tokeletesTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();


return 0;
}
