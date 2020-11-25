#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

int tomb[] = { 5, 7, 9, 10, 11 };

void szamtaniAtlagTeszt()
{
 
  CU_ASSERT_EQUAL(szamtaniAtlag(tomb), 8.4);
    return ;
}

void mertaniAtlagTeszt()
{

  CU_ASSERT_DOUBLE_EQUAL(mertaniAtlag(tomb), 8.089853, 6);
    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("szamtaniAtlag_test", 0, 0);
    CU_add_test(suite, "szamtaniAtlag function", szamtaniAtlagTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite1 = CU_add_suite("mertaniAtlag_test", 0, 0);
    CU_add_test(suite, "mertaniAtlag function", mertaniAtlagTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}

