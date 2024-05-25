package calculator.core.mapper;

import java.util.ArrayList;
import java.util.List;

public interface Mapper {

    String toOutput(ArrayList<Float> numbers);

    ArrayList<Float> fromInput (List<String> numbers);
}
