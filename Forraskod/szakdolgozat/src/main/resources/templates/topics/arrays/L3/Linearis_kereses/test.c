#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

#define N 10

void keresTeszt()
{
  int tomb[N] = { 6, 12, -3, 7, 4, 9, 56, 34, 0, -21 };

  CU_ASSERT_EQUAL(keres(56, tomb), 7);
  CU_ASSERT_EQUAL(keres(150, tomb), 0);

  return ;
}


int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("keres_test", 0, 0);
    CU_add_test(suite, "keres function", keresTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
