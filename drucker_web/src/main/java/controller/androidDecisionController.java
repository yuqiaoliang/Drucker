package controller;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import model.ExcelAnalysis;
import model.ExcelModify;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class androidDecisionController {

    @GetMapping(value="/lightModul")
    public @ResponseBody decisionResult lighting(@RequestParam("x1") Double x1, @RequestParam("x2") Double x2, @RequestParam("x3") Double x3,
                                                 @RequestParam("s1") String s1, @RequestParam("s2") String s2, @RequestParam("x4") Double x4,
                                                 @RequestParam("x11") Double x11, @RequestParam("x5") Double x5, @RequestParam("x12") Double x12,
                                                 @RequestParam("x6") Double x6, @RequestParam("x13") Double x13, @RequestParam("x7") Double x7,
                                                 @RequestParam("x14") Double x14, @RequestParam("x8") Double x8, @RequestParam("x15") Double x15,
                                                 @RequestParam("x9") Double x9, @RequestParam("x16") Double x16, @RequestParam("x10") Double x10,
                                                 @RequestParam("x17") Double x17, @RequestParam("x18") Double x18) {

        ExcelAnalysis analysis = new ExcelAnalysis();
        ExcelModify modify = new ExcelModify();
        decisionResult lightingResults = new decisionResult();
        try{
            modify.Light(analysis, x1, x2, x3, s1, x4, x5, x6, x7, x8, x9, x10, s2, x11, x12, x13, x14, x15, x16, x17, x18);
            ArrayList<Double> lResults = analysis.LightAnalyse();
            lightingResults.setEscaltingRate(0.03);//fixed

            lightingResults.setNpv(lResults.get(0));
            lightingResults.setIrr(lResults.get(1));
            lightingResults.setSimplyPaybackPeriod(lResults.get(2));

            return lightingResults;
        } catch(Exception e){
            System.out.println("lighting excel error");
            return lightingResults;
        }


    }

    @GetMapping(value="/PlumbModul")
    public @ResponseBody decisionResult plumbing(@RequestParam("y1") Double y1, @RequestParam("y2") Double y2,
                                                 @RequestParam("y3") Double y3, @RequestParam("s1") String s1,
                                                 @RequestParam("s2") String s2, @RequestParam("y4") Double y4,
                                                 @RequestParam("y8") Double y8, @RequestParam("y5") Double y5,
                                                 @RequestParam("y9") Double y9, @RequestParam("y6") Double y6,
                                                 @RequestParam("y10") Double y10, @RequestParam("y7") Double y7,
                                                 @RequestParam("y11") Double y11, @RequestParam("y12") Double y12){

        ExcelAnalysis analysis = new ExcelAnalysis();
        ExcelModify modify = new ExcelModify();
        decisionResult plumbingResults = new decisionResult();

        try{
            modify.Plumbing(analysis, y1, y2, y3, s1, y4, y5, y6, y7, s2, y8, y9, y10, y11, y12);
            ArrayList<Double> pResults = analysis.PlumbingAnalyse();
            plumbingResults.setEscaltingRate(0.03);//fixed

            plumbingResults.setNpv(pResults.get(0));
            plumbingResults.setIrr(pResults.get(1));
            plumbingResults.setSimplyPaybackPeriod(pResults.get(2));

            return plumbingResults;
        } catch(Exception e){
            System.out.println("plumbing excel error");
            return plumbingResults;
        } /*catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
            e.printStackTrace();
            return plumbingResults;
        }*/

    }


}
