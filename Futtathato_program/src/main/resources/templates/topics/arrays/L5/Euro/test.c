#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>


double tomb[] = {289.5, 292.6, 390.2, 295.5, 100.4, 300.3, 302.5, 303.3, 303.5, 298.9};


void limitAlattTeszt()
{
CU_ASSERT_EQUAL(limitAlatt(300.0, tomb), 5);
    return ;
}

void monotonTeszt()
{
CU_ASSERT_FALSE(monoton(tomb));
    return ;
}

void minimumTeszt()
{
CU_ASSERT_EQUAL(minimum(tomb), 4);
    return ;
}

void maximumTeszt()
{
CU_ASSERT_EQUAL(maximum(tomb), 2);
    return ;
}


void atlagTeszt()
{
CU_ASSERT_DOUBLE_EQUAL(atlag(tomb), 287.7, 8);

    return ;
}


int main()
{


    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("limitAlatt_test", 0, 0);
    CU_add_test(suite, "limitAlatt function", limitAlattTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite1 = CU_add_suite("monoton_test", 0, 0);
    CU_add_test(suite1, "monoton function", monotonTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite2 = CU_add_suite("minimum_test", 0, 0);
    CU_add_test(suite2, "minimum function", minimumTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite3 = CU_add_suite("maximum_test", 0, 0);
    CU_add_test(suite3, "maximum function", maximumTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite4 = CU_add_suite("atlag_test", 0, 0);
    CU_add_test(suite4, "atlag function", atlagTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();


return 0;
}
