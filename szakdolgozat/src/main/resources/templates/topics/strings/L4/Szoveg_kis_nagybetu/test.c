#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>


void kisbetusitTeszt()
{
  char szoveg[] = "Teszt szoveg.";
  CU_ASSERT_STRING_EQUAL(kisbetusit(szoveg),"teszt szoveg.");
    return ;
}

void nagybetusitTeszt()
{
  char szoveg[] = "Teszt szoveg.";
  CU_ASSERT_STRING_EQUAL(nagybetusit(szoveg),"TESZT SZOVEG.");
    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("kisbetusit_test", 0, 0);
    CU_add_test(suite, "kisbetusit function", kisbetusitTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite1 = CU_add_suite("nagybetusit_test", 0, 0);
    CU_add_test(suite, "nagybetusit function", nagybetusitTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
