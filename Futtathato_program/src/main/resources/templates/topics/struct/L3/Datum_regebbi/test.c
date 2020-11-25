#define main main1
#include "main.c"
#undef main

#include <CUnit/CUnit.h>
#include <CUnit/Basic.h>

void regebbiDatumTeszt()
{
    Datum d1;
    Datum d2;

    d1.ev = 2020;
    d1.ho = 11;
    d1.nap = 19;

    d2.ev = 2019;
    d2.ho = 12;
    d2.nap = 21;

    Datum eredmeny = regebbi_datum(d1, d2);


    CU_ASSERT_EQUAL(eredmeny.ev, 2019);
    CU_ASSERT_EQUAL(eredmeny.ho, 12);
    CU_ASSERT_EQUAL(eredmeny.nap, 21);

    Datum d3;

    d3.ev = 2020;
    d3.ho = 11;
    d3.nap = 27;

    Datum eredmeny1 = regebbi_datum(d1, d3);

    CU_ASSERT_EQUAL(eredmeny1.ev, 2020);
    CU_ASSERT_EQUAL(eredmeny1.ho, 11);
    CU_ASSERT_EQUAL(eredmeny1.nap, 19);

    return ;
}

int main()
{
    CU_initialize_registry();
    CU_pSuite suite = CU_add_suite("regebbiDatum_test", 0, 0);
    CU_add_test(suite, "regebbiDatum function", regebbiDatumTeszt);
    CU_basic_set_mode(CU_BRM_VERBOSE);
    CU_basic_run_tests();
    CU_cleanup_registry();

return 0;
}
