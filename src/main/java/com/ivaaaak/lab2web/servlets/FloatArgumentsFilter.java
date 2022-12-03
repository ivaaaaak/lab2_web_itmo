package com.ivaaaak.lab2web.servlets;

import com.ivaaaak.lab2web.exceptions.NotFloatArgsException;
import com.ivaaaak.lab2web.util.FloatArgumentsValidator;
import com.ivaaaak.lab2web.util.FloatArgumentsValidator.Range;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/float_args")
public class FloatArgumentsFilter extends HttpFilter {

    @Inject
    FloatArgumentsValidator validator;
    private final String[] argNames = {"x", "y", "r"};
    private final float[][] rangeValues = {{-5, 3}, {-5, 3}, {0, 3}};
    private final Range[] ranges = {Range.SEGMENT, Range.SEGMENT, Range.RIGHT_HALF_INTERVAL};

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        checkFloatArguments(request);
        getServletContext().getRequestDispatcher("/controller").forward(request, response);
        chain.doFilter(request, response);
    }

    private void checkFloatArguments(final HttpServletRequest request) {
        for (String argName: argNames) {
            if (request.getParameter(argName) == null) {
                return;
            }
        }
        final float[] parsedFloatArguments = parseFloatArguments(request, argNames);
        final float[] checkedFloatArguments = validator.validateFloatArguments(parsedFloatArguments, rangeValues, ranges);
        request.setAttribute("args", checkedFloatArguments);
    }

    private float[] parseFloatArguments (final HttpServletRequest request,
                                         final String[] argNames) {
        float[] parsedArgs = new float[argNames.length];
        try {
            for (int i = 0; i < parsedArgs.length; i++) {
                parsedArgs[i] = Float.parseFloat(request.getParameter(argNames[i]));
            }
        } catch (NumberFormatException e) {
            throw new NotFloatArgsException();
        }
        return parsedArgs;
    }


}