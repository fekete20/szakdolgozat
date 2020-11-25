#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>


void megforditTeszt()
{
  char szoveg[] = "indul a gorog aludni";
  CU_ASSERT_STRING_EQUAL(megfordit(szoveg),"indula gorog a ludni");
  return ;
}


int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("megfordit_test", 0, 0);
    CU_add_test(suite, "megfordit function", megforditTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
