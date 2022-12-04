package com.ivaaaak.lab2web.model;

import static java.lang.Math.pow;

public class AreaChecker {

    public boolean isHit (final float x, final float y, final float r) {
        boolean hit = false;
        if (x > 0) {
            if (y > 0) {
                hit = x <= r && y <= r;
            } else {
                hit = x <= (r/2) && y >= 2 * x - r;
            }
        } else {
            if (y > 0) {
                hit = x >= -r && y <= r && pow(x, 2) + pow(y, 2) <= pow(r, 2);
            }
        }
        return hit;
    }
}
