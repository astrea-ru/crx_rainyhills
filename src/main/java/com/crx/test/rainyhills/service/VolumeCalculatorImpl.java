package com.crx.test.rainyhills.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Service
public class VolumeCalculatorImpl implements VolumeCalculator {

    private static final Logger logger = LoggerFactory.getLogger(VolumeCalculatorImpl.class);

    /*
     * Complexity O(n):
     *      1) Calculation the highest hills on the left side: O(n)
     *      2) Calculation volume: O(n)
     *      3) O(n)+O(n) = O(n)
     *  Memory usage:
     *   We have 2 arrays: input array, the highest hills on the left side array: 3*(n*4bytes + some overhead)
     *      where n is a size of input array
     *   Also two int parameters
     */
    @Override
    public int calculate(int[] hills) {
        logger.info("Start to calculate {}", hills);
        int volume = 0;
        int numOfHills = hills.length;
        if (numOfHills == 0) {
            return volume;
        }

        int[] highestLeft = new int[numOfHills];
        highestLeft[0] = hills[0] >=0 ? hills[0] : 0;
        for (int i = 1; i < numOfHills; i++) {
            highestLeft[i] = max(hills[i], highestLeft[i - 1] >=0 ?  highestLeft[i - 1] : 0);
        }

        int highestRight = Integer.MIN_VALUE;
        for (int i = numOfHills - 1; i >= 0; i--) {
            highestRight = max(hills[i], highestRight);
            logger.debug("Highest right {}, highest left {}, real hill {}", highestRight, highestLeft[i], hills[i]);
            volume += min(highestLeft[i], highestRight) - hills[i];
        }

        logger.info("Finish to calculate, result {}", volume);
        return volume;
    }
}

