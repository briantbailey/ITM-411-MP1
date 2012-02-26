/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Brian T. Bailey
 */
public interface EarthquakeRelatable {
    String findOldestEarthquakePerContinent(EarthquakeRecord[] records);
    String findNewestEarthquakePerContinent(EarthquakeRecord[] records);
    String findMaxEarthquakesPerContinent(EarthquakeRecord[] records);
    String findMinEarthquakesPerContinent(EarthquakeRecord[] records);
}
