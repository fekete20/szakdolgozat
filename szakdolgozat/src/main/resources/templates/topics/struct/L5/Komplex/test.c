#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void valosgyokSzamitasTeszt()
{
    Valosgyok valosEredmeny = valosgyokSzamitas(3, -14, 8, 9);
    CU_ASSERT_DOUBLE_EQUAL(valosEredmeny.x1, 4, 6);
    CU_ASSERT_DOUBLE_EQUAL(valosEredmeny.x2, 0.666667, 6);

    return ;
}

void komplexgyokSzamitasTeszt() {
    Komplexgyok komplexEredmeny = komplexgyokSzamitas(24, 2, 2, -188);

    CU_ASSERT_DOUBLE_EQUAL(komplexEredmeny.valos, -0.041667, 6);
    CU_ASSERT_DOUBLE_EQUAL(komplexEredmeny.kepzetes, -0.285652, 6);

    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("valosgyokSzamitas_test", 0, 0);
    CU_add_test(suite, "valosgyokSzamitas function", valosgyokSzamitasTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

    CU_initialize_registry();
    CU_pSuite suite1 = CU_add_suite("komplexgyokSzamitas_test", 0, 0);
    CU_add_test(suite, "komplexgyokSzamitas function", komplexgyokSzamitasTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
