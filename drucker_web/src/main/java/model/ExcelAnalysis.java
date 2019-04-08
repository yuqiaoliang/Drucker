package model;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelAnalysis {
    //plumbing
    protected double ReplacementFixture;
    protected double CostSaving;
    //light bulb
    protected double TotalCost;
    protected double ElectricitySaving;
    protected double MaintenanceSaving;

    public ExcelAnalysis() {
        //constructor
        this.ReplacementFixture=0;
        this.CostSaving=0;
        this.TotalCost=0;
        this.ElectricitySaving=0;
        this.MaintenanceSaving=0;
    }

    //get total result for light
    public void AddLight(double d1,double d2,double d3) {
        TotalCost += d1;
        ElectricitySaving += d2;
        MaintenanceSaving += d3;
    }

    //get total result for plumbing
    public void AddPlumbing(double d1,double d2) {
        ReplacementFixture += d1;
        CostSaving += d2;
    }

    public ArrayList<Double> LightAnalyse() throws InvalidFormatException, IOException {
        ArrayList<Double> results = new ArrayList<Double>();

        FileInputStream fsIP= new FileInputStream(new File("two.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
        HSSFSheet worksheet4 = wb.getSheetAt(3);
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

        Cell a = worksheet4.getRow(7).getCell(2); //capital investment
        Cell b = worksheet4.getRow(9).getCell(3); //electricity saving
        Cell c = worksheet4.getRow(10).getCell(3); //maintenance saving

        a.setCellValue(- this.TotalCost);
        b.setCellValue(this.ElectricitySaving);
        c.setCellValue(this.MaintenanceSaving);

        fsIP.close();

        Cell o1 = worksheet4.getRow(2).getCell(2); //NPV
        Cell o2 = worksheet4.getRow(3).getCell(2); //IRR
        Cell o3 = worksheet4.getRow(4).getCell(2); //simple payback

        //evaluate the excel
        for(int i=2;i<11;i++) {
            for(int j=7;j<19;j++) {
                evaluator.evaluateFormulaCell(worksheet4.getRow(j).getCell(i));
            }
        }

        //evaluate the result
        evaluator.evaluateFormulaCell(o1);
        evaluator.evaluateFormulaCell(o2);
        evaluator.evaluateFormulaCell(o3);

        System.out.println(o1.getNumericCellValue());
        System.out.println(o2.getNumericCellValue());
        System.out.println(o3.getNumericCellValue());

        results.add(o1.getNumericCellValue());
        results.add(o2.getNumericCellValue());
        results.add(o3.getNumericCellValue());

        FileOutputStream output_file =new FileOutputStream(new File("two.xls"));
        wb.write(output_file);
        wb.close();
        output_file.close();
        return results;
    }

    public ArrayList<Double> PlumbingAnalyse() throws InvalidFormatException, IOException {
        ArrayList<Double> results = new ArrayList<Double>();

        FileInputStream fsIP= new FileInputStream(new File("two.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
        HSSFSheet worksheet3 = wb.getSheetAt(2);
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

        Cell a = worksheet3.getRow(7).getCell(2); //capital investment
        Cell b = worksheet3.getRow(9).getCell(3); //water saving

        a.setCellValue(- this.ReplacementFixture);
        b.setCellValue(this.CostSaving);

        fsIP.close();

        Cell o1 = worksheet3.getRow(2).getCell(2); // NPV
        Cell o2 = worksheet3.getRow(3).getCell(2); //IRR
        Cell o3 = worksheet3.getRow(4).getCell(2); //payback period

        //evaluate the excel
        for(int i=2;i<34;i++) {
            for(int j=7;j<19;j++) {
                evaluator.evaluateFormulaCell(worksheet3.getRow(j).getCell(i));
            }
        }

        //evaluate the result
        evaluator.evaluateFormulaCell(o1);
        evaluator.evaluateFormulaCell(o2);
        evaluator.evaluateFormulaCell(o3);

        System.out.println(o1.getNumericCellValue());
        System.out.println(o2.getNumericCellValue());
        System.out.println(o3.getNumericCellValue());

        results.add(o1.getNumericCellValue());
        results.add(o2.getNumericCellValue());
        results.add(o3.getNumericCellValue());

        FileOutputStream output_file =new FileOutputStream(new File("two.xls"));
        wb.write(output_file);
        wb.close();
        output_file.close();
        return results;
    }
}
