package com.ivaaaak.lab2web.util;

import com.ivaaaak.lab2web.exceptions.OutOfRangeException;

public class FloatArgumentsValidator {

    public enum Range {INTERVAL, SEGMENT, RIGHT_HALF_INTERVAL, LEFT_HALF_INTERVAL}

    public float[] validateFloatArguments (final float[] args,
                                         final float[][] argsRangeValues,
                                         final Range[] argsRanges) {
        for (int i = 0; i < args.length; i++) {
            boolean isCorrect = checkRange(args[i], argsRangeValues[i][0], argsRangeValues[i][1], argsRanges[i]);
            if (!isCorrect) {
                throw new OutOfRangeException();
            }
        }
        return args;
    }

    private boolean checkRange (final float value,
                                final float lowerBound,
                                final float upperBound,
                                final Range range) {
        return switch (range) {
            case SEGMENT -> checkSegment(value, lowerBound, upperBound);
            case RIGHT_HALF_INTERVAL -> checkRightHalfInterval(value, lowerBound, upperBound);
            case LEFT_HALF_INTERVAL -> checkLeftHalfInterval(value, lowerBound, upperBound);
            case INTERVAL -> checkInterval(value, lowerBound, upperBound);
        };
    }

    private boolean checkSegment (final float value,
                                  final float lowerBound,
                                  final float upperBound) {
        return value >= lowerBound && value <= upperBound;
    }
    private boolean checkInterval (final float value,
                                   final float lowerBound,
                                   final float upperBound) {
        return value > lowerBound && value < upperBound;
    }
    private boolean checkRightHalfInterval (final float value,
                                            final float lowerBound,
                                            final float upperBound) {
        return value > lowerBound && value <= upperBound;
    }
    private boolean checkLeftHalfInterval (final float value,
                                           final float lowerBound,
                                           final float upperBound) {
        return value >= lowerBound && value < upperBound;
    }

}
