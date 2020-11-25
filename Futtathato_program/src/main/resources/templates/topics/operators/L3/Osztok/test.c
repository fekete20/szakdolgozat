#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void osztoSzamlalTeszt() {

CU_ASSERT_EQUAL(osztoSzamlal(2017), 2);
CU_ASSERT_EQUAL(osztoSzamlal(2700), 36);	
	return ;
}

int main()
{ 
	CU_initialize_registry();
	CU_pSuite suite = CU_add_suite("oszto_test", 0, 0);
	CU_add_test(suite, "osztoSzamlal function", osztoSzamlalTeszt);
	CU_basic_set_mode(CU_BRM_VERBOSE);
	CU_basic_run_tests();
	CU_cleanup_registry();

return 0;
}
