package arbitraryarithmetic;

class AInteger {
    private String num = "0";

    public AInteger(String num) {
        this.num = num;
    }

    public static AInteger parse(String input) {
        return new AInteger(input);
    }

    public String add(AInteger s) {
        String sum = "", n1 = this.num, n2 = s.num;
        int overhead = 0, c = 0;
        
        while (n1.length() > 1){
            if (n1.charAt(0) - '0' == 0) {
                n1 = n1.substring(1);
            } else {
                break;
            }
        }

        while (n2.length() > 1){
            if (n2.charAt(0) - '0' == 0) {
                n2 = n2.substring(1);
            } else {
                break;
            }
        }

        if (n1.charAt(0) == '-') {
            if (n2.charAt(0) == '-') {
                n1 = n1.substring(1);
                n2 = n2.substring(1);
                c = 1;
            } else {
                n1 = n1.substring(1);
                AInteger temp = new AInteger(n1);
                return s.sub(temp);
            }
        } else {
            if (n2.charAt(0) == '-') {
                n2 = n2.substring(1);
                AInteger temp = new AInteger(n2);
                return this.sub(temp);
            } else {

            }
        }

        while (n1.length() != n2.length()) {
            if (n1.length() < n2.length()) {
                n1 = '0' + n1;
            } else {
                n2 = '0' + n2;
            }
        }

        for (int i = n1.length() - 1; i >= 0; i--) {
            int num1 = n1.charAt(i) - '0', num2 = n2.charAt(i) - '0';

            if (num1 + num2 + overhead > 9 && i != 0) {
                sum = String.valueOf(num1 + num2 + overhead - 10) + sum;
                overhead = 1;
            } else {
                sum = String.valueOf(num1 + num2 + overhead) + sum;
                overhead = 0;
            }
        }

        while (sum.length() > 1){
            if (sum.charAt(0) - '0' == 0) {
                sum = sum.substring(1);
            } else {
                break;
            }
        }

        if (c == 1) {
            sum = "-" + sum;
        }

        return new StringBuilder(sum).toString();
    }

    public String sub(AInteger s) {
        String dif = "", n1 = this.num, n2 = s.num;
        int overhead = 0;

        if (n1.charAt(0) == '-') {
            if (n2.charAt(0) == '-') {
                n1 = n1.substring(1);
                n2 = n2.substring(1);
                AInteger temp1 = new AInteger(n1);
                AInteger temp2 = new AInteger(n2);
                return temp2.sub(temp1);
            } else {
                n1 = n1.substring(1);
                AInteger temp1 = new AInteger(n1);
                return "-" + temp1.add(s);
            }
        } else {
            if (n2.charAt(0) == '-') {
                n2 = n2.substring(1);
                AInteger temp1 = new AInteger(n2);
                return temp1.add(this);
            } else {

            }
        }

        while (n1.length() > 1){
            if (n1.charAt(0) - '0' == 0) {
                n1 = n1.substring(1);
            } else {
                break;
            }
        }

        while (n2.length() > 1){
            if (n2.charAt(0) - '0' == 0) {
                n2 = n2.substring(1);
            } else {
                break;
            }
        }

        while (n1.length() != n2.length()) {
            if (n1.length() < n2.length()) {
                n1 = '0' + n1;
            } else {
                n2 = '0' + n2;
            }
        }

        if (n1.compareTo(n2) == 0) {
            return "0";
        }

        for (int i = n1.length() - 1; i >= 0; i--) {
            int num1 = n1.charAt(i) - '0', num2 = n2.charAt(i) - '0';

            if (n1.compareTo(n2) < 0) {
                num2 += num1;
                num1 = num2 - num1;
                num2 -= num1;
            }
            
            if (i == 0) {
                if (num1 - num2 - overhead == 0) {
                    continue;
                }
            }

            if (num1 - num2 - overhead < 0) {
                dif = String.valueOf(num1 - num2 - overhead + 10) + dif;
                overhead = 1;
            } else {
                dif = String.valueOf(num1 - num2 - overhead) + dif;
                overhead = 0;
            }
        }

        while (dif.length() > 1){
            if (dif.charAt(0) - '0' == 0) {
                dif = dif.substring(1);
            } else {
                break;
            }
        }

        if (n1.compareTo(n2) < 0) {
            return '-' + new StringBuilder(dif).toString();
        } else {
            return new StringBuilder(dif).toString();
        }
    }

    public String mul(AInteger s) {
        String product = "0", n1 = this.num, n2 = s.num;
        int overhead = 0, c = 1;
        
        if (n1.charAt(0) == '-') {
            c *= -1;
            n1 = n1.substring(1);
        }

        if (n2.charAt(0) == '-') {
            c *= -1;
            n2 = n2.substring(1);
        }

        while (n1.length() > 1){
            if (n1.charAt(0) - '0' == 0) {
                n1 = n1.substring(1);
            } else {
                break;
            }
        }

        while (n2.length() > 1){
            if (n2.charAt(0) - '0' == 0) {
                n2 = n2.substring(1);
            } else {
                break;
            }
        }

        for (int i = n1.length() - 1; i >= 0; i--) {
            String temp = "";
            int num1 = n1.charAt(i) - '0';
            for (int j = n2.length() - 1; j >= 0; j--) {
                int num2 = n2.charAt(j) - '0';

                if (num2 * num1 + overhead > 9 && j != 0) {
                    temp = String.valueOf((num1 * num2 + overhead) % 10) + temp;
                    overhead = (num2 * num1 + overhead) / 10;
                } else {
                    temp = String.valueOf(num1 * num2 + overhead) + temp;
                    overhead = 0;
                }
            }

            for (int j = i; j < n1.length() - 1; j++) {
                temp += '0';
            }

            AInteger temp1 = new AInteger(product);
            AInteger temp2 = new AInteger(temp);
            product = temp1.add(temp2);
        }
        
        while (product.length() > 1){
            if (product.charAt(0) - '0' == 0) {
                product = product.substring(1);
            } else {
                break;
            }
        }

        if (c == -1) {
            product = "-" + product;
        }

        return new StringBuilder(product).toString();
    }

    public String div(AInteger s) {
        String quotient = "", n1 = this.num, n2 = s.num;
        int c = 1;
        
        if (n1.charAt(0) == '-') {
            c *= -1;
            n1 = n1.substring(1);
        }

        if (n2.charAt(0) == '-') {
            c *= -1;
            n2 = n2.substring(1);
        }

        while (n1.length() > 1){
            if (n1.charAt(0) - '0' == 0) {
                n1 = n1.substring(1);
            } else {
                break;
            }
        }

        while (n2.length() > 1){
            if (n2.charAt(0) - '0' == 0) {
                n2 = n2.substring(1);
            } else {
                break;
            }
        }

        if (n2.equals("0")) {
            throw new ArithmeticException("Division by zero error");
        }

        if (n1.length() < n2.length()) {
            return "0";
        } else if (n1.length() == n2.length()) {
            if (n1.compareTo(n2) < 0) {
                return "0";
            } else if (n1.compareTo(n2) == 0) {
                return "1";
            }
        }

        AInteger temp5 = new AInteger(n2);
        String temp = n1.substring(0, n2.length() - 1);

        for (int i = n2.length() - 1; i < n1.length(); i++) {
            temp += n1.charAt(i);

            if (temp.length() < n2.length()) {
                quotient += "0";
                continue;
            } else if (temp.length() == n2.length() && temp.compareTo(n2) < 0) {
                quotient += "0";
                continue;
            }

            while (temp.length() > 1){
                if (temp.charAt(0) - '0' == 0) {
                    temp = temp.substring(1);
                } else {
                    break;
                }
            }

            for (int j = 1; j <= 10; j++) {
                AInteger temp1 = new AInteger(String.valueOf(j));
                String temp2 = temp5.mul(temp1);

                if (temp2.length() < temp.length()) {
                    
                } else if (temp2.length() == temp.length() && temp2.compareTo(temp) <= 0) {
                    
                } else {
                    quotient += String.valueOf(j - 1);
                    temp1 = new AInteger(String.valueOf(j - 1));
                    AInteger temp3 = new AInteger(temp5.mul(temp1));
                    AInteger temp4 = new AInteger(temp);
                    temp = temp4.sub(temp3);
                    break;
                }
            }
        }

        while (quotient.length() > 1){
            if (quotient.charAt(0) - '0' == 0) {
                quotient = quotient.substring(1);
            } else {
                break;
            }
        }

        if (c == -1) {
            quotient = "-" + quotient;
        }

        return new StringBuilder(quotient).toString();
    }
}