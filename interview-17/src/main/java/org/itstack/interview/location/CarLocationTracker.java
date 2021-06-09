package org.itstack.interview.location;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarLocationTracker {

    private Map<String,Location> locationMap = new ConcurrentHashMap<>();

    public void updateLocation(String carCode, Location newLocation) {
        locationMap.put(carCode, newLocation);
    }


    public Location getLocation(String carCode) {
        return locationMap.get(carCode);
    }
}
