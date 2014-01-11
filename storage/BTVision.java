/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt.storage;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.*;

/**
 *
 * @author Dlock
 */
public class BTVision {
    private BTStorage storage;
    private AxisCamera cam = AxisCamera.getInstance();
    private ColorImage image;
    private BinaryImage thresholdImage;
    private BinaryImage bigObjectsImage;
    private BinaryImage convexHullImage;
    private BinaryImage filteredImage;
    private CriteriaCollection cc;
    private ParticleAnalysisReport[] reports;
    
    public BTVision(BTStorage storage)
    {
        this.storage = storage;
        storage.health.setupHealthClass("BTVision");
        //Criteria for rectangle we are trying to find:
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, Constants.CAM_WIDTH_LOW , Constants.CAM_WIDTH_HIGH, false);
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, Constants.CAM_HEIGHT_LOW, Constants.CAM_HEIGHT_HIGH, false);
    }
    
    public void update()
    {
        try {
            //grabs image from camera
            image = cam.getImage();
            //filters only the color into the image
            thresholdImage = image.thresholdRGB(Constants.RED_LOW_THRESHOLD, 
                                                Constants.RED_HIGH_THRESHOLD,
                                                Constants.GREEN_LOW_THRESHOLD,
                                                Constants.GREEN_HIGH_THRESHOLD,
                                                Constants.BLUE_LOW_THRESHOLD,
                                                Constants.BLUE_HIGH_THRESHOLD);
            //removes small objects from the picture
            bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);
            //creates a solid in shapes
            convexHullImage = bigObjectsImage.convexHull(false);
            //looks for shape defined
            filteredImage = convexHullImage.particleFilter(cc);
            //reports telling all about the image that was filtered through
            reports = filteredImage.getOrderedParticleAnalysisReports();
            
            
        } catch (AxisCameraException ex) {
            storage.debug.write(Constants.DebugLocation.BTVision, Constants.Severity.SEVERE, "Error Axis Camera Exception: "+ex);
        } catch (NIVisionException ex) {
            storage.debug.write(Constants.DebugLocation.BTVision, Constants.Severity.SEVERE, "Error NIVision Exception: "+ex);
        }
        try {
            thresholdImage.free();
            convexHullImage.free();
            filteredImage.free();
            bigObjectsImage.free();
            image.free();
        } catch (NIVisionException ex) {
            storage.debug.write(Constants.DebugLocation.BTVision, Constants.Severity.SEVERE, "Error freeing space NIVision Exception: "+ex);
        }
        
    }
}
