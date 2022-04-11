package com.mango.prjmango.ui.activities.math.container;

import com.mango.prjmango.ui.activities.math.MathAssignment;
import com.mango.prjmango.ui.activities.math.MathEquation;

public class MathEquationContainerController {

    public MathEquationContainerController(MathEquationContainer view, MathAssignment mathAssignment) {
        view.setMathEquation(new MathEquation(mathAssignment.getCurrentQuestion()));
    }
}
