package com.royal.filetracking.uploadexcels.helper.GWORKS;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.royal.filetracking.uploadexcels.helper.ExcelHelper;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSFPCleared;

public class GWORKSFinalPaymentClearedHelper {

	public static List<GWORKSFPCleared> excelToGWORKSInspSent(InputStream inputStream) throws IOException {
		List<GWORKSFPCleared> listOfGWORKSFPCleared = new ArrayList<>();
		Workbook workbook = new XSSFWorkbook(inputStream);
		try {
			Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
			while(rows.hasNext()) {
				Row currentRow = rows.next();
				// skip the header
				if(rowNumber == 0) {
					rowNumber++;
					continue;
				}
				GWORKSFPCleared gworksFPCleared = getFPClearedFromRow(currentRow);
				listOfGWORKSFPCleared.add(gworksFPCleared);
				rowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		
		return listOfGWORKSFPCleared;
	}

	private static GWORKSFPCleared getFPClearedFromRow(Row currentRow) {
		GWORKSFPCleared gworksFPCleared = new GWORKSFPCleared();
		int cellindex = 0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch(cellindex) {
			case 0: {
				gworksFPCleared.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gworksFPCleared.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gworksFPCleared.setTaluka(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 3: {
				gworksFPCleared.setVillage(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gworksFPCleared.setFpDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 5: {
				gworksFPCleared.setTwentyFiveRelDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gworksFPCleared.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gworksFPCleared.setInspectionAgency(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 8: {
				gworksFPCleared.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gworksFPCleared.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gworksFPCleared.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 11: {
				gworksFPCleared.setStatus(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 12: {
				gworksFPCleared.setEstMisCose(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 13: {
				gworksFPCleared.setMisCostExclusive(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 14: {
				gworksFPCleared.setInspectionChrg(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 15: {
				gworksFPCleared.setFinalPaymentAmount(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			default: 
				break;
			}
			cellindex++;
		}
		return gworksFPCleared;
	}

	
}
