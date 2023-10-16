import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.comparingByValue;

public class Demo {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        BigDecimal bigDecimal = new BigDecimal("2.5685985");
        String format = decimalFormat.format(bigDecimal);

        System.out.println("Decimal Format " + format);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        double value = bigDecimal.doubleValue();
        System.out.println("RoundingMode.HALF_UP " + value);


        Map<String, Integer> map = new HashMap<>();
        map.put("Z", 23);
        map.put("B", 15);
        map.put("A", 15);
        map.put("R", 1);

//        map.entrySet()
//           .stream()
//           .sorted((e1, e2) -> {
//               int res = Integer.compare(e1.getValue(), e2.getValue());
//               if (res == 0) {
//                   res = e1.getKey().compareTo(e2.getKey());
//               }
//               return res;
//           });

        map.entrySet()
           .stream()
           .sorted(Comparator.comparingInt(
           (Map.Entry<String, Integer> e) -> e.getValue()).thenComparing(Map.Entry::getKey));

    }
}
