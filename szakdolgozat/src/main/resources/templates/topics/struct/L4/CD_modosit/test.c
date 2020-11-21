#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void modositTeszt()
{
    CD c = { "Valaki", "Valami", 500, 2020};
    CD eredmeny = modosit(&c);
    CU_ASSERT_EQUAL(eredmeny.ar, 550);

    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("modosit_test", 0, 0);
    CU_add_test(suite, "modosit function", modositTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
