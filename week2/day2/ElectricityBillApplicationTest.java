package com.citypower.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ElectricityBillApplicationTest {

    @Test
    void testCalculateEnergyChargeFor0Units() {
        // No units consumed, so the energy charge should be zero.
        double actual =
            ElectricityBillApplication.calculateEnergyCharge(0);

        assertEquals(0.00, actual, 0.001);
    }

    @Test
    void testCalculateEnergyChargeFor80Units() {
        // 80 units remain in the first slab at Rs. 3.00 per unit.
        double actual =
            ElectricityBillApplication.calculateEnergyCharge(80);

        assertEquals(240.00, actual, 0.001);
    }

    @Test
    void testCalculateEnergyChargeFor100Units() {
        // 100 units are fully charged at the first slab rate.
        double actual =
            ElectricityBillApplication.calculateEnergyCharge(100);

        assertEquals(300.00, actual, 0.001);
    }

    @Test
    void testCalculateEnergyChargeFor101Units() {
        // The first 100 units cost Rs. 300.00, and 1 unit costs Rs. 5.00.
        double actual =
            ElectricityBillApplication.calculateEnergyCharge(101);

        assertEquals(305.00, actual, 0.001);
    }

    @Test
    void testCalculateEnergyChargeFor300Units() {
        // The 300 units cost Rs. 300.00 plus Rs. 1,000.00.
        double actual =
            ElectricityBillApplication.calculateEnergyCharge(300);

        assertEquals(1300.00, actual, 0.001);
    }

    @Test
    void testCalculateEnergyChargeFor301Units() {
        // One unit above 300 is charged at Rs. 7.50.
        double actual =
            ElectricityBillApplication.calculateEnergyCharge(301);

        assertEquals(1307.50, actual, 0.001);
    }

    @Test
    void test393UnitsBelowSurchargeLimit() {
        // 393 units produce Rs. 1,997.50, which is below Rs. 2,000.00.
        double energyCharge =
            ElectricityBillApplication.calculateEnergyCharge(393);

        assertEquals(1997.50, energyCharge, 0.001);

        double surcharge =
            ElectricityBillApplication.calculateSurcharge(energyCharge);

        assertEquals(0.00, surcharge, 0.001);
    }

    @Test
    void test394UnitsAboveSurchargeLimit() {
        // 394 units produce Rs. 2,005.00, so a 5% surcharge applies.
        double energyCharge =
            ElectricityBillApplication.calculateEnergyCharge(394);

        assertEquals(2005.00, energyCharge, 0.001);

        double surcharge =
            ElectricityBillApplication.calculateSurcharge(energyCharge);

        assertEquals(100.25, surcharge, 0.001);
    }

    @Test
    void test400UnitsBillCalculations() {
        // 400 units produce Rs. 2,050.00 plus a 5% surcharge.
        double energyCharge =
            ElectricityBillApplication.calculateEnergyCharge(400);

        assertEquals(2050.00, energyCharge, 0.001);

        double surcharge =
            ElectricityBillApplication.calculateSurcharge(energyCharge);

        assertEquals(102.50, surcharge, 0.001);

        double total =
            ElectricityBillApplication.calculateTotal(energyCharge);

        assertEquals(2202.50, total, 0.001);
    }

    @Test
    void testZeroUnitsTotalIncludesFixedCharge() {
        // With no consumption, calculateTotal() must return the fixed charge only.
        double total =
            ElectricityBillApplication.calculateTotal(0.00);

        assertEquals(50.00, total, 0.001);
    }

    @Test
    void testSurchargeAt2000IsZero() {
        // The surcharge must not apply exactly at Rs. 2,000.00.
        double surcharge =
            ElectricityBillApplication.calculateSurcharge(2000.00);

        assertEquals(0.00, surcharge, 0.001);
    }

    @Test
    void testSurchargeAbove2000() {
        // A value above Rs. 2,000.00 receives a 5% surcharge.
        double surcharge =
            ElectricityBillApplication.calculateSurcharge(2000.01);

        assertEquals(100.0005, surcharge, 0.001);
    }
}

