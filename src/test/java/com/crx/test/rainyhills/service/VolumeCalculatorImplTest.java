package com.crx.test.rainyhills.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VolumeCalculatorImplTest {

    VolumeCalculator calculator = new VolumeCalculatorImpl();

    /*
     * First Example from the task
     *     *
     *   *w*
     *   ***w*
     *   *****
     */
    @Test
    public void testVolumeCalc_firstExampleFromTask(){
        int[] input = {3,2,4,1,2};

        int result = calculator.calculate(input);

        assertEquals(2, result);
    }

    /*
     * Second Example from the task
     *   *
     *   *wwww*
     *   *www**
     *   ***w**
     */
    @Test
    public void testVolumeCalc_secondExampleFromTask(){
        int[] input = {4,1,1,0,2,3};

        int result = calculator.calculate(input);

        assertEquals(8, result);
    }

    /*
     * First hill is the smallest
     *
     *       *
     *     *w*
     *    ****
     */
    @Test
    public void testVolumeCalc_firstHillIsSmallest(){
        int[] input = {1,2,1,3};

        int result = calculator.calculate(input);

        assertEquals(1, result);
    }

    /*
     * Hills will not contain water after rain
     *      *
     *     ***
     *     ****
     *    *****
     */
    @Test
    public void testVolumeCalc_HillsWillNotContainWaterAfterRain(){
        int[] input = {1,3,4,3,2};

        int result = calculator.calculate(input);

        assertEquals(0, result);
    }

    /*
     * Array of hills is empty
     */
    @Test
    public void testVolumeCalc_ArrayOfHillsIsEmpty(){
        int[] input = {};

        int result = calculator.calculate(input);

        assertEquals(0, result);
    }

    /*
     * We have only one hill
     */
    @Test
    public void testVolumeCalc_oneHill(){
        int[] input = {5};

        int result = calculator.calculate(input);

        assertEquals(0, result);
    }

    /*
     * All hills have the same high
     *
     *     ****
     *     ****
     */
    @Test
    public void testVolumeCalc_HillsWithTheSameHigh(){
        int[] input = {2,2,2,2};

        int result = calculator.calculate(input);

        assertEquals(0, result);
    }

    /*
     * All hills are zero
     *
     *     ****
     *     ****
     */
    @Test
    public void testVolumeCalc_HillsAreZero(){
        int[] input = {0,0,0,0};

        int result = calculator.calculate(input);

        assertEquals(0, result);
    }

    /*
     * Common large test
     *          *
     *          *ww*
     *       *ww*ww*
     *    *ww*ww*****
     *    ***********
     */
    @Test
    public void testVolumeCalc_commonLargeTest(){
        int[] input = {2,1,1,3,1,1,5,2,2,4,2};

        int result = calculator.calculate(input);

        assertEquals(10, result);
    }

    /*
     * Negative integer inside
     *          *
     *          *ww*
     *    *ww*ww*ww**
     *    -ww-ww-----
     *    -----------
     */
    @Test
    public void testVolumeCalc_NegativeIntegerInside(){
        int[] input = {1,-1,-1,1,-1,-1,3,0,0,2,1};

        int result = calculator.calculate(input);

        assertEquals(12, result);
    }

    /*
     * Negative integer outside
     *          *
     *          *ww*
     *       *ww*ww*
     *    ww--w-----
     *    ww--------
     */
    @Test
    public void testVolumeCalc_NegativeIntegerOutside(){
        int[] input = {-2,-2,0,1,-1,0,3,0,0,2};

        int result = calculator.calculate(input);

        assertEquals(11, result);
    }

    /*
     * Only Negative integer
     *
     *    ww--w-----
     *    ww--------
     */
    @Test
    public void testVolumeCalc_OnlyNegativeInteger(){
        int[] input = {-2,-2,0,0,-1,0,0,0,0,0};

        int result = calculator.calculate(input);

        assertEquals(5, result);
    }
}
