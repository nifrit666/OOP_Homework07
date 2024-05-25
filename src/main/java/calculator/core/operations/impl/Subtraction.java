package calculator.core.operations.impl;

import calculator.core.mapper.Mapper;
import calculator.core.mapper.impl.ComplexMapper;
import calculator.core.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public class Subtraction implements Operation {
    private final String operation = "-";
    private final Mapper mapper;

    public Subtraction() {
        this.mapper = new ComplexMapper();
    }

    public String getOperation() {
        return operation;
    }
    @Override
    public String calculate(List<String> incNumbers) {
        ArrayList<Float> numbers = new ArrayList<>(4);
        numbers.addAll(mapper.fromInput(incNumbers));
        ArrayList<Float> result = new ArrayList<>(2);
        result.add(0,numbers.get(0) - numbers.get(2));
        result.add(1, numbers.get(1) - numbers.get(3));
        return mapper.toOutput(result);
        //return numbers.get(0) + operation + numbers.get(1);
    }
}
