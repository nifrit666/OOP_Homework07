package calculator.core.mapper.impl;

import calculator.core.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ComplexMapper implements Mapper {
    @Override
    public String toOutput(ArrayList<Float> numbers) {
        return (numbers.get(0) != 0 ? numbers.get(0) : "") +
                (numbers.get(1) != 0 ?
                        (numbers.get(1) < 0 ? numbers.get(1) + "*i" : "+" + numbers.get(1) + "*i") : "");
    }

    @Override
    public ArrayList<Float> fromInput(List<String> numbers) {
        ArrayList<Float> result = new ArrayList<>(4);
        for (int i = 0; i < 4; i++){
            result.add(0f);
        }
        int curNumberIndex = 0;
        for (String number : numbers) {
            if (number != null) {
                number = number.replace("*", "");
                number = number.replace(" ", "");
                number = number.replace(",", ".");
                number = number.replace("-", ";-");
                number = number.replace("+", ";");
                if (!number.isEmpty() && number.charAt(0) == ';') {
                    number = number.replaceFirst(";", "");
                }
                String[] splitedNumbers = number.split(";");
                if (splitedNumbers[0].contains("i") && splitedNumbers.length > 1){
                    String temp =  splitedNumbers[0];
                    splitedNumbers[0] = splitedNumbers[1];
                    splitedNumbers[1] = temp;
                }
                for (int i = 0; i < splitedNumbers.length; i++) {

                    int indent = 0;
                    if (splitedNumbers[i].contains("i")) {
                        indent = 1;
                        splitedNumbers[i] = splitedNumbers[i].replace("i", "");
                        if (splitedNumbers[i].equals("-") || splitedNumbers[i].isEmpty()) {
                            splitedNumbers[i] += "1";
                        }
                    }
                    if (!splitedNumbers[i].isEmpty()) {
                        result.add(curNumberIndex + indent, Float.parseFloat(splitedNumbers[i]));
                    }
                }
                curNumberIndex += 2;
            }
        }
        return result;
    }
}
