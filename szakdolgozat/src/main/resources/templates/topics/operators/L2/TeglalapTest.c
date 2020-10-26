#define main teglalap
#include "../c_files/-182408284main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void teglalapTeruletTeszt()
{

CU_ASSERT_EQUAL(teruletSzamol(5, 6), 30);
CU_ASSERT_EQUAL(teruletSzamol(101, 131), 13231);

    return ;
}

void teglalapKeruletTeszt()
{

CU_ASSERT_EQUAL(keruletSzamol(5, 6), 22);
CU_ASSERT_EQUAL(keruletSzamol(101, 131), 464);

    return ;
}

int main()
{ 
 CU_initialize_registry();
CU_pSuite suite = CU_add_suite("terulet_test", 0, 0);
 CU_add_test(suite, "teruletSzamol function", teglalapTeruletTeszt);


    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

 CU_initialize_registry();
CU_pSuite suite1 = CU_add_suite("kerulet_test", 0, 0);
 CU_add_test(suite1, "keruletSzamol function", teglalapKeruletTeszt);


    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();
//teglalapTeszt();
return 0;
}
