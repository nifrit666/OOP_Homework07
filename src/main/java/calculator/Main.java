package calculator;

import calculator.core.operations.Operation;
import calculator.core.operations.impl.Addition;
import calculator.core.operations.impl.Division;
import calculator.core.operations.impl.Multiplication;
import calculator.core.operations.impl.Subtraction;
import calculator.ui.CalcView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Operation> calcFunctions = initialiseCalcFunctions();
        CalcView calc = new CalcView(calcFunctions);
        calc.run();
    }

    private static List<Operation> initialiseCalcFunctions(){
        List<Operation> calcFunctions = new ArrayList<>();

        calcFunctions.add(new Addition());
        calcFunctions.add(new Subtraction());
        calcFunctions.add(new Multiplication());
        calcFunctions.add(new Division());

        return calcFunctions;
    }
}