package arbitraryarithmetic;

public class AFloat {
    private String num = "0";

    public AFloat(String num) {
        this.num = num;
    }

    public static AFloat parse(String input) {
        return new AFloat(input);
    }

    public boolean inputChecker() {
        int count = 0, asc_value;
        for (int i = 0; i < this.num.length(); i++) {
            asc_value = this.num.charAt(i) - '0';
            if (0 <= asc_value && asc_value <= 9) {
                
            } else if (asc_value == -2) {
                count++;
                if (count > 1) {
                    return false;
                }
            } else{
                if (i == 0 && asc_value == -3) {
                    
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public String add(AFloat s) {
        String n1 = this.num, n2 = s.num;
        int index1, index2, c = 0;

        if (this.inputChecker() && s.inputChecker()) {

        } else {
            throw new IllegalArgumentException("Invalid input");
        }

        if (n1.charAt(0) == '-') {
            if (n2.charAt(0) == '-') {
                n1 = n1.substring(1);
                n2 = n2.substring(1);
                c = 1;
            } else {
                n1 = n1.substring(1);
                AFloat temp = new AFloat(n1);
                return s.sub(temp);
            }
        } else {
            if (n2.charAt(0) == '-') {
                n2 = n2.substring(1);
                AFloat temp = new AFloat(n2);
                return this.sub(temp);
            } else {

            }
        }

        if (n1.contains(".")) {
            index1 = n1.indexOf(".");
        } else {
            n1 += ".0";
            index1 = n1.indexOf(".");
        }

        if (n2.contains(".")) {
            index2 = n2.indexOf(".");
        } else {
            n2 += ".0";
            index2 = n2.indexOf(".");
        }

        for (int i = n1.length() - index1 - 1; i < n2.length() - index2 - 1; i++) {
            n1 += '0';
        }

        for (int i = n2.length() - index2 - 1; i < n1.length() - index1 - 1; i++) {
            n2 += '0';
        }

        AInteger temp1 = new AInteger(n1.replace(".", ""));
        AInteger temp2 = new AInteger(n2.replace(".", ""));
        String sum = temp1.add(temp2);

        if (sum.length() <= n1.length() - index1 - 1) {
            for (int i = sum.length(); i < n1.length() - index1 - 1; i++) {
                sum = "0" + sum;
            }

            sum = "0." + sum;
        } else {
            sum = sum.substring(0, sum.length() - n1.length() + index1 + 1) + "." + sum.substring(sum.length() - n1.length() + index1 + 1);
        }

        if (c == 1) {
            sum = "-" + sum;
        }

        for (int i = sum.length() - 1; i >= 0; i--) {
            if (sum.charAt(sum.length() - 1) - '0' == 0) {
                sum = sum.substring(0, sum.length() - 1);
            } else if (sum.charAt(sum.length() - 1) == '.') {
                sum = sum + "0";
                break;
            } else {
                break;
            }
        }

        return sum;
    }

    public String sub(AFloat s) {
        String n1 = this.num, n2 = s.num;
        int index1, index2;
        
        if (this.inputChecker() && s.inputChecker()) {

        } else {
            throw new IllegalArgumentException("Invalid input");
        }

        if (n1.charAt(0) == '-') {
            if (n2.charAt(0) == '-') {
                n1 = n1.substring(1);
                n2 = n2.substring(1);
                AFloat temp1 = new AFloat(n1);
                AFloat temp2 = new AFloat(n2);
                return temp2.sub(temp1);
            } else {
                n1 = n1.substring(1);
                AFloat temp1 = new AFloat(n1);
                return "-" + temp1.add(s);
            }
        } else {
            if (n2.charAt(0) == '-') {
                n2 = n2.substring(1);
                AFloat temp1 = new AFloat(n2);
                return temp1.add(this);
            } else {

            }
        }

        if (n1.contains(".")) {
            index1 = n1.indexOf(".");
        } else {
            n1 += ".0";
            index1 = n1.indexOf(".");
        }

        if (n2.contains(".")) {
            index2 = n2.indexOf(".");
        } else {
            n2 += ".0";
            index2 = n2.indexOf(".");
        }

        for (int i = n1.length() - index1 - 1; i < n2.length() - index2 - 1; i++) {
            n1 += '0';
        }

        for (int i = n2.length() - index2 - 1; i < n1.length() - index1 - 1; i++) {
            n2 += '0';
        }

        AInteger temp1 = new AInteger(n1.replace(".", ""));
        AInteger temp2 = new AInteger(n2.replace(".", ""));
        String dif = temp1.sub(temp2);

        if (dif.length() <= n1.length() - index1 - 1) {
            for (int i = dif.length(); i < n1.length() - index1 - 1; i++) {
                dif = "0" + dif;
            }

            dif = "0." + dif;
        } else {
            dif = dif.substring(0, dif.length() - n1.length() + index1 + 1) + "." + dif.substring(dif.length() - n1.length() + index1 + 1);
        }

        for (int i = dif.length() - 1; i >= 0; i--) {
            if (dif.charAt(dif.length() - 1) - '0' == 0) {
                dif = dif.substring(0, dif.length() - 1);
            } else if (dif.charAt(dif.length() - 1) == '.') {
                dif = dif + "0";
                break;
            } else {
                break;
            }
        }

        return dif;
    }

    public String mul(AFloat s) {
        String n1 = this.num, n2 = s.num;
        int index1, index2, c = 1;
        
        if (this.inputChecker() && s.inputChecker()) {

        } else {
            throw new IllegalArgumentException("Invalid input");
        }

        if (n1.charAt(0) == '-') {
            c *= -1;
            n1 = n1.substring(1);
        }

        if (n2.charAt(0) == '-') {
            c *= -1;
            n2 = n2.substring(1);
        }

        if (n1.contains(".")) {
            index1 = n1.indexOf(".");
        } else {
            n1 += ".0";
            index1 = n1.indexOf(".");
        }

        if (n2.contains(".")) {
            index2 = n2.indexOf(".");
        } else {
            n2 += ".0";
            index2 = n2.indexOf(".");
        }

        AInteger temp1 = new AInteger(n1.replace(".", ""));
        AInteger temp2 = new AInteger(n2.replace(".", ""));
        String product = temp1.mul(temp2);

        if (product.length() <= n1.length() - index1 - 1 + n2.length() - index2 - 1) {
            for (int i = product.length(); i < n1.length() - index1 - 1 + n2.length() - index2 - 1; i++) {
                product = "0" + product;
            }

            product = "0." + product;
        } else {
            product = product.substring(0, product.length() - n1.length() + index1 + 1 - n2.length() + index2 + 1) + "." + product.substring(product.length() - n1.length() + index1 + 1 - n2.length() + index2 + 1);
        }

        for (int i = product.length() - 1; i >= 0; i--) {
            if (product.charAt(product.length() - 1) - '0' == 0) {
                product = product.substring(0, product.length() - 1);
            } else if (product.charAt(product.length() - 1) == '.') {
                product = product + "0";
                break;
            } else {
                break;
            }
        }

        if (c == -1) {
            product = "-" + product;
        }
        
        return new StringBuilder(product).toString();
    }

    public String div(AFloat s) {
        String quotient = "", n1 = this.num, n2 = s.num;
        int index1, index2, c = 1;
                
        if (this.inputChecker() && s.inputChecker()) {

        } else {
            throw new IllegalArgumentException("Invalid input");
        }

        if (n1.charAt(0) == '-') {
            c *= -1;
            n1 = n1.substring(1);
        }

        if (n2.charAt(0) == '-') {
            c *= -1;
            n2 = n2.substring(1);
        }

        if (n1.contains(".")) {
            index1 = n1.indexOf(".");
        } else {
            n1 += ".0";
            index1 = n1.indexOf(".");
        }

        if (n2.contains(".")) {
            index2 = n2.indexOf(".");
        } else {
            n2 += ".0";
            index2 = n2.indexOf(".");
        }
        
        String temp1 = n1.replace(".", "");
        String temp2 = n2.replace(".", "");

        while (temp1.length() > 1){
            if (temp1.charAt(0) - '0' == 0) {
                temp1 = temp1.substring(1);
            } else {
                break;
            }
        }

        while (temp2.length() > 1){
            if (temp2.charAt(0) - '0' == 0) {
                temp2 = temp2.substring(1);
            } else {
                break;
            }
        }

        if (temp2.equals("0")) {
            throw new ArithmeticException("Division by zero error");
        }

        if (n1.length() - index1 >= n2.length() - index2) {
            for (int i = 0; i < n1.length() - index1 - n2.length() + index2; i++) {
                temp2 += '0';
            }
        } else {
            for (int i = 0; i < n2.length() - index2 - n1.length() + index1; i++) {
                temp1 += '0';
            }
        }

        String temp3;
        if (temp1.length() >= temp2.length()) {
            temp3 = temp1.substring(0, temp2.length() - 1);
        } else {
            temp3 = temp1;
        }

        AInteger i1 = new AInteger(temp1);
        AInteger i2 = new AInteger(temp2);
        String d = i1.div(i2);
        int length;

        if (d.equals("0")) {
            length = 0;
        } else {
            length = d.length();
        }

        AInteger temp5 = new AInteger(temp2);
        for (int i = 0; i < 50 + length; i++) {
            if (i <= temp1.length() - temp2.length()) {
                temp3 += temp1.charAt(i + temp2.length() - 1);
            } else {
                if (temp3.equals("0")) {
                    break;
                }

                temp3 += '0';
            }

            while (temp3.length() > 1){
                if (temp3.charAt(0) - '0' == 0) {
                    temp3 = temp3.substring(1);
                } else {
                    break;
                }
            }

            for (int j = 1; j <= 10; j++) {
                AInteger temp4 = new AInteger(String.valueOf(j));
                String temp6 = temp5.mul(temp4);

                if (temp3.length() > temp6.length()) {
                    
                } else if (temp3.length() == temp6.length() && temp6.compareTo(temp3) <= 0) {
                    
                } else {
                    quotient += String.valueOf(j - 1);
                    AInteger temp7 = new AInteger(String.valueOf(j - 1));
                    AInteger temp8 = new AInteger(temp5.mul(temp7));
                    AInteger temp9 = new AInteger(temp3);
                    temp3 = temp9.sub(temp8);
                    break;
                }
            }
        }

        for (int i = 0; i < quotient.length(); i++) {
            if (quotient.charAt(0) - '0' == 0) {
                quotient = quotient.substring(1);
            } else {
                break;
            }
        }

        if (length == 0) {
            int rev_length = i2.div(i1).length();
            for (int i = 0; i < rev_length - 1; i++) {
                quotient = "0" + quotient;
            }

            quotient = quotient.substring(0, Math.min(quotient.length(), 30));
            quotient = "0." + quotient;
        } else {
            quotient = quotient.substring(0, length) + "." + quotient.substring(length, Math.min(quotient.length(), 30 + length));
            if (quotient.charAt(quotient.length() - 1) == '.') {
                quotient += "0";
            }
        }

        if (c == -1) {
            quotient = "-" + quotient;
        }

        return new StringBuilder(quotient).toString();
    }
}