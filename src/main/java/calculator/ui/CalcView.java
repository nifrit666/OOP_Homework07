package calculator.ui;

import calculator.core.Controller;
import calculator.core.operations.Operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class CalcView {
    private final List<Operation> functions;
    private final List<String> numbers;
    private String operation;

    private final Controller controller;

    public CalcView(List<Operation> calcFunctions) {
        this.numbers = new ArrayList<>();
        this.operation = null;
        this.functions = calcFunctions;
        this.controller = new Controller(functions);
    }

    public void run(){
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(CalcView.class.getName());
        try {
            FileHandler fh = new FileHandler("log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO,"Приложение запущено");
        do {
            inputExpression();
            logger.info("Ввод данных: " + numbers + ", оператор: " + operation);
            if (!numbers.isEmpty() && !operation.isEmpty()){
                System.out.println("------------------------------------------------------");
                String result = controller.calculate(numbers, operation);
                result = result.contains("NaN") ? "Ошибка: деление на ноль" : result;
                System.out.println("Результат: " + result);
                logger.info("Результат вычислений: " + result);
                timeOut();
            }
        } while (!operation.isEmpty());
        logger.info("Приложение завершает работу");
    }

    private void inputExpression() {
        numbers.clear();
        System.out.print("\033[H\033[J");
        System.out.println("----- Калькулятор комплексных чисел v.2024.05.25 -----");
        System.out.println("            (три раза нажми ENTER для выхода)");
        numbers.add(prompt("Введите 1-е комплексное число формата a + b*i: ").toLowerCase());
        operation = prompt("Введите операцию: ");
        numbers.add(prompt("Введите 2-е комплексное число формата a + b*i: ").toLowerCase());
    }
    private String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void timeOut() {
        System.out.println("Нажми ENTER для продолжения");
        Scanner stopScn = new Scanner(System.in);
        stopScn.nextLine();
    }
}
