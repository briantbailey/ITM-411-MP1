/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Brian T. Bailey
 */
public abstract class EarthquakeRecord implements EarthquakeRelatable, Comparable {
    
    // Declare EarthquakeRecord Class Fields...
    protected String eventDate;
    protected String hist_instr;
    protected String latitude;
    protected String longitude;
    protected String originTime;
    protected String continent;
    protected String depth;
    protected String momentMagnitude;
    protected String momentMagnitudeUncertainty;
    protected String bodyWaveMagnitude;
    protected String surfaceWaveMagnitude;
    protected String localMagnitude;
    protected String seismicMomentExpA;
    protected String seismicMomentExpB;
    protected String seismicMomentQuality;
    protected String seismicMomentInNm;
    protected String strikeNodalPlane1;
    protected String dipNodalPlane1;
    protected String rakeNodalPlane1;
    protected String strikeNodalPlane2;
    protected String dipNodalPlane2;
    protected String rakeNodalPlane2;
    protected String focalMechanismQuality;
    protected String dipDirectionPAxis;
    protected String dipPAxis;
    protected String dipDirectionTAxis;
    protected String dipTAxis;
    protected String dipDirectionBAxis;
    protected String dipBAxis;
    protected String stressRegime;
    protected String azimuthSHmax;
    protected String independent_dependent;
    protected String mainEventDate;
    protected String eventType;
    protected String tectonicAssoc;
    protected String source;
    
    
    // Constructors....
    public EarthquakeRecord() {
    }
    
    public EarthquakeRecord(String eventDate, String hist_instr, String latitude, String longitude, String originTime, String continent, String depth, String momentMagnitude, String momentMagnitudeUncertainty, String bodyWaveMagnitude, String surfaceWaveMagnitude, String localMagnitude, String seismicMomentExpA, String seismicMomentExpB, String seismicMomentQuality, String seismicMomentInNm, String strikeNodalPlane1, String dipNodalPlane1, String rakeNodalPlane1, String strikeNodalPlane2, String dipNodalPlane2, String rakeNodalPlane2, String focalMechanismQuality, String dipDirectionPAxis, String dipPAxis, String dipDirectionTAxis, String dipTAxis, String dipDirectionBAxis, String dipBAxis, String stressRegime, String azimuthSHmax, String independent_dependent, String mainEventDate, String eventType, String tectonicAssoc, String source) {
        setEventDate(eventDate);
        this.hist_instr = hist_instr;
        this.latitude = latitude;
        this.longitude = longitude;
        this.originTime = originTime;
        this.continent = continent;
        this.depth = depth;
        this.momentMagnitude = momentMagnitude;
        this.momentMagnitudeUncertainty = momentMagnitudeUncertainty;
        this.bodyWaveMagnitude = bodyWaveMagnitude;
        this.surfaceWaveMagnitude = surfaceWaveMagnitude;
        this.localMagnitude = localMagnitude;
        this.seismicMomentExpA = seismicMomentExpA;
        this.seismicMomentExpB = seismicMomentExpB;
        this.seismicMomentQuality = seismicMomentQuality;
        this.seismicMomentInNm = seismicMomentInNm;
        this.strikeNodalPlane1 = strikeNodalPlane1;
        this.dipNodalPlane1 = dipNodalPlane1;
        this.rakeNodalPlane1 = rakeNodalPlane1;
        this.strikeNodalPlane2 = strikeNodalPlane2;
        this.dipNodalPlane2 = dipNodalPlane2;
        this.rakeNodalPlane2 = rakeNodalPlane2;
        this.focalMechanismQuality = focalMechanismQuality;
        this.dipDirectionPAxis = dipDirectionPAxis;
        this.dipPAxis = dipPAxis;
        this.dipDirectionTAxis = dipDirectionTAxis;
        this.dipTAxis = dipTAxis;
        this.dipDirectionBAxis = dipDirectionBAxis;
        this.dipBAxis = dipBAxis;
        this.stressRegime = stressRegime;
        this.azimuthSHmax = azimuthSHmax;
        this.independent_dependent = independent_dependent;
        this.mainEventDate = mainEventDate;
        this.eventType = eventType;
        this.tectonicAssoc = tectonicAssoc;
        this.source = source;
    }
    
    
    // Getters and Setters...
    public String getAzimuthSHmax() {
        return azimuthSHmax;
    }

    public void setAzimuthSHmax(String azimuthSHmax) {
        this.azimuthSHmax = azimuthSHmax;
    }

    public String getBodyWaveMagnitude() {
        return bodyWaveMagnitude;
    }

    public void setBodyWaveMagnitude(String bodyWaveMagnitude) {
        this.bodyWaveMagnitude = bodyWaveMagnitude;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getDipBAxis() {
        return dipBAxis;
    }

    public void setDipBAxis(String dipBAxis) {
        this.dipBAxis = dipBAxis;
    }

    public String getDipDirectionBAxis() {
        return dipDirectionBAxis;
    }

    public void setDipDirectionBAxis(String dipDirectionBAxis) {
        this.dipDirectionBAxis = dipDirectionBAxis;
    }

    public String getDipDirectionPAxis() {
        return dipDirectionPAxis;
    }

    public void setDipDirectionPAxis(String dipDirectionPAxis) {
        this.dipDirectionPAxis = dipDirectionPAxis;
    }

    public String getDipDirectionTAxis() {
        return dipDirectionTAxis;
    }

    public void setDipDirectionTAxis(String dipDirectionTAxis) {
        this.dipDirectionTAxis = dipDirectionTAxis;
    }

    public String getDipNodalPlane1() {
        return dipNodalPlane1;
    }

    public void setDipNodalPlane1(String dipNodalPlane1) {
        this.dipNodalPlane1 = dipNodalPlane1;
    }

    public String getDipNodalPlane2() {
        return dipNodalPlane2;
    }

    public void setDipNodalPlane2(String dipNodalPlane2) {
        this.dipNodalPlane2 = dipNodalPlane2;
    }

    public String getDipPAxis() {
        return dipPAxis;
    }

    public void setDipPAxis(String dipPAxis) {
        this.dipPAxis = dipPAxis;
    }

    public String getDipTAxis() {
        return dipTAxis;
    }

    public void setDipTAxis(String dipTAxis) {
        this.dipTAxis = dipTAxis;
    }

    public String getEventDate() {
        String day, month, year;
        if (eventDate.length() == 7) {
            year = eventDate.substring(0, 3);
            month = eventDate.substring(3, 5);
            day = eventDate.substring(5, 7);
        } else if (eventDate.length() == 8){
            year = eventDate.substring(0, 4);
            month = eventDate.substring(4, 6);
            day = eventDate.substring(6, 8);
        } else {
            year = "-";
            month = "";
            day = "";
        }
        int monthInt = Integer.parseInt(month);
        switch (monthInt) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        return month + " " + day + ", " + year;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getFocalMechanismQuality() {
        return focalMechanismQuality;
    }

    public void setFocalMechanismQuality(String focalMechanismQuality) {
        this.focalMechanismQuality = focalMechanismQuality;
    }

    public String getHist_instr() {
        return hist_instr;
    }

    public void setHist_instr(String hist_instr) {
        this.hist_instr = hist_instr;
    }

    public String getIndependent_dependent() {
        return independent_dependent;
    }

    public void setIndependent_dependent(String independent_dependent) {
        this.independent_dependent = independent_dependent;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocalMagnitude() {
        return localMagnitude;
    }

    public void setLocalMagnitude(String localMagnitude) {
        this.localMagnitude = localMagnitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMainEventDate() {
       return mainEventDate;
    }

    public void setMainEventDate(String mainEventDate) {
        this.mainEventDate = mainEventDate;
    }

    public String getMomentMagnitude() {
        return momentMagnitude;
    }

    public void setMomentMagnitude(String momentMagnitude) {
        this.momentMagnitude = momentMagnitude;
    }

    public String getMomentMagnitudeUncertainty() {
        return momentMagnitudeUncertainty;
    }

    public void setMomentMagnitudeUncertainty(String momentMagnitudeUncertainty) {
        this.momentMagnitudeUncertainty = momentMagnitudeUncertainty;
    }

    public String getOriginTime() {
        return originTime;
    }

    public void setOriginTime(String originTime) {
        this.originTime = originTime;
    }

    public String getRakeNodalPlane1() {
        return rakeNodalPlane1;
    }

    public void setRakeNodalPlane1(String rakeNodalPlane1) {
        this.rakeNodalPlane1 = rakeNodalPlane1;
    }

    public String getRakeNodalPlane2() {
        return rakeNodalPlane2;
    }

    public void setRakeNodalPlane2(String rakeNodalPlane2) {
        this.rakeNodalPlane2 = rakeNodalPlane2;
    }

    public String getSeismicMomentExpA() {
        return seismicMomentExpA;
    }

    public void setSeismicMomentExpA(String seismicMomentExpA) {
        this.seismicMomentExpA = seismicMomentExpA;
    }

    public String getSeismicMomentExpB() {
        return seismicMomentExpB;
    }

    public void setSeismicMomentExpB(String seismicMomentExpB) {
        this.seismicMomentExpB = seismicMomentExpB;
    }

    public String getSeismicMomentInNm() {
        return seismicMomentInNm;
    }

    public void setSeismicMomentInNm(String seismicMomentInNm) {
        this.seismicMomentInNm = seismicMomentInNm;
    }

    public String getSeismicMomentQuality() {
        return seismicMomentQuality;
    }

    public void setSeismicMomentQuality(String seismicMomentQuality) {
        this.seismicMomentQuality = seismicMomentQuality;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStressRegime() {
        return stressRegime;
    }

    public void setStressRegime(String stressRegime) {
        this.stressRegime = stressRegime;
    }

    public String getStrikeNodalPlane1() {
        return strikeNodalPlane1;
    }

    public void setStrikeNodalPlane1(String strikeNodalPlane1) {
        this.strikeNodalPlane1 = strikeNodalPlane1;
    }

    public String getStrikeNodalPlane2() {
        return strikeNodalPlane2;
    }

    public void setStrikeNodalPlane2(String strikeNodalPlane2) {
        this.strikeNodalPlane2 = strikeNodalPlane2;
    }

    public String getSurfaceWaveMagnitude() {
        return surfaceWaveMagnitude;
    }

    public void setSurfaceWaveMagnitude(String surfaceWaveMagnitude) {
        this.surfaceWaveMagnitude = surfaceWaveMagnitude;
    }

    public String getTectonicAssoc() {
        return tectonicAssoc;
    }

    public void setTectonicAssoc(String tectonicAssoc) {
        this.tectonicAssoc = tectonicAssoc;
    }
    
    
    // toString method
    @Override
    public String toString() {
        return "EarthquakeRecord{" + "eventDate=" + getEventDate() + ", hist_instr=" + hist_instr + ", latitude=" + latitude + ", longitude=" + longitude + ", originTime=" + originTime + ", continent=" + continent + ", depth=" + depth + ", momentMagnitude=" + momentMagnitude + ", momentMagnitudeUncertainty=" + momentMagnitudeUncertainty + ", bodyWaveMagnitude=" + bodyWaveMagnitude + ", surfaceWaveMagnitude=" + surfaceWaveMagnitude + ", localMagnitude=" + localMagnitude + ", seismicMomentExpA=" + seismicMomentExpA + ", seismicMomentExpB=" + seismicMomentExpB + ", seismicMomentQuality=" + seismicMomentQuality + ", seismicMomentInNm=" + seismicMomentInNm + ", strikeNodalPlane1=" + strikeNodalPlane1 + ", dipNodalPlane1=" + dipNodalPlane1 + ", rakeNodalPlane1=" + rakeNodalPlane1 + ", strikeNodalPlane2=" + strikeNodalPlane2 + ", dipNodalPlane2=" + dipNodalPlane2 + ", rakeNodalPlane2=" + rakeNodalPlane2 + ", focalMechanismQuality=" + focalMechanismQuality + ", dipDirectionPAxis=" + dipDirectionPAxis + ", dipPAxis=" + dipPAxis + ", dipDirectionTAxis=" + dipDirectionTAxis + ", dipTAxis=" + dipTAxis + ", dipDirectionBAxis=" + dipDirectionBAxis + ", dipBAxis=" + dipBAxis + ", stressRegime=" + stressRegime + ", azimuthSHmax=" + azimuthSHmax + ", independent_dependent=" + independent_dependent + ", mainEventDate=" + getMainEventDate() + ", eventType=" + eventType + ", tectonicAssoc=" + tectonicAssoc + ", source=" + source + '}';
    }
    
    
    // EarthquakeRelatable Interface Implementation
    @Override
    public String findMaxEarthquakesPerContinent(EarthquakeRecord[] records) {
        // Declare integer to hold the number of earthquakes and count array length
        int numberOfEarthquakes = records.length;
        
        // Return total earthquakes for given EarthquakeRecord Array as String
        return Integer.toString(numberOfEarthquakes);     
    }

    @Override
    public String findMinEarthquakesPerContinent(EarthquakeRecord[] records) {
        // Declare integer to hold the number of earthquakes and count array length
        int numberOfEarthquakes = records.length;
        
        // Return 1 if there are any earthquakes, Return 0 if there are no earthquakes
        if (numberOfEarthquakes > 0) {
            return "1";
        } else {
            return "0";
        }
    }

    @Override
    public String findNewestEarthquakePerContinent(EarthquakeRecord[] records) {
        // Clone the array to avoid changing the existing one
        EarthquakeRecord[] sortedArray = records.clone();
        
        // Sort the array in descending order
        Arrays.sort(sortedArray, Collections.reverseOrder());
        
        // Return the first EarthquakeRecord Object in the array as string
        return sortedArray[0].toString();
    }

    @Override
    public String findOldestEarthquakePerContinent(EarthquakeRecord[] records) {
        // Clone the array to avoid changing the existing one
        EarthquakeRecord[] sortedArray = records.clone();
        
        // Sort the array in ascending order
        Arrays.sort(sortedArray);
        
        // Return the first EarthquakeRecord Object in the array as string
        return sortedArray[0].toString();
    }

    @Override
    public int compareTo(Object t) {
        // This method is used for sorting the objects by event date
        EarthquakeRecord thatRecord = (EarthquakeRecord) t;
        Integer thisDate = new Integer(this.eventDate);
        Integer thatDate = new Integer(thatRecord.eventDate);
        return thisDate - thatDate;
    }
    
    
    
}