/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Brian T. Bailey
 */
public class AsiaEarthquakeRecord extends EarthquakeRecord {

    // Constructors
    public AsiaEarthquakeRecord(String eventDate, String hist_instr, String latitude, String longitude, String originTime, String continent, String depth, String momentMagnitude, String momentMagnitudeUncertainty, String bodyWaveMagnitude, String surfaceWaveMagnitude, String localMagnitude, String seismicMomentExpA, String seismicMomentExpB, String seismicMomentQuality, String seismicMomentInNm, String strikeNodalPlane1, String dipNodalPlane1, String rakeNodalPlane1, String strikeNodalPlane2, String dipNodalPlane2, String rakeNodalPlane2, String focalMechanismQuality, String dipDirectionPAxis, String dipPAxis, String dipDirectionTAxis, String dipTAxis, String dipDirectionBAxis, String dipBAxis, String stressRegime, String azimuthSHmax, String independent_dependent, String mainEventDate, String eventType, String tectonicAssoc, String source) {
        super(eventDate, hist_instr, latitude, longitude, originTime, continent, depth, momentMagnitude, momentMagnitudeUncertainty, bodyWaveMagnitude, surfaceWaveMagnitude, localMagnitude, seismicMomentExpA, seismicMomentExpB, seismicMomentQuality, seismicMomentInNm, strikeNodalPlane1, dipNodalPlane1, rakeNodalPlane1, strikeNodalPlane2, dipNodalPlane2, rakeNodalPlane2, focalMechanismQuality, dipDirectionPAxis, dipPAxis, dipDirectionTAxis, dipTAxis, dipDirectionBAxis, dipBAxis, stressRegime, azimuthSHmax, independent_dependent, mainEventDate, eventType, tectonicAssoc, source);
    }

    public AsiaEarthquakeRecord() {
    }
    
}