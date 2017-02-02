package com.bvan.cp.oop.gen;

import java.util.Random;

/**
 * Singleton long ID generator.
 *
 * @author bvanchuhov
 */
public enum LongIdGenerator implements Generator<Long> {
    INSTANCE;

    private Random random = new Random();

    @Override
    public Long generate() {
        return random.nextLong();
    }
}
