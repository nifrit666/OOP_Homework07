package calculator.core.operations;

import java.util.List;

public interface Operation {

    String calculate(List<String> incNumbers);
    String getOperation();
}
