package model;
//import java.sql.*;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelModify {
    private static void LightRetrofit(double aa, double bb, double cc, double dd, double ff, double gg, double hh, double ii, double jj, double kk, double ll) throws InvalidFormatException, IOException {
        FileInputStream fsIP = new FileInputStream(new File("abc.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
        HSSFSheet worksheet = wb.getSheetAt(0);

        Cell a = worksheet.getRow(10).getCell(2);
        Cell b = worksheet.getRow(11).getCell(2);
        Cell c = worksheet.getRow(12).getCell(2);
        Cell d = worksheet.getRow(13).getCell(2);
        Cell f = worksheet.getRow(22).getCell(2);
        Cell g = worksheet.getRow(23).getCell(2);
        Cell h = worksheet.getRow(24).getCell(2);
        Cell i = worksheet.getRow(25).getCell(2);
        Cell j = worksheet.getRow(26).getCell(2);
        Cell k = worksheet.getRow(27).getCell(2);
        Cell l = worksheet.getRow(28).getCell(2);

        a.setCellValue(aa);
        b.setCellValue(bb);
        c.setCellValue(cc);
        d.setCellValue(dd);
        f.setCellValue(ff);
        g.setCellValue(gg);
        h.setCellValue(hh);
        i.setCellValue(ii);
        j.setCellValue(jj);
        k.setCellValue(kk);
        l.setCellValue(ll);

        fsIP.close();
        HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);

        FileOutputStream output_file = new FileOutputStream(new File("abc.xls"));
        wb.write(output_file);
        wb.close();
        output_file.close();
        System.out.println("Done");
    }

    //light excel
    public static void Light(ExcelAnalysis analysis, double x1, double x2, double x3, String s1, double x4, double x5, double x6, double x7, double x8, double x9, double x10, String s2, double x11, double x12, double x13, double x14, double x15, double x16, double x17, double x18) throws InvalidFormatException, IOException {
        FileInputStream fsIP = new FileInputStream(new File("../../resources/two.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
        HSSFSheet worksheet = wb.getSheetAt(0);
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

        Cell a = worksheet.getRow(6).getCell(2); //electricity rate
        Cell b = worksheet.getRow(8).getCell(2); //tax rate
        Cell c = worksheet.getRow(9).getCell(2); //return
        Cell d = worksheet.getRow(14).getCell(2); //number of bulbs
        Cell e = worksheet.getRow(15).getCell(2); //price
        Cell f = worksheet.getRow(16).getCell(2); //wattage
        Cell g = worksheet.getRow(17).getCell(2); //lumens
        Cell h = worksheet.getRow(18).getCell(2); //lifespan
        Cell i = worksheet.getRow(19).getCell(2); //weekday
        Cell j = worksheet.getRow(20).getCell(2); //weekend
        Cell k = worksheet.getRow(14).getCell(4); //number of bulbs
        Cell l = worksheet.getRow(15).getCell(4); //price
        Cell m = worksheet.getRow(16).getCell(4); //wattage
        Cell n = worksheet.getRow(17).getCell(4); //lumens
        Cell o = worksheet.getRow(18).getCell(4); //lifespan
        Cell p = worksheet.getRow(19).getCell(4); //weekday
        Cell q = worksheet.getRow(20).getCell(4); //weekend
        Cell r = worksheet.getRow(15).getCell(7); //rebates
        Cell ss1 = worksheet.getRow(13).getCell(2); //fixture type
        Cell ss2 = worksheet.getRow(13).getCell(4); //fixture type

        a.setCellValue(x1);
        b.setCellValue(x2);
        c.setCellValue(x3);
        d.setCellValue(x4);
        e.setCellValue(x5);
        f.setCellValue(x6);
        g.setCellValue(x7);
        h.setCellValue(x8);
        i.setCellValue(x9);
        j.setCellValue(x10);
        k.setCellValue(x11);
        l.setCellValue(x12);
        m.setCellValue(x13);
        n.setCellValue(x14);
        o.setCellValue(x15);
        p.setCellValue(x16);
        q.setCellValue(x17);
        r.setCellValue(x18);
        ss1.setCellValue(s1);
        ss2.setCellValue(s2);

        fsIP.close();

        Cell o1 = worksheet.getRow(13).getCell(7); //bulb costs
        Cell o2 = worksheet.getRow(16).getCell(7); //total costs
        Cell o3 = worksheet.getRow(17).getCell(7); //maintenance saving
        Cell o4 = worksheet.getRow(18).getCell(7); //electricity saving
        Cell o5 = worksheet.getRow(19).getCell(7); //annual saving
        Cell o6 = worksheet.getRow(20).getCell(7); //GHC saving
        Cell o7 = worksheet.getRow(21).getCell(7); //life span

        evaluator.evaluateFormulaCell(o1);
        evaluator.evaluateFormulaCell(o2);
        evaluator.evaluateFormulaCell(o3);
        evaluator.evaluateFormulaCell(o4);
        evaluator.evaluateFormulaCell(o5);
        evaluator.evaluateFormulaCell(o6);
        evaluator.evaluateFormulaCell(o7);

        //TotalCost, ElectricitySaving, MaintenanceSaving
        analysis.AddLight(o2.getNumericCellValue(), o4.getNumericCellValue(), o3.getNumericCellValue());

        FileOutputStream output_file = new FileOutputStream(new File("two.xls"));
        wb.write(output_file);
        wb.close();
        output_file.close();
        System.out.println("Light Done");
    }

    //plumbing excel
    private static void Plumbing(ExcelAnalysis analysis, double y1, double y2, double y3, String s1, double y4, double y5, double y6, double y7, String s2, double y8, double y9, double y10, double y11, double y12) throws InvalidFormatException, IOException {
        FileInputStream fsIP = new FileInputStream(new File("two.xls"));
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
        HSSFSheet worksheet2 = wb.getSheetAt(1);
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

        Cell a = worksheet2.getRow(5).getCell(2); //water cost
        Cell b = worksheet2.getRow(7).getCell(2); //tax rate
        Cell c = worksheet2.getRow(8).getCell(2); //return
        Cell d = worksheet2.getRow(13).getCell(2); //number of fixture
        Cell e = worksheet2.getRow(14).getCell(2); //price
        Cell f = worksheet2.getRow(15).getCell(2); //flow rate
        Cell g = worksheet2.getRow(16).getCell(2); //estimated hours
        Cell h = worksheet2.getRow(13).getCell(4); //fixtures
        Cell i = worksheet2.getRow(14).getCell(4); //price
        Cell j = worksheet2.getRow(15).getCell(4); //flow rate
        Cell k = worksheet2.getRow(16).getCell(4); //estimated hours
        Cell l = worksheet2.getRow(13).getCell(7); //rebates
        Cell ss1 = worksheet2.getRow(12).getCell(2); //fixture type
        Cell ss2 = worksheet2.getRow(12).getCell(4); //fixture type

        a.setCellValue(y1);
        b.setCellValue(y2);
        c.setCellValue(y3);
        d.setCellValue(y4);
        e.setCellValue(y5);
        f.setCellValue(y6);
        g.setCellValue(y7);
        h.setCellValue(y8);
        i.setCellValue(y9);
        j.setCellValue(y10);
        k.setCellValue(y11);
        l.setCellValue(y12);
        ss1.setCellValue(s1);
        ss2.setCellValue(s2);

        fsIP.close();

        Cell o1 = worksheet2.getRow(12).getCell(7); //fixture
        Cell o2 = worksheet2.getRow(14).getCell(7); //total costs
        Cell o3 = worksheet2.getRow(15).getCell(7); //water saving
        Cell o4 = worksheet2.getRow(16).getCell(7); //cost saving

        evaluator.evaluateFormulaCell(o1);
        evaluator.evaluateFormulaCell(o2);
        evaluator.evaluateFormulaCell(o3);
        evaluator.evaluateFormulaCell(o4);

        //ReplacementFixture, CostSaving
        analysis.AddPlumbing(o1.getNumericCellValue(), o4.getNumericCellValue());

        FileOutputStream output_file = new FileOutputStream(new File("two.xls"));
        wb.write(output_file);
        wb.close();
        output_file.close();
        System.out.println("Plumbing Done");
    }
}
