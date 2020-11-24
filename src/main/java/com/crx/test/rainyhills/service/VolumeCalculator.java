package com.crx.test.rainyhills.service;

/**
 * Service for calculation water volume
 */
public interface VolumeCalculator {

    /**
     * Calculation water volume
     *
     * @param hills - array of hill sizes
     * @return - volume
     */
    int calculate(int[] hills);

}
