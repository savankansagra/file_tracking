package com.royal.filetracking.uploadexcels.helper;

import java.io.IOException;
import java.io.InputStream;import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.royal.filetracking.uploadexcels.model.GWORKSWoRcvd;

public class GWORKSWoRcvdHelper {

	public static List<GWORKSWoRcvd> excelToGWORKSWorkOrderReceived(InputStream inputStream) throws IOException {
		List<GWORKSWoRcvd> listOfGWORKSWoRcvd = new ArrayList<>();
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
				GWORKSWoRcvd gworksWoRcvd = getPendingWorkOrderFromRow(currentRow);
				listOfGWORKSWoRcvd.add(gworksWoRcvd);
				rowNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
		}
		
		return listOfGWORKSWoRcvd;
	}

	private static GWORKSWoRcvd getPendingWorkOrderFromRow(Row currentRow) {
		GWORKSWoRcvd gworksWoRcvd = new GWORKSWoRcvd();
		int cellindex = 0;
		
		Iterator<Cell> cellsInRow = currentRow.iterator();
		while(cellsInRow.hasNext()) {
			Cell currentCell = cellsInRow.next();
			switch(cellindex) {
			case 0: {
				gworksWoRcvd.setRegNo(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 1: {
				gworksWoRcvd.setRegDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 2: {
				gworksWoRcvd.setTaluka(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 3: {
				gworksWoRcvd.setVillage(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 4: {
				gworksWoRcvd.setWoDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Date.class));
				break;
			}
			case 5: {
				gworksWoRcvd.setLapseDays(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 6: {
				gworksWoRcvd.setFarmerName(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 7: {
				gworksWoRcvd.setMisSystem(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 8: {
				gworksWoRcvd.setLoanneNonLoanee(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 9: {
				gworksWoRcvd.setAreaHec(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 10: {
				gworksWoRcvd.setStatus(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 11: {
				gworksWoRcvd.setEstMisCose(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 12: {
				gworksWoRcvd.setRemaingDaysForAutoDelete(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 13: {
				gworksWoRcvd.setEstimatedSubsidyAmount(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Double.class));
				break;
			}
			case 14: {
				gworksWoRcvd.setEstTribleSubsidyAmount(ExcelHelper.getSpecificTypeValueFromCell(currentCell, Integer.class));
				break;
			}
			case 15: {
				gworksWoRcvd.setTPASignedDate(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			case 16: {
				gworksWoRcvd.setTPASignedLapsDays(ExcelHelper.getSpecificTypeValueFromCell(currentCell, String.class));
				break;
			}
			default: 
				break;
			}
			cellindex++;
		}
		return gworksWoRcvd;
	}

	
}
