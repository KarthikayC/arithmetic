import arbitraryarithmetic.AFloat;
import arbitraryarithmetic.AInteger;

public class MyInfArith {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java MyInfArith <int/float> <add/sub/mul/div> <operand1> <operand2>");
            return;
        }

        String type = args[0];
        String operation = args[1];
        String operand1 = args[2];
        String operand2 = args[3];

        if (type.equals("int")) {
            AInteger num1 = AInteger.parse(operand1);
            AInteger num2 = AInteger.parse(operand2);

            switch (operation) {
                case "add":
                    System.out.println(num1.add(num2));
                    break;
                case "sub":
                    System.out.println(num1.sub(num2));
                    break;
                case "mul":
                    System.out.println(num1.mul(num2));
                    break;
                case "div":
                    System.out.println(num1.div(num2));
                    break;
                default:
                    System.out.println("Unknown operation. Use <add/sub/mul/div>");
            }
        } else if (type.equals("float")) {
            AFloat num1 = AFloat.parse(operand1);
            AFloat num2 = AFloat.parse(operand2);

            switch (operation) {
                case "add":
                    System.out.println(num1.add(num2));
                    break;
                case "sub":
                    System.out.println(num1.sub(num2));
                    break;
                case "mul":
                    System.out.println(num1.mul(num2));
                    break;
                case "div":
                    System.out.println(num1.div(num2));
                    break;
                default:
                    System.out.println("Unknown operation. Use <add/sub/mul/div>");
            }
        } else {
            System.out.println("Unknown type. Use <int/float>");
        }
    }
}