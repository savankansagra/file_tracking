package com.royal.filetracking.uploadexcels.helper;

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

import com.royal.filetracking.uploadexcels.model.GWORKSTPACleared;
import com.royal.filetracking.uploadexcels.model.GWORKSTPASent;

public class GWORKSTPAClearedHelper {

	public static List<GWORKSTPACleared> excelToGWORKSTPACleared(InputStream inputStream) throws IOException {
		List<GWORKSTPACleared> listOfGWORKSTPACleared = new ArrayList<>();
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
				GWORKSTPACleared gworksTPASent = getTPAClearedFromRow(currentRow);
				listOfGWORKSTPACleared.add(gworksTPASent);
				rowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		
		return listOfGWORKSTPACleared;
	}

	private static GWORKSTPACleared getTPAClearedFromRow(Row currentRow) {
		GWORKSTPACleared gworksTPACleared = new GWORKSTPACleared();
		int cellindex = 0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch(cellindex) {
			case 0: {
				gworksTPACleared.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gworksTPACleared.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gworksTPACleared.setTaluka(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 3: {
				gworksTPACleared.setVillage(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gworksTPACleared.setTpaDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 5: {
				gworksTPACleared.setTwentyFiveRelDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 6: {
				gworksTPACleared.setLapseDays(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gworksTPACleared.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 8: {
				gworksTPACleared.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gworksTPACleared.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 10: {
				gworksTPACleared.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 11: {
				gworksTPACleared.setStatus(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 12: {
				gworksTPACleared.setAdvPaymentAmt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 13: {
				gworksTPACleared.setAbortRemarks(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 14: {
				gworksTPACleared.setAbortRemarks2(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 15: {
				gworksTPACleared.setRemainingDaysForFreeze(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 16: {
				gworksTPACleared.setTpaAgency(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 17: {
				gworksTPACleared.setSystemNotInstalledDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 18: {
				gworksTPACleared.setEstMisCose(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 19: {
				gworksTPACleared.setType(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 20: {
				gworksTPACleared.setDaysLapesAfterAdvReleaseDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 21: {
				gworksTPACleared.setTpa(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 22: {
				gworksTPACleared.setTpaInwardDt(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 23: {
				gworksTPACleared.setApprovedTpaDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			default: 
				break;
			}
			cellindex++;
		}
		return gworksTPACleared;
	}

}
