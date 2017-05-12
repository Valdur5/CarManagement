//@formatter:off
/**
 * $$Id$$
 * . * .
 * * RRRR  *    Copyright (c) 2016 EUIPO: European Union Intellectual
 * .   RR  R   .  Property Office (trade marks and designs)
 * *   RRR     *
 * .  RR RR  .   ALL RIGHTS RESERVED
 * * . _ . *
 */
//@formatter:on
package de.pandigo.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Brand {
    Toyota, BMW, Audi, Mercedes, VW;

    private static final List<Brand> VALUES = Arrays.asList(values());

    public static Brand randomBrand()  {
        return VALUES.get(new Random().nextInt(VALUES.size()));
    }
}
