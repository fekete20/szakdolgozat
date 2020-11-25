#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

#define N 27

void keresTeszt()
{
	char abc[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
'w', 'x', 'y', 'z'};
	CU_ASSERT_EQUAL(keres('d', abc), 4);
	CU_ASSERT_EQUAL(keres('z', abc), 26);
	CU_ASSERT_FALSE(keres(5, abc));



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
