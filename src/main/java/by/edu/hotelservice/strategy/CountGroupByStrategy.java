package by.edu.hotelservice.strategy;

import java.util.Map;

public interface CountGroupByStrategy {

    Map<String, Long> getHistogramInfo();
}
