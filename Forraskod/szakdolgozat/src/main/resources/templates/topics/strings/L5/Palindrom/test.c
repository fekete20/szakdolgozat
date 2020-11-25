#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>


void palindromaTeszt()
{
  char szoveg1[] = "indul a gorog aludni";
  char szoveg2[] = "Geza kek az eg";
  char szoveg3[] = "palindroma teszt";
  CU_ASSERT_TRUE(palindroma(szoveg1));
  CU_ASSERT_TRUE(palindroma(szoveg2));
  CU_ASSERT_FALSE(palindroma(szoveg3));
  return ;
}


int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("palindroma_test", 0, 0);
    CU_add_test(suite, "palindroma function", palindromaTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
